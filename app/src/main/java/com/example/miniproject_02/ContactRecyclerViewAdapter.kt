package com.example.miniproject_02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactRecyclerViewAdapter(override val onClickListener:OnClickListener): RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder>(),IAdapterView {

    var data = listOf<Contact>()

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name_text_view)
        var number: TextView = itemView.findViewById(R.id.number_text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.contact_card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item  = data[position]
        holder.name.text = item.name
        holder.number.text = item.phoneNumber
        holder.itemView.setOnClickListener{
            onClickListener.onClickItem(item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    //ViewModel
    fun refreshContacts(contact:List<Contact>){
        data = contact
    }

    override fun addItem(item: Any) {
        if (item is Contact){
            notifyDataSetChanged()
        }
    }


}
