package ink.moshuier.motse.rule.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ink.moshuier.motse.rule.R
import ink.moshuier.motse.rule.entity.Task
import kotlinx.android.synthetic.main.task_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.text.FieldPosition

class RecyclerViewAdapter(val tasks:List<Task>, val context: Context):RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder>(){

    override fun getItemCount() = tasks.size

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder?.taskTitle?.text = tasks.get(position).title
        holder?.parentLayout?.onClick {
            Toast.makeText(context,"权重: "+tasks.get(position).weight,Toast.LENGTH_LONG)
        }
    }

    companion object {
        val TAG = "RecyclerViewAdapter"
    }
    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
            val parentLayout:ConstraintLayout? = view.task_item as ConstraintLayout
            val taskImage = view.task_icon
            val taskTitle = view.task_title

    }
}