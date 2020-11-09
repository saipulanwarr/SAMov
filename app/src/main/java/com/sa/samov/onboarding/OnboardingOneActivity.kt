package com.sa.samov.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sa.samov.R
import com.sa.samov.sign.signin.SignInActivity
import com.sa.samov.utils.Preferences
import kotlinx.android.synthetic.main.activity_onboarding_one.*

class OnboardingOneActivity : AppCompatActivity() {

    lateinit var preference:Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        preference = Preferences(this)

        if(preference.getValues("onboarding").equals("1")){
            var intent = Intent(this@OnboardingOneActivity, SignInActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }

        btn_home.setOnClickListener{
            var intent = Intent(this@OnboardingOneActivity, OnboardingTwoActivity::class.java);
            startActivity(intent);
        }

        btn_daftar.setOnClickListener{
            preference.setValues("onboarding", "1")
            var intent = Intent(this@OnboardingOneActivity, SignInActivity::class.java);
            startActivity(intent);
            finishAffinity();
        }
    }
}