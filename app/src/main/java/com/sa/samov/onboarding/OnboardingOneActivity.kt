package com.sa.samov.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sa.samov.R
import com.sa.samov.sign.SignIn
import kotlinx.android.synthetic.main.activity_onboarding_one.*

class OnboardingOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        btn_home.setOnClickListener{
            var intent = Intent(this@OnboardingOneActivity, OnboardingTwoActivity::class.java);
            startActivity(intent);
        }

        btn_daftar.setOnClickListener{
            var intent = Intent(this@OnboardingOneActivity, SignIn::class.java);
            startActivity(intent);
        }
    }
}