package ink.moshuier.motse.rule.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.Toast
import ink.moshuier.motse.rule.R
import ink.moshuier.motse.rule.R.id.toolbar
import kotlinx.android.synthetic.main.activity_add.*

import org.jetbrains.anko.browse
import org.jetbrains.anko.sdk27.coroutines.onClick

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "choose!", Snackbar.LENGTH_LONG)
                .setAction("undo", object: View.OnClickListener {
                    override fun onClick(v: View?) {
                        Toast.makeText(this@AddActivity,"it works!",Toast.LENGTH_LONG).show()
                    }

                }).show()

        }
    }

}
