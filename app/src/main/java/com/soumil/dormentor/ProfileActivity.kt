package com.soumil.dormentor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val logOutBtn = findViewById<AppCompatButton>(R.id.logoutBtn)
        logOutBtn.setOnClickListener{
            Firebase.auth.signOut()
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
            moveTaskToBack(true)
            finish()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}