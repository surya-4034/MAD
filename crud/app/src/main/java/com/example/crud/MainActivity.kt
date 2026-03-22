package com.example.crud
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
   setContentView(R.layout.activity_main)
    dbHelper = DBHelper(this)
val etName = findViewById<EditText>(R.id.etName)
val etEmail = findViewById<EditText>(R.id.etEmail)
val etId = findViewById<EditText>(R.id.etId)

        findViewById<Button>(R.id.btnInsert).setOnClickListener {
            val success = dbHelper.insertUser(
                etName.text.toString(),
                etEmail.text.toString()
            )
            Toast.makeText(this,
                if (success) "Inserted" else "Failed",
                Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnView).setOnClickListener {
            val cursor = dbHelper.getUsers()
            val buffer = StringBuffer()

            while (cursor.moveToNext()) {
                buffer.append(
                    "ID: ${cursor.getInt(0)}\n" +
                            "Name: ${cursor.getString(1)}\n" +
                            "Email: ${cursor.getString(2)}\n\n"
                )
            }
 AlertDialog.Builder(this)
                .setTitle("User Data")
                .setMessage(buffer.toString())
                .show()
        }

        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            val success = dbHelper.updateUser(
                etId.text.toString().toInt(),
                etName.text.toString()
            )
            Toast.makeText(this,
                if (success) "Updated" else "Failed",
                Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            val success = dbHelper.deleteUser(
                etId.text.toString().toInt()
            )
            Toast.makeText(this,
                if (success) "Deleted" else "Failed",
                Toast.LENGTH_SHORT).show()
        }
    }
}
