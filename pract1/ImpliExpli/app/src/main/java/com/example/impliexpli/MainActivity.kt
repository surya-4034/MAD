package com.example.impliexpli
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpenSecond = findViewById<Button>(R.id.btnOpenSecond)
        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)

        // Explicit Intent → Move to SecondActivity
        btnOpenSecond.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("msg", "Hello from MainActivity2!")
            startActivity(intent)
        }

        // Implicit Intent → Open Browser
        btnOpenBrowser.setOnClickListener {
            val url = "https://www.google.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
