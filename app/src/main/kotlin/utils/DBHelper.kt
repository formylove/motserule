package utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.jetbrains.anko.db.*

class DBHelper(c: Context):SQLiteOpenHelper(c,"motserule",null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("task",true,
            "_id" to INTEGER + PRIMARY_KEY + UNIQUE + AUTOINCREMENT,
            "title" to TEXT,
            "weight" to INTEGER)
        println("db create")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        println("db upgrade")
    }

}