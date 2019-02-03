package ink.moshuier.motse.rule.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ink.moshuier.motse.rule.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ib.onClick {
            startActivity<AddActivity>("from" to "main")
        }

    }
}
