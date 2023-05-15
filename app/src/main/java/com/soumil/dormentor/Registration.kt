package com.soumil.dormentor

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Registration : AppCompatActivity() {
    private val databaseReference = FirebaseDatabase.getInstance("https://dormentor-soumil-default-rtdb.firebaseio.com/").reference
    private lateinit var auth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null){
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
            super.getOnBackPressedDispatcher().onBackPressed()
        }
        else{
            Toast.makeText(this, "SignIn!", Toast.LENGTH_SHORT).show()
        }
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
                            val user = auth.currentUser
                            val i = Intent(this, MainActivity::class.java)
                            startActivity(i)
                            finish()
                        }
                        else {
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

    }