package com.example.login
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtUser = findViewById<EditText>(R.id.edtUser)
        val edtPass = findViewById<EditText>(R.id.edtPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        btnLogin.setOnClickListener {
            val user = edtUser.text.toString()
            val pass = edtPass.text.toString()
            if (user == "admin" && pass == "1234") {
                txtResult.text = "Login Successful!"
            } else {
                txtResult.text = "Invalid username or password!"
            }
        }
    }
}
