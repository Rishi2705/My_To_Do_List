package com.example.my_to_do_list

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.my_to_do_list.databinding.CustomBinding

class TasksAdapter(
    val context : Activity,
    val arrayList: ArrayList<Task>,
    var onItemClick: OnClickListener?
) :
    RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {
        interface OnClickListener {
            fun onClick(data: Task){
            }
        }
        class TaskViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView){
                val name =itemView.findViewById<TextView>(R.id.tasknew)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.custom,parent,false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.name.text =arrayList[position].text
        holder.itemView.setOnClickListener{
            onItemClick?.onClick(arrayList[position])
        }
    }

}