package com.example.seloco1111

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Point
import android.graphics.Rect
import android.graphics.RectF
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView

class TestpsActivity : AppCompatActivity() {

    private var activity_testps: Animator? = null
    private var shortAnimationDuration: Int = 0

    val iv_1 = findViewById<View>(R.id.iv_1) as ImageView
    val iv_2 = findViewById<View>(R.id.iv_2) as ImageView
    val iv_3 = findViewById<View>(R.id.iv_3) as ImageView

    val btn4 = findViewById<View>(R.id.btn4) as Button
    val btn5= findViewById<View>(R.id.btn5) as Button
    val btn6= findViewById<View>(R.id.btn6) as Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testps)


        val thumb1View: View = findViewById(R.id.iv_1)
        thumb1View.setOnClickListener({
            zoomImageFromThumb(thumb1View, R.drawable.testps)
        })
    }

    private fun zoomImageFromThumb(thumbView: View, imageResId: Int) {
        activity_testps?.cancel()

        val expandedImageView: ImageView = findViewById(R.id.iv_1)
        expandedImageView.setImageResource(imageResId)

        val startBoundsInt = Rect()
        val finalBoundsInt = Rect()
        val globalOffset = Point()

        thumbView.getGlobalVisibleRect(startBoundsInt)
        findViewById<View>(R.id.container)
            .getGlobalVisibleRect(finalBoundsInt, globalOffset)
        startBoundsInt.offset(-globalOffset.x, -globalOffset.y)
        finalBoundsInt.offset(-globalOffset.x, -globalOffset.y)

        val startBounds = RectF(startBoundsInt)
        val finalBounds = RectF(finalBoundsInt)

        val startScale: Float
        if ((finalBounds.width() / finalBounds.height() > startBounds.width() / startBounds.height())) {

            startScale = startBounds.height() / finalBounds.height()
            val startWidth: Float = startScale * finalBounds.width()
            val deltaWidth: Float = (startWidth - startBounds.width()) / 2
            startBounds.left -= deltaWidth.toInt()
            startBounds.right += deltaWidth.toInt()
        } else {

            startScale = startBounds.width() / finalBounds.width()
            val startHeight: Float = startScale * finalBounds.height()
            val deltaHeight: Float = (startHeight - startBounds.height()) / 2f
            startBounds.top -= deltaHeight.toInt()
            startBounds.bottom += deltaHeight.toInt()
        }


        thumbView.alpha = 0f
        expandedImageView.visibility = View.VISIBLE


        expandedImageView.pivotX = 0f
        expandedImageView.pivotY = 0f


        activity_testps = AnimatorSet().apply {
            play(
                ObjectAnimator.ofFloat(
                    expandedImageView,
                    View.X,
                    startBounds.left,
                    finalBounds.left
                )
            ).apply {
                with(
                    ObjectAnimator.ofFloat(
                        expandedImageView,
                        View.Y,
                        startBounds.top,
                        finalBounds.top
                    )
                )
                with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X, startScale, 1f))
                with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_Y, startScale, 1f))
            }
            duration = shortAnimationDuration.toLong()
            interpolator = DecelerateInterpolator()
            addListener(object : AnimatorListenerAdapter() {

                override fun onAnimationEnd(animation: Animator) {
                    activity_testps = null
                }

                override fun onAnimationCancel(animation: Animator) {
                    activity_testps = null
                }
            })
            start()
        }

        expandedImageView.setOnClickListener {
            activity_testps?.cancel()


            activity_testps = AnimatorSet().apply {
                play(ObjectAnimator.ofFloat(expandedImageView, View.X, startBounds.left)).apply {
                    with(ObjectAnimator.ofFloat(expandedImageView, View.Y, startBounds.top))
                    with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X, startScale))
                    with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_Y, startScale))
                }
                duration = shortAnimationDuration.toLong()
                interpolator = DecelerateInterpolator()
                addListener(object : AnimatorListenerAdapter() {

                    override fun onAnimationEnd(animation: Animator) {
                        thumbView.alpha = 1f
                        expandedImageView.visibility = View.GONE
                        activity_testps = null
                    }

                    override fun onAnimationCancel(animation: Animator) {
                        thumbView.alpha = 1f
                        expandedImageView.visibility = View.GONE
                        activity_testps = null
                    }
                })
                start()
            }
        }
    }

    fun Click(v: View) {



        iv_1.visibility = View.INVISIBLE
         iv_2.visibility = View.INVISIBLE
         iv_3.visibility = View.INVISIBLE


        when (v) {
            btn4 -> iv_1.visibility = View.VISIBLE
                  btn5->iv_2.visibility = View.VISIBLE
                btn6->iv_3.visibility = View.VISIBLE


        }

        }


    }
