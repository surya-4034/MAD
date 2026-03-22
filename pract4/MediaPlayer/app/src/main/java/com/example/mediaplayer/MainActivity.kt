package com.example.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mediaPlayer: MediaPlayer = MediaPlayer.create(applicationContext, R.raw.music)

        val bPlay: Button = findViewById(R.id.playButton)
        val bPause: Button = findViewById(R.id.pauseButton)
        val bStop: Button = findViewById(R.id.stopButton)


        bPlay.setOnClickListener {
            mediaPlayer.start()
        }


        bPause.setOnClickListener {
            mediaPlayer.pause()
        }


        bStop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare()
        }
    }
}
