package com.nureddinelmas.kotlincatchtheboys

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.telecom.PhoneAccount.builder
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.shape.ShapeAppearanceModel.builder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_play.*
import java.util.stream.DoubleStream.builder
import java.util.stream.LongStream.builder
import java.util.stream.Stream.builder
import kotlin.random.Random



class PlayActivity : AppCompatActivity() {
    var imageArray = ArrayList<ImageView>()
    var score = 0
    var runnable = Runnable {  }
    var handler = Handler(Looper.getMainLooper())
    var delayTime : Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val intent = intent
        val player = intent.getStringExtra("player")
        textWho.text = "Player : $player"
        delayTime = intent.getIntExtra("level",0)


        imageArray.add(imageView)
        imageArray.add(imageView1)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)
        imageArray.add(imageView17)
        imageArray.add(imageView18)
        imageArray.add(imageView19)
        imageArray.add(imageView20)
        imageArray.add(imageView21)
        imageArray.add(imageView22)
        imageArray.add(imageView23)

        hideImages()

        object : CountDownTimer(15500, 1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(milisUntilFinished: Long) {
                textTime.text = "Time : ${milisUntilFinished/1000}"

            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {

                for (index in imageArray){
                    index.visibility = View.INVISIBLE
                }
                textTime.text = "Time : 0"

                handler.removeCallbacks(runnable)


                // Alert

                val alert = AlertDialog.Builder(this@PlayActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Do you want play again ?")
                alert.setPositiveButton("Yes"){dialog, which ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No",){dialog, which ->
                    val intent = Intent(applicationContext, ScoreActivity::class.java)


                    intent.putExtra("player",player)
                    intent.putExtra("score", score)
                    intent.putExtra("level",delayTime)
                    startActivity(intent)

                }

                    alert.show()
            }

        }.start()

    }

    fun hideImages(){

        runnable = Runnable {
        for (image in imageArray){
            image.visibility = View.INVISIBLE
        }

        val random = Random
        val randomIndex = random.nextInt(24)
        imageArray[randomIndex].visibility = View.VISIBLE

            handler.postDelayed(runnable, delayTime.toLong())

    }
    handler.post(runnable)
    }


    fun increaseScore(view: View) {
        score += 1
        textScore.text = "Score : $score"
    }
}