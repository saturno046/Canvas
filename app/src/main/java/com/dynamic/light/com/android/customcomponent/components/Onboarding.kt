package com.dynamic.light.com.android.customcomponent.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.dynamic.light.com.android.customcomponent.R

class Onboarding @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // Indicator Colors
    private var pageIndicatorRadius: Float = 0f
    private var pageIndicatorStrokeWidth: Float = 0f
    private var pageIndicatorStrokeColor: Int = 0
    private var pageIndicatorColor: Int = 0
    private var pageIndicatorSelectedColor: Int = 0

    // Background Colors
    private var pageBackgroundColor: Int = 0

    private var currentPage: Int = 1
    private var nextPage: Int = 1
    private var direction: Float= 0f

    private var leftBmp1: Float = 0f
    private var leftBmp2: Float = 600f
    private var leftBmp3: Float = 1200f

//    var bmp1: Bitmap
//    var bmp2: Bitmap
//    var bmp3: Bitmap

    private val paint = Paint()
    private val backgroundRect = Rect(0, 0, 0, 0)

    init {
        init(attrs)

//        bmp1 = BitmapFactory.decodeResource (resources, R.mipmap.ic_launcher)
//        bmp2 = BitmapFactory.decodeResource (resources, R.mipmap.ic_launcher)
//        bmp3 = BitmapFactory.decodeResource (resources, R.mipmap.ic_launcher)
    }

    fun next(){
        this.nextPage++
        direction = -1f
    }

    fun previous(){
        this.nextPage--
        direction = 0.1f
    }

    private fun init(attrs: AttributeSet?) {

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Onboarding)

        pageIndicatorRadius = typedArray.getFloat(R.styleable.Onboarding_pageIndicatorRadius, 30f)
        pageIndicatorStrokeWidth = typedArray.getFloat(R.styleable.Onboarding_pageIndicatorStrokeWidth, 10f)
        pageIndicatorStrokeColor = typedArray.getColor(R.styleable.Onboarding_pageIndicatorStrokeColor, Color.BLACK)

        pageIndicatorColor = typedArray.getColor(R.styleable.Onboarding_pageIndicatorColor, Color.GRAY)
        pageIndicatorSelectedColor = typedArray.getColor(R.styleable.Onboarding_pageIndicatorSelectedColor, Color.DKGRAY)

        pageBackgroundColor = typedArray.getColor(R.styleable.Onboarding_pageBackgroundColor, Color.LTGRAY)

        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        // Draw Background

        // pagina atual e pagina destino



        drawImg(canvas)

    }

    private fun drawBackground(canvas: Canvas) {
        paint.color = pageBackgroundColor
        paint.style = Paint.Style.FILL
        backgroundRect.set(0, 0, measuredWidth, measuredHeight)
        canvas.drawRect(backgroundRect, paint)
    }

    private fun drawImg(canvas: Canvas) {
        paint.textSize = 128f
        paint.color = Color.BLACK

        leftBmp1 = leftBmp1.plus(direction)

        if (direction < 0 && leftBmp1 < -width) {
            direction = 0f
        }

        invalidate()

        canvas.drawText("IMAGE 1", leftBmp1, 150f, paint)
        canvas.drawText("IMAGE 2", leftBmp2, 150f, paint)
        canvas.drawText("IMAGE 3", leftBmp3, 150f, paint)

//        canvas.drawBitmap (bmp1, leftBmp1, 0f, paint)
//        canvas.drawBitmap (bmp2, leftBmp2, 0f, paint)
//        canvas.drawBitmap (bmp3, leftBmp3, 0f, paint)

    }


    private fun drawPageIndicator(canvas: Float, left: Float) {


        val bottomPos = measuredHeight - pageIndicatorRadius - dpToPx(5f)
        val leftPos = measuredWidth / 2f - pageIndicatorRadius / 2f

        paint.color = pageIndicatorStrokeColor
        //canvas.drawCircle(leftPos, bottomPos, pageIndicatorRadius + pageIndicatorStrokeWidth, paint)

        paint.color = pageIndicatorColor
        //canvas.drawCircle(leftPos, bottomPos, pageIndicatorRadius, paint)
    }



    private fun dpToPx(value: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)


}
