package com.example.jdaharis.ui.add

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jdaharis.R


class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    private val mData = ArrayList<ContactEntity>()

    fun setData(items : ArrayList<ContactEntity>){
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(viewGroup.context)
           .inflate(R.layout.contact_item,viewGroup,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(contact : ContactEntity){
                with(itemView){
                    Glide.with(itemView.context)
                        .load(contact.picture.thumbnail)
                        //.into(iv_thumbnail)
                }
        }
    }
}