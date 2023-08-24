package com.yusufmendes.masalkitabim.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.yusufmendes.masalkitabim.MainActivity
import com.yusufmendes.masalkitabim.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val splashIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(splashIntent)
            finish()
        }, 3000)
    }
}