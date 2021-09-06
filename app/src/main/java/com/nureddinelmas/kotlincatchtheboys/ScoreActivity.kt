package com.nureddinelmas.kotlincatchtheboys

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var highScoreSharedPreferences : Int = 0
    var highNameSharedPreferences : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        sharedPreferences = this.getSharedPreferences("com.nureddinelmas.kotlincatchtheboys", Context.MODE_PRIVATE)

        highScoreSharedPreferences  = sharedPreferences.getInt("highscore",-1)
        highNameSharedPreferences = sharedPreferences.getString("highname","")


        if (highScoreSharedPreferences < 0){
            textHighScore.text = "0"
        }
        else{
            textHighScore.text = "$highScoreSharedPreferences"
        }
        val intent = intent
        val player = intent.getStringExtra("player")
        val score = intent.getIntExtra("score",0)
        val level = intent.getIntExtra("level",0)
        textYourScore.text = "$score"
        textYourName.text = "$player"
        if(level == 1200){
             if (highScoreSharedPreferences!! < score){
                 sharedPreferences.edit().putInt("highScore", score).apply()
                 sharedPreferences.edit().putString("highName",player ).apply()
                 textHighScore.text = "$score"
                 highPlayer.text = "$player"
            }
        }
    }

    fun playAgain(view : View){
        val intent = Intent(applicationContext, PlayActivity::class.java)
        intent.putExtra("player", editTextTextPersonName.text.toString())
       // intent.putExtra("level", delayMilis)
        startActivity(intent)

    }
    
    fun quit(view: View){
        finish()
    }
}