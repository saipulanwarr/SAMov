package com.sa.samov.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sa.samov.R
import com.sa.samov.sign.SignIn
import kotlinx.android.synthetic.main.activity_onboarding_three.*

class OnboardingThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_three)

        btn_home.setOnClickListener {
            startActivity(Intent(this@OnboardingThreeActivity, SignIn::class.java));
            finishAffinity();
        }
    }
}