package ink.moshuier.motse.rule.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ink.moshuier.motse.rule.R
import org.jetbrains.anko.db.insert
import utils.DBHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DBHelper(this)
        //出错时候只读
        val db = dbHelper.readableDatabase
        db.insert("task",
            "title" to "plank",
            "weight" to 3)

    }
}
