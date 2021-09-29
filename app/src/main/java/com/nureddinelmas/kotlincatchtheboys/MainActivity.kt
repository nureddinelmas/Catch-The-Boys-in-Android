package com.nureddinelmas.kotlincatchtheboys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_play.*



class MainActivity : AppCompatActivity() {
    var delayMilis = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup.setOnCheckedChangeListener{ group, checkedId ->
            if (checkedId == R.id.easy){

               delayMilis = 500
            }
            if (checkedId == R.id.middle){
                delayMilis = 750
            }
           if (checkedId == R.id.difficult){
               delayMilis = 1200
           }
        }
    }
        fun radio_button_click(view: View){

            val intent = Intent(applicationContext, PlayActivity::class.java)
            intent.putExtra("player", editTextTextPersonName.text.toString())

            intent.putExtra("level", delayMilis)
            startActivity(intent)
            finish()

        }
    }


