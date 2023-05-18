package com.soumil.dormentor

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myProfile = findViewById<CardView>(R.id.profileBg)
        val gatePass = findViewById<CardView>(R.id.gatePassBtn)
        val emergCtn = findViewById<CardView>(R.id.emergencyBtn)

        myProfile.setOnClickListener{
            vibrateFunction()
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        emergCtn.setOnClickListener{
            vibrateFunction()
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.emerg_ctn_pop_up_dialog)
            //            call warden functionality
            val callWarden: TextView = dialog.findViewById(R.id.callWarden)
            callWarden.setOnClickListener{
                vibrateFunction()
                callNumber()
            }
            //            call dean functionality
            val callDean: TextView = dialog.findViewById(R.id.callDean)
            callDean.setOnClickListener{
                vibrateFunction()
                callNumber()
            }
            //            call girls hostel functionality
            val callGrlHostel: TextView = dialog.findViewById(R.id.callGrlHostel)
            callGrlHostel.setOnClickListener{
                vibrateFunction()
                callNumber()
            }
            //            call boys functionality
            val callBoyHostel: TextView = dialog.findViewById(R.id.callBoyHostel)
            callBoyHostel.setOnClickListener{
                vibrateFunction()
                callNumber()
            }
//            dismiss button functionality
                val dismissBtn: Button = dialog.findViewById(R.id.dialogDismissButton)
                    dismissBtn.setOnClickListener{
                        vibrateFunction()
                        dialog.dismiss()
                    }
            dialog.show()
        }

        gatePass.setOnClickListener{
            vibrateFunction()
            val intent = Intent(this, GatepassActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }
    private fun callNumber(){
        val i = Intent(Intent.ACTION_DIAL)
        i.data = Uri.parse("tel:+911234567891")
        startActivity(i)
    }

    private fun vibrateFunction(){
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(10)
    }

}