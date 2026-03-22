package com.example.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.t1)
        val button: Button = findViewById(R.id.b1)

        val animation: Animation =
            AnimationUtils.loadAnimation(this, R.anim.multi_anim)

        button.setOnClickListener {
            textView.startAnimation(animation)
        }
    }
}

