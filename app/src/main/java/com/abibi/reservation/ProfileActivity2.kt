  package com.abibi.reservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abibi.reservation.databinding.ActivityMainBinding
import com.abibi.reservation.databinding.ActivityProfile2Binding
import com.google.firebase.auth.FirebaseAuth

  class ProfileActivity2 : AppCompatActivity() {

    private  lateinit var binding: ActivityProfile2Binding

    private  lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfile2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
    }

      private fun checkUser() {
          val firebaseUser = firebaseAuth.currentUser
          if (firebaseUser == null){
              startActivity(Intent(this, MainActivity::class.java))
              finish()
          }
          else{
              val phone = firebaseUser.phoneNumber

              binding.phoneTv.text = phone
          }
      }
  }