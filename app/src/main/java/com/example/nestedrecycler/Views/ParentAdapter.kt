package com.example.nestedrecycler.Views

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecycler.Models.ChildModel
import com.example.nestedrecycler.Models.ParentModel
import com.example.nestedrecycler.R
import kotlinx.android.synthetic.main.parent_recycler.view.*

class ParentAdapter(private val parents : List<ParentModel>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>(){
    private var viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(holder: ParentAdapter.ViewHolder, position: Int) {
        val parent = parents[position]
        holder.textView.text = parent.title
        holder.recyclerView.apply {
            layoutManager = LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
            adapter = ChildAdapter(parent.children)
            viewPool = recycledViewPool

        }
    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.rv_child
        val textView: TextView = itemView.textView
    }
}
