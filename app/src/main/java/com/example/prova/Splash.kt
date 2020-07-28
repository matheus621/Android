package com.example.prova

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.splash)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.hide()

        Handler().postDelayed({
            startActivity(Intent(this@Splash, MainActivity::class.java))
            finish()
        }, 4000)


    }

}