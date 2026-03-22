package com.example.contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var messageTV:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        messageTV = findViewById(R.id.idTVMessage)
        // registering context menu on below line.
        registerForContextMenu(messageTV)
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // on below line we are setting header title for menu.
        menu!!.setHeaderTitle("Choose Programming Language")
        // on below line we are adding menu items
        menu.add(0, v!!.getId(), 0, "Java")
        menu.add(0, v!!.getId(), 0, "Kotlin")
        menu.add(0, v!!.getId(), 0, "Dart")
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        messageTV.text = item.title
        return true
    }
}
