package com.soumil.dormentor

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class Registration : AppCompatActivity() {
    private val databaseReference = FirebaseDatabase.getInstance("https://dormentor-soumil-default-rtdb.firebaseio.com/").reference
    private lateinit var auth: FirebaseAuth
    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("LOGIN_PREFS", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        auth = Firebase.auth

        val emailAdd = findViewById<TextInputEditText>(R.id.emailAddTextInput)
        val password = findViewById<TextInputEditText>(R.id.passTextInput)
        val loginButton = findViewById<AppCompatButton>(R.id.loginBtn)


        emailAdd.setOnClickListener{
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(20)
        }

        password.setOnClickListener{
         val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
         vibrator.vibrate(20)
        }

        loginButton.setOnClickListener {
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(20)

            val savedEmail:String = emailAdd.text.toString()
            val savedPassword:String = password.text.toString()

            if (savedEmail.isEmpty() || savedPassword.trim().isEmpty()){
                Toast.makeText(baseContext, "Email or Password field Empty!", Toast.LENGTH_SHORT).show();
            }
            else{
                auth.signInWithEmailAndPassword(savedEmail, savedPassword)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success")
                            val user = auth.currentUser
//                            updateUI(user)
                            val mainIntent = Intent(this, MainActivity::class.java)
                            mainIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(mainIntent)
                            Toast.makeText(baseContext, "Authentication Successfull", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }



//
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)

    }
}