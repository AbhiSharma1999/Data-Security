package com.example.datasecurity

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val list : List<PackageInfo>, private val packageManager:PackageManager, private val itemClickHandler : (PackageInfo)->Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VH).bindItems(packageManager.getApplicationLabel(list[position].applicationInfo).toString()
                ,list[position].firstInstallTime.toString()
                )
        holder.itemView.setOnClickListener {
            itemClickHandler.invoke(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class VH (itemView: View):RecyclerView.ViewHolder(itemView){
        private val name: TextView = itemView.findViewById(R.id.AppName)
        private val date:TextView = itemView.findViewById(R.id.DateInstalled)

        fun bindItems(name:String,date:String){
            this.name.text = name
            this.date.text = date
        }
    }

}