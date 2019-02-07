package ink.moshuier.motse.rule.activity

import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import ink.moshuier.motse.rule.R
import ink.moshuier.motse.rule.adapter.RecyclerViewAdapter
import ink.moshuier.motse.rule.entity.Task
import ink.moshuier.motse.rule.service.getRemoteTasks
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import android.view.MotionEvent
import ink.moshuier.motse.rule.R.id.fab





class MainActivity : AppCompatActivity(),AnkoLogger {
    private var menuViews = mutableListOf<View>()
    private var isOpened = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskRecycler.layoutManager = LinearLayoutManager(this)
        taskRecycler.adapter = RecyclerViewAdapter(getRemoteTasks(),this)

        menuViews.add(fab1);
        menuViews.add(fab2);
        menuViews.add(fab3);
        fab.onClick{
            onViewClicked(it!!)
        }
        fab1.onClick{
            onViewClicked(it!!)
        }
        fab2.onClick{
            onViewClicked(it!!)
        }
        fab3.onClick{
            onViewClicked(it!!)
        }







    }

//    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
//        if (ev.action == MotionEvent.ACTION_DOWN) {
//            if (isOpened) {
//                if (!inRangeOfView(fab, ev)) {
//                    switchMenu(isOpened)
//                    isOpened = !isOpened
//                }
//            }
//        }
//        return super.dispatchTouchEvent(ev)
//    }
    private fun inRangeOfView(view: View, ev: MotionEvent): Boolean {
        val location = IntArray(2)
        view.getLocationOnScreen(location)
        val x = location[0]
        val y = location[1]
        return if (ev.x < x || ev.x > x + view.width || ev.y < y || ev.y > y + view.height) {
            false
        } else true
    }
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.fab -> {
                switchMenu(isOpened)
                isOpened = !isOpened
            }
            R.id.fab1 -> Toast.makeText(this,"fab1",Toast.LENGTH_LONG).show()
            R.id.fab2 -> Toast.makeText(this,"fab2",Toast.LENGTH_LONG).show()
            R.id.fab3 -> Toast.makeText(this,"fab3",Toast.LENGTH_LONG).show()
        }
    }
    fun switchMenu(isOpened:Boolean) {
        //        int startRadius = isOpened ? DensityUtil.sp2px(100) : 0;
//        int endRadius = isOpened ? 0 : DensityUtil.sp2px(100);
        val startRadius = dpToPixel(if(isOpened) 80 else 0);
        val endRadius = dpToPixel(if(isOpened) 0 else 80);


        val valueAnimator = ValueAnimator.ofInt(startRadius, endRadius);
        valueAnimator.setDuration(150);

        valueAnimator.addUpdateListener {
                animation:ValueAnimator ->
            for (i  in 0..menuViews.size-1) {
                var layoutParams =  menuViews.get(i).getLayoutParams() as ConstraintLayout.LayoutParams
                layoutParams.circleRadius =   animation.getAnimatedValue() as Int
                menuViews.get(i).setLayoutParams(layoutParams);
            }

        }
        valueAnimator.start();
    }
    fun dpToPixel(dp:Int):Int {
        val displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        return if (dp < 0)  dp else Math.round(dp * displayMetrics.density);
    }

}
