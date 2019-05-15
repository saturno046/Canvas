package com.dynamic.light.com.android.customcomponent.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dynamic.light.com.android.customcomponent.R
import com.dynamic.light.com.android.customcomponent.components.Onboarding
import kotlinx.android.synthetic.main.activity_main.*
import android.support.constraint.ConstraintSet

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //addOnboarding()

        buttonNext.setOnClickListener {
            quadro.next()
        }
    }

    private fun addOnboarding() {
        val set = ConstraintSet()

        val onboarding = Onboarding(this)
        mainActivityLayout.addView(onboarding, 0)

        set.clone(mainActivityLayout)

        set.connect(onboarding.id, ConstraintSet.TOP, mainActivityLayout.id, ConstraintSet.TOP, 0)
        set.connect(onboarding.id, ConstraintSet.START, mainActivityLayout.id, ConstraintSet.START, 0)
        set.connect(onboarding.id, ConstraintSet.END, mainActivityLayout.id, ConstraintSet.END, 0)
        set.connect(onboarding.id, ConstraintSet.BOTTOM, mainActivityLayout.id, ConstraintSet.BOTTOM, 0)

        /**
         *  Use the follow lines to setup a fixed height to Onboarding component
         */
//        val r = resources
//        val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300f, r.displayMetrics).toInt()
//        set.constrainHeight(onboarding.id, px)
//        set.constrainWidth(onboarding.id, 0)



        set.applyTo(mainActivityLayout)
    }
}
