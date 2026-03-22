package com.example.crud
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "UserDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                email TEXT
            )
        """
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    // INSERT
    fun insertUser(name: String, email: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("email", email)

        val result = db.insert("users", null, values)
        return result != -1L
    }

    // READ
    fun getUsers(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM users", null)
    }

    // UPDATE
    fun updateUser(id: Int, name: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", name)

        val result = db.update(
            "users",
            values,
            "id=?",
            arrayOf(id.toString())
        )
        return result > 0
    }

    // DELETE
    fun deleteUser(id: Int): Boolean {
        val db = writableDatabase
        val result = db.delete(
            "users",
            "id=?",
            arrayOf(id.toString())
        )
        return result > 0
    }
}

