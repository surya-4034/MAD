package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean


    {

        val id = item.itemId
        if(id == R.id.First)
        {
            Toast.makeText(applicationContext,"Login is selected",Toast.LENGTH_LONG).show()
        }
        else if(id == R.id.Second)
        {
            Toast.makeText(applicationContext,"Register is selected",Toast.LENGTH_LONG).show()
        }
        else if(id == R.id.Third)
        {
            Toast.makeText(applicationContext,"Setting is selected",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
