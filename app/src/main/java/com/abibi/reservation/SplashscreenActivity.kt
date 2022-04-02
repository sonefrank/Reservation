package com.abibi.reservation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashscreenActivity : AppCompatActivity() {
   private var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        handler = Handler()
        handler!!.postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
       // Onclick(findViewById(R.id.btn_travelNow))
    }

    public fun Onclick(view: View){
        val intent = Intent(this, MainActivity::class.java )
        startActivity(intent)
    }
}