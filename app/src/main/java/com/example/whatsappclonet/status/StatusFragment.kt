package com.example.whatsappclonet

import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclonet.status.StatusRecyclerAdapter

class StatusFragment: Fragment(R.layout.fragment_status) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.statusRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = StatusRecyclerAdapter(getStatusSampleData())
    }

    private fun getStatusSampleData() = mutableListOf<Status>().apply {
        (0..20).forEach {index ->
            if(index%2 == 0) {
                add(
                    Status(
                        statusName = "Temir",
                        statusDemoText = "Hello everyone!!!",
                        statusAvatar = R.drawable.ic_konki,
                        statusDate = "15:43",
                        statusAnotherDate = "04.02.2023"
                    )
                )
            } else if(index%3 == 0){
                add(
                    Status(
                        statusName = "Alton",
                        statusDemoText = "Hi!!!",
                        statusAvatar = R.drawable.ic_konki,
                        statusDate = "18:34",
                        statusAnotherDate = "04.02.2025"
                    )
                )
            } else{
                add(
                    Status(
                        statusName = "Mura",
                        statusDemoText = "Ya chert!!!",
                        statusAvatar = R.drawable.ic_konki,
                        statusDate = "19:35",
                        statusAnotherDate = "24.03.2015"
                    )
                )
            }
        }
    }
}

data class Status(
    val statusName: String,
    val statusDemoText: String,
    @DrawableRes val statusAvatar: Int,
    val statusDate: String,
    val statusAnotherDate: String
)