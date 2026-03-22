package com.example.impliexpli
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val msg = intent.getStringExtra("msg") ?: "No message received"
        val txtView = findViewById<TextView>(R.id.txtMessage)
        txtView.text = msg
    }
}
