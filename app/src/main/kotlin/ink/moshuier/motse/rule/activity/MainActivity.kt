package ink.moshuier.motse.rule.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ink.moshuier.motse.rule.R
import ink.moshuier.motse.rule.adapter.RecyclerViewAdapter
import ink.moshuier.motse.rule.entity.Task
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskRecycler.layoutManager = LinearLayoutManager(this)
        val taskList = listOf(Task("plank",3),Task("reading",11),Task("noting",11),Task("noting",11),Task("noting",11),Task("noting",11),Task("noting",11),Task("noting",11),Task("noting",11),Task("noting",11),Task("noting",11),Task("noting",11))
        taskRecycler.adapter = RecyclerViewAdapter(taskList,this)

    }
}
