package com.webstart.cookieclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.os.CountDownTimer
import com.webstart.cookieclicker.MainActivity2 as MainActivity2



class MainActivity : AppCompatActivity() {



    companion object { var score: Int = 0 }

    var level: Int = 0


    protected lateinit var timer: CountDownTimer
    override fun onDestroy() {
        timer.cancel()
    }

    // FIN MODIF LA

    fun addPumpkin(nbCitrouille: Int) {
        score += 1
        score_label.text = "Tu as $score citrouilles"


        if (score == (level+1)*100) {
            level += 1
            level_label.text = "Level $level"

        }

    }

    val id:Int = 10
    val language:String = "kotlin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score_label.text = "Tu n'as aucune citrouilles"
        level_label.text = "Level $level"


        // autofarm
        var interval: Long = 1000 // 1 sec

        timer = object: CountDownTimer(20000, interval) {

            override fun onTick(millisUntilFinished: Long)
            {
                addPumpkin(1)

            }


            override fun onFinish() {

                start()
            }
        }
        timer.start()


        pumpkin_image.setOnClickListener{
            addPumpkin(1)

            pumpkin_image.animate().apply {

                duration = 10
                scaleXBy(.2f)

            }.withEndAction {

                pumpkin_image.animate().apply {

                    duration = 10
                    scaleXBy(-.2f)

                }.start()


            }

        }

        level_label.setOnClickListener {
            level += 1

        }

        reset_button.setOnClickListener {
            score = 0
            level = 0
            score_label.text = "Tu as $score citrouilles"
            level_label.text = "Level $level"

        }


        button.setOnClickListener() {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("id_value", id)
            intent.putExtra("language_value", language)
            startActivity(intent)
        }






    }

    }
