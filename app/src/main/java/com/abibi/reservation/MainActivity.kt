package com.abibi.reservation

import android.app.ProgressDialog
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowId
import android.widget.Toast
import com.abibi.reservation.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

private var forceResendingToken:PhoneAuthProvider.ForceResendingToken? = null

 private var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null
 private var mVerificationId: String? = null
 private lateinit var firebaseAuth: FirebaseAuth

 private val Tag = "MAIN_TAG"

    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.phoneLl.visibility = View.VISIBLE
        binding.codeLl.visibility = View.GONE

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)

        mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                Log.d(Tag, "OnVerificationComplited: ")
              signInwithPhoneAuthCredential(phoneAuthCredential)

            }

            override fun onVerificationFailed(e: FirebaseException) {
                progressDialog.dismiss()
                Log.d(Tag, "OnVerificationComplited: ${e.message}")
                Toast.makeText(this@MainActivity,  "Verification code sent...",Toast.LENGTH_SHORT).show()

            }

            override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                Log.d(Tag, "onCodeSend: $verificationId")
                mVerificationId = verificationId
                forceResendingToken = token
                progressDialog.dismiss()

                Log.d(Tag, "OnCodeSend: $verificationId ")

                binding.phoneLl.visibility = View.GONE
                binding.codeLl.visibility = View.VISIBLE
                Toast.makeText(this@MainActivity,  "Verification code send",Toast.LENGTH_SHORT).show()
                binding.codeSentDescriptionTv.text = "Please type the verification code we send to ${binding.phoneEt.text.toString().trim()}"

            }
        }

    binding.phoneContinueBtn.setOnClickListener {
        val phone = binding.phoneEt.text.toString().trim()

        if (TextUtils.isEmpty(phone)){
            Toast.makeText(this@MainActivity,  "Please enter phone number",Toast.LENGTH_SHORT).show()
        }
        else{
            startPhoneNumberVeriication(phone)
        }
    }
    binding.resendCodeTv.setOnClickListener {
        val phone = binding.phoneEt.text.toString().trim()

        if (TextUtils.isEmpty(phone)){
            Toast.makeText(this@MainActivity,  "Please enter phone number",Toast.LENGTH_SHORT).show()
        }
        else{
            resendCerificationCode(phone, forceResendingToken)
        }
    }

     binding.codeSubmitBtn.setOnClickListener{
         val code = binding.codeEt.text.toString().trim()
         if(TextUtils.isEmpty(code)){
             Toast.makeText(this@MainActivity,  "Please enter verification code",Toast.LENGTH_SHORT).show()
         }
         else{
             verifyPhoneNumberWithCode(mVerificationId, code)
             Toast.makeText(this@MainActivity, "Wellcome", Toast.LENGTH_SHORT).show()

         }
     }

    }

    private fun startPhoneNumberVeriication(phone: String)
    {
        Log.d(Tag, "startPhoneNumberVeriication: $phone ")
        progressDialog.setMessage("Verifying Phone Number..")
        progressDialog.show()

        var option = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(60L,TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(mCallback!!)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(option)
    }
        private fun resendCerificationCode(phone: String, token: PhoneAuthProvider.ForceResendingToken?)
        {
            progressDialog.setMessage("Resending Code...")
            progressDialog.show()

            Log.d(Tag, "resendCerificationCode: $phone ")

            var option = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phone)
                .setTimeout(60L,TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(mCallback!!)
                .setForceResendingToken(token!!)
                .build()

            PhoneAuthProvider.verifyPhoneNumber(option)
        }
    private fun verifyPhoneNumberWithCode(verification: String?, code:String){
        progressDialog.setMessage("Verifying Code...")
        progressDialog.show()
        Log.d(Tag, "verifyPhoneNumberWithCode: $verification $code ")


        val credential = PhoneAuthProvider.getCredential(verification!!, code)
        signInwithPhoneAuthCredential(credential)

    }

    private fun signInwithPhoneAuthCredential(credential: PhoneAuthCredential) {
        Log.d(Tag, "signInwithPhoneAuthCredential:")
        progressDialog.setMessage("Logging In")

        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener {
                progressDialog.dismiss()
                val phone = firebaseAuth.currentUser!!.phoneNumber
                Toast.makeText(this,  "Logged In as $phone",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,DashbordActivity::class.java))
                finish()
            }
            .addOnFailureListener{e->
                progressDialog.dismiss()
                Toast.makeText(this,  "${e.message}",Toast.LENGTH_SHORT).show()
            }
    }
}