package com.example.whatsappclonet

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclonet.R
import com.example.whatsappclonet.chats.ChatRecyclerAdapter
import com.example.whatsappclonet.chats.detail.ChatDetailActivity

class ChatsFragment: Fragment(R.layout.fragment_chats) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ChatRecyclerAdapter(
            item=getChatSampleData(),
            onItemClickListener = {name ->
                val intent = Intent(activity, ChatDetailActivity::class.java)
                intent.putExtra("ARG_NAME",name)
                startActivity(intent)
            }
            )
    }

    private fun getChatSampleData() = mutableListOf<Chats>().apply {
        (0..20).forEach {index ->
            if(index%2 == 0) {
                add(
                    Chats(
                        name = "Ans",
                        demoText = "Hello everyone!!!",
                        avatarUrl = "https://avatars.cloudflare.steamstatic.com/d2d4c01797bbaef6b1f7d9aeca16ba964c631414_full.jpg",
                        date = "02.02.2023"
                    )
                )
            } else if(index%3 == 0){
                add(
                    Chats(
                        name = "Kaira",
                        demoText = "Ans Ans!!!",
                        avatarUrl = "https://www.meme-arsenal.com/memes/05c26553b9c43b1463138595a95b7f1d.jpg",
                        date = "02.02.2023"
                    )
                )
            } else{
                add(
                    Chats(
                        name = "Zhasik",
                        demoText = "Hello",
                        avatarUrl = "https://www.orbita.news/wp-content/uploads/2022/06/snimok-ekrana-2022-06-12-140336.jpg",
                        date = "02.02.2023"
                    )
                )
            }
        }
    }
}

data class Chats(
    val name: String,
    val demoText: String,
    val avatarUrl:String,
    val date: String
)