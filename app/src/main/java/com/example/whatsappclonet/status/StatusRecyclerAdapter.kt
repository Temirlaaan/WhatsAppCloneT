package com.example.whatsappclonet.status

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclonet.R
import com.example.whatsappclonet.Status

class StatusRecyclerAdapter(
    private val item: List<Status>
) : RecyclerView.Adapter<StatusRecyclerAdapter.ViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_status, parent, false)
        return ViewHolder2(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder2(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var statusNameTextView: TextView
        lateinit var statusMsgTextView: TextView
        lateinit var statusAvatarView: AppCompatImageView
        lateinit var statusDateTextView: TextView
        lateinit var statusAnotherDateTextView: TextView

        fun bind(item: Status){
            statusNameTextView = itemView.findViewById(R.id.statusNameTextView)
            statusMsgTextView = itemView.findViewById(R.id.statusMsgTextView)
            statusAvatarView = itemView.findViewById(R.id.statusAvatarView)
            statusDateTextView = itemView.findViewById(R.id.statusDateTextView)
            statusAnotherDateTextView = itemView.findViewById(R.id.statusAnotherDateTextView)

            statusNameTextView.text = item.statusName
            statusMsgTextView.text = item.statusDemoText
            statusDateTextView.text = item.statusDate
            statusAnotherDateTextView.text = item.statusAnotherDate

            statusAvatarView.setImageDrawable(
                ContextCompat.getDrawable(itemView.context, item.statusAvatar)
            )
        }
    }
}