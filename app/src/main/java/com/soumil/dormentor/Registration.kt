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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class Registration : AppCompatActivity() {
    private val databaseReference = FirebaseDatabase.getInstance("https://dormentor-soumil-default-rtdb.firebaseio.com/").reference
    private lateinit var auth: FirebaseAuth

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
//                databaseReference.child("users").addListenerForSingleValueEvent(object: ValueEventListener{
//                    override fun onDataChange(snapshot: DataSnapshot) {
////                        check if credentials are present in rtdb
//                        if (snapshot.hasChild(savedEmail)){
//                            val getPassword = snapshot.child(savedEmail).child("password").getValue(String::class.java)
//                                if (getPassword.equals(savedPassword)){
                                    Toast.makeText(baseContext, "Authentication Successful!", Toast.LENGTH_SHORT).show();
                                    val i = Intent(baseContext, MainActivity::class.java)
                                    startActivity(i)
//                                }
//                                else{
//                                    Toast.makeText(baseContext, "Authentication failed!", Toast.LENGTH_SHORT).show()
//                                }
//                        }
//                        else{
//                            Toast.makeText(baseContext, "Wrong Credentials!", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//
//                    override fun onCancelled(error: DatabaseError) {
//                        TODO("Not yet implemented")
//                    }
//                })
            }



//            savedEmail = emailAdd.text.toString().trim()
//            savedPassword = password.text.toString().trim()

//            auth.signInWithEmailAndPassword(savedEmail, savedPassword)
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d("TAG", "signInWithEmail:success")
//                        val user = auth.currentUser
//                        Toast.makeText(baseContext, "Authentication Successful!", Toast.LENGTH_SHORT,).show()
//                        updateUI(user)
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.w("TAG", "signInWithEmail:failure", task.exception)
//                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT,).show()
//                        updateUI(null)
//                    }
//                }
        }
//finish()
    }
}