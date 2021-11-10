package com.supinfo.projettest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.supinfo.projettest.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val viewRoot = binding.root
        setContentView(viewRoot)
    }

    private val runnable = Runnable {
        if (!isFinishing) {
            // Starting the Splash Screen
            startActivity(Intent(applicationContext, MainActivity::class.java))
            // Finishing the Splash Screen
            finish()
        }
    }

    // Function timer (5000ms)
    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 5000)
    }

    // Function pause if needed
    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

}
