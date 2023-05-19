package com.soumil.dormentor

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
        val timeTable = findViewById<CardView>(R.id.timeTableBtn)
        val attendenceBtn = findViewById<CardView>(R.id.attendanceBtn)
        val scoreCardBtn = findViewById<CardView>(R.id.scoreCardBtn)

        myProfile.setOnClickListener{
            vibrateFunction()
            val i = Intent(this, ProfileActivity::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        timeTable.setOnClickListener{
            vibrateFunction()
            val i = Intent(this, TimeTableViewActivity::class.java)
            i.putExtra("pdf_url", "https://firebasestorage.googleapis.com/v0/b/dormentor-soumil.appspot.com/o/Soumil_Jaiswal-Resume.pdf?alt=media&token=42f2fb17-0edc-46cb-be5c-fad15aa32998")
            startActivity(i)
        }

        attendenceBtn.setOnClickListener{
            vibrateFunction()
            val i = Intent(this, AttendanceViewActivity::class.java)
            i.putExtra("attendance_view", "https://firebasestorage.googleapis.com/v0/b/dormentor-soumil.appspot.com/o/Soumil_Jaiswal-Resume.pdf?alt=media&token=42f2fb17-0edc-46cb-be5c-fad15aa32998")
            startActivity(i)
        }

        scoreCardBtn.setOnClickListener{
            vibrateFunction()
            val i = Intent(this, ScoreCardActivity::class.java)
            i.putExtra("scoreCard_view", "https://firebasestorage.googleapis.com/v0/b/dormentor-soumil.appspot.com/o/Soumil_Jaiswal-Resume.pdf?alt=media&token=42f2fb17-0edc-46cb-be5c-fad15aa32998")
            startActivity(i)
        }


//        emergency button functionality
        emergCtn.setOnClickListener{
            vibrateFunction()
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.emerg_ctn_pop_up_dialog)

            val callWarden: TextView = dialog.findViewById(R.id.callWarden)
            val callDean: TextView = dialog.findViewById(R.id.callDean)
            val callGrlHostel: TextView = dialog.findViewById(R.id.callGrlHostel)
            val callBoyHostel: TextView = dialog.findViewById(R.id.callBoyHostel)
            val dismissBtn: Button = dialog.findViewById(R.id.dialogDismissButton)

            //            call warden functionality
            callWarden.setOnClickListener{
                vibrateFunction()
                callNumber()
            }
            //            call dean functionality
            callDean.setOnClickListener{
                vibrateFunction()
                callNumber()
            }
            //            call girls hostel functionality
            callGrlHostel.setOnClickListener{
                vibrateFunction()
                callNumber()
            }
            //            call boys functionality
            callBoyHostel.setOnClickListener{
                vibrateFunction()
                callNumber()
            }

//            dismiss button functionality
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
        vibrator.vibrate(20)
    }

}
