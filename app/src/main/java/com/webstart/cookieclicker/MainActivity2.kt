package com.webstart.cookieclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import com.webstart.cookieclicker.MainActivity.Companion.score

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        bonus_label.text = "Il te faut 200 citrouilles"
        bonus_label2.text = "Il te faut 1000 citrouilles"
        bonus_label3.text = "Il te faut 10000 citoruilles"

        score_label2.text = "Tu as $score citrouilles"




        bonus_1.setOnClickListener {
            score_label2.text = "Tu as $score citrouilles"
            if (score > 200 ) {
            score += 300
                bonus_label.text = "+ 300 citrouilles"
        } else {
                bonus_label.text = "Tu n'as pas assez de citrouilles"
        }

        }

        bonus_2.setOnClickListener {
            score_label2.text = "Tu as $score citrouilles"
            if (score > 1000 ) {
                score += 500
                bonus_label2.text = "+ 500 citrouilles"
            } else {
                bonus_label2.text = "Tu n'as pas assez de citrouilles"
            }
        }

            bonus_3.setOnClickListener {
                score_label2.text = "Tu as $score citrouilles"
                if (score > 10000 ) {
                    score += 5000
                    bonus_label3.text = "+ 5000 citrouilles"
                } else {
                    bonus_label3.text = "Tu n'as pas assez de citrouilles"
                }
            }


        button2.setOnClickListener() {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }


    }






