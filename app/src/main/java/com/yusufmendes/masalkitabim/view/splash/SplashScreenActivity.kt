package com.yusufmendes.masalkitabim.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.yusufmendes.masalkitabim.MainActivity
import com.yusufmendes.masalkitabim.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

    private var interstitialAd: InterstitialAd? = null
    private var isAdLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            loadInterstitialAd() // Reklamı yükle
        }, 3000)
    }

    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    isAdLoaded = true
                    showAd()
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    isAdLoaded = false
                    navigateToMainActivity() // Reklam yüklenemezse Ana Sayfa'ya geç
                }
            })
    }

    private fun showAd() {
        if (isAdLoaded) {
            interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    navigateToMainActivity() // Reklam kapatıldıktan sonra Ana Sayfa'ya geç
                }

                override fun onAdFailedToShowFullScreenContent(error: AdError) {
                    navigateToMainActivity() // Reklam gösterilemezse Ana Sayfa'ya geç
                }
            }
            interstitialAd?.show(this)
        } else {
            navigateToMainActivity() // Reklam yüklenmediyse Ana Sayfa'ya geç
        }
    }

    private fun navigateToMainActivity() {
        val splashIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
        startActivity(splashIntent)
        finish()
    }

}