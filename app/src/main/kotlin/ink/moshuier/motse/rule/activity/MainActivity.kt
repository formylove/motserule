package ink.moshuier.motse.rule.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ink.moshuier.motse.rule.R
import ink.moshuier.motse.rule.entity.Task
import ink.moshuier.motse.rule.extentions.byId
import ink.moshuier.motse.rule.extentions.parseOpt
import ink.moshuier.motse.rule.table.TaskTable
import org.jetbrains.anko.db.insert
import ink.moshuier.motse.rule.utils.database
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.select

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = this.database
        //出错时候只读
        dbHelper?.use {

        insert("task",
            "title" to "plank",
            "weight" to 3)
        var task0 = Task("nofap",33)
        var task = select(TaskTable.TABLE_NAME).byId(1).parseOpt{
                Task(HashMap(it))
            }
            //Use setText(String), since editText.text expects an Editable, not a String.
            editText.setText(task?.title)
        }
    }
}
