package com.sa.samov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sa.samov.onboarding.OnboardingOneActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var handler = Handler()
        handler.postDelayed({
            var intent = Intent(this@SplashScreen, OnboardingOneActivity::class.java);
            startActivity(intent);
            finish();
        }, 5000);
    }
}