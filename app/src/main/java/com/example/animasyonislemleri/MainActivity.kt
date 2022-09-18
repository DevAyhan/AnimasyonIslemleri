package com.example.animasyonislemleri

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationSet
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGirişAnimasyonu()
        yaziGirişAnimasyonu()
        resimGirişAnimasyonu()

        button.setOnClickListener {
            //alphaAnimasyonu()
            //scaleAnimasyonu()
            //rotateAnimasyonu()
            //translationAnimasyonu()
            //cokluAnimasyon()
            ardisikAnimasyon()

        }
    }
    fun ardisikAnimasyon(){
        val a = ObjectAnimator.ofFloat(resim,"alpha",1.0f,0.0f)
        val sX = ObjectAnimator.ofFloat(resim,"scaleX",1.0f,3.0f)
        val sY = ObjectAnimator.ofFloat(resim,"scaleY",1.0f,3.0f)

        val coklu = AnimatorSet().apply {
            duration = 2000
            playSequentially(sX,sY,a)
        }
        coklu.start()
    }
    fun cokluAnimasyon(){
        val a = ObjectAnimator.ofFloat(resim,"alpha",1.0f,0.0f)
        val sX = ObjectAnimator.ofFloat(resim,"scaleX",1.0f,3.0f)
        val sY = ObjectAnimator.ofFloat(resim,"scaleY",1.0f,3.0f)

        val coklu = AnimatorSet().apply {
            duration = 2000
            playTogether(a,sX,sY)
        }
        coklu.start()
    }

    fun resimGirişAnimasyonu(){
        val r = ObjectAnimator.ofFloat(resim,"translationX",-800.0f,0.0f).apply {
            duration = 2000
        }
        r.start()
    }

    fun yaziGirişAnimasyonu(){
        val r = ObjectAnimator.ofFloat(yazi,"translationX",800.0f,0.0f).apply {
            duration = 2000
            startDelay = 350
        }
        r.start()
    }

    fun buttonGirişAnimasyonu(){
        val r = ObjectAnimator.ofFloat(button,"translationY",800.0f,0.0f).apply {
            duration = 1000
            startDelay = 700
            //interpolator = OvershootInterpolator()
            interpolator = BounceInterpolator()
        }
        r.start()
    }
    fun translationAnimasyonu(){
        val t = ObjectAnimator.ofFloat(resim,"translationX",0.0f,500.0f).apply {
            duration = 3000
        }
        val tY = ObjectAnimator.ofFloat(resim,"translationY",0.0f,500.0f).apply {
            duration = 3000
        }
        t.start()
        tY.start()
    }
    fun rotateAnimasyonu(){
        val r = ObjectAnimator.ofFloat(resim,"rotation",0.0f,360.4f).apply {
            duration = 3000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        r.start()
    }

    fun scaleAnimasyonu(){
        val s = ObjectAnimator.ofFloat(resim,"scaleX",1.0f,0.5f).apply {
            duration = 3000
        }
        val sy = ObjectAnimator.ofFloat(resim,"scaleY",1.0f,0.5f).apply {
            duration = 3000
        }
        s.start()
        sy.start()
    }

    fun alphaAnimasyonu(){
        val a = ObjectAnimator.ofFloat(resim,"alpha",1.0f,0.4f).apply {
            duration = 3000
        }
        a.start()
    }
}