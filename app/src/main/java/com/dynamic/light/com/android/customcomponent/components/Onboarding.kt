package com.dynamic.light.com.android.customcomponent.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.dynamic.light.com.android.customcomponent.R

class Onboarding @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // Indicadores pag

    // Indicator Colors
    private var pageIndicatorRadius: Float = 0f
    private var pageIndicatorStrokeWidth: Float = 0f
    private var pageIndicatorStrokeColor: Int = 0
    private var pageIndicatorColor: Int = 0
    private var pageIndicatorSelectedColor: Int = 0

    // Background Colors
    private var pageBackgroundColor: Int = 0

    private val paint = Paint()
    private val backgroundRect = Rect(0, 0, 0, 0)

    init {

        id = generateViewId()

        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Onboarding)

        pageIndicatorRadius = typedArray.getFloat(R.styleable.Onboarding_pageIndicatorRadius, 20f)
        pageIndicatorStrokeWidth = typedArray.getFloat(R.styleable.Onboarding_pageIndicatorStrokeWidth, 1f)

        pageIndicatorStrokeColor = typedArray.getColor(R.styleable.Onboarding_pageIndicatorStrokeColor, Color.BLACK)

        pageIndicatorColor = typedArray.getColor(R.styleable.Onboarding_pageIndicatorColor, Color.GRAY)
        pageIndicatorSelectedColor = typedArray.getColor(R.styleable.Onboarding_pageIndicatorSelectedColor, Color.DKGRAY)

        pageBackgroundColor = typedArray.getColor(R.styleable.Onboarding_pageBackgroundColor, Color.LTGRAY)


        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {

        // Draw Background
        drawBackground(canvas)

        // Draw Indicator
        drawPageIndicator(canvas)
    }

    private fun drawBackground(canvas: Canvas) {

        paint.color = pageBackgroundColor
        paint.style = Paint.Style.FILL
        backgroundRect.set(0, 0 , 1100, measuredHeight)
        canvas.drawRect(backgroundRect, paint)
    }

    private fun drawPageIndicator(canvas: Canvas) {

    //    val bottomPos = measuredHeight - pageIndicatorRadius - dpToPx(9f)
    //    val leftPos = measuredWidth / 5f - pageIndicatorRadius / 5f

        paint.color = pageIndicatorStrokeColor
        canvas.drawCircle(450f, 1800f, pageIndicatorRadius + pageIndicatorStrokeWidth, paint)

        paint.color = pageIndicatorColor
        canvas.drawCircle(450f, 1800f, pageIndicatorRadius, paint)

        paint.color = pageIndicatorStrokeColor
        canvas.drawCircle(550f, 1800f, pageIndicatorRadius + pageIndicatorStrokeWidth, paint)

        paint.color = pageIndicatorColor
        canvas.drawCircle(550f, 1800f, pageIndicatorRadius, paint)

        paint.color = pageIndicatorStrokeColor
        canvas.drawCircle(650f, 1800f, pageIndicatorRadius + pageIndicatorStrokeWidth, paint)

        paint.color = pageIndicatorColor
        canvas.drawCircle(650f, 1800f, pageIndicatorRadius, paint)


    }

    private fun dpToPx(value: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)

}