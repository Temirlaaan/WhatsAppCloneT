package com.example.whatsappclonet.music

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclonet.R
import com.example.whatsappclonet.music.adapter.MusicListRecyclerAdapter
import com.example.whatsappclonet.music.detail.MusicDetailActivity
import kotlinx.parcelize.Parcelize

class MusicListFragment: Fragment(R.layout.fragment_music) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = MusicListRecyclerAdapter(
            item = getMusicSampleData(),
            onItemClickListener = {music ->
                val intent = Intent(activity, MusicDetailActivity::class.java)
                intent.putExtra("ARG_MUSIC", music)
                startActivity(intent)
            }
        )
    }
    private fun getMusicSampleData() = mutableListOf<Music>().apply {
        add(
            Music(
                musicName = "Sofia",
                artistName = "Clairo",
                time = "00:05",
                labelImage = "https://static01.nyt.com/images/2018/05/24/arts/24clairo1/merlin_138539625_2983f99c-a11b-4cf5-a47e-09b35992e12d-superJumbo.jpg"
            )
        )
        add(
            Music(
                musicName = "Sofia",
                artistName = "Clairo",
                time = "00:05",
                labelImage = "https://static01.nyt.com/images/2018/05/24/arts/24clairo1/merlin_138539625_2983f99c-a11b-4cf5-a47e-09b35992e12d-superJumbo.jpg"
            )
        )
        add(
            Music(
                musicName = "Sofia",
                artistName = "Clairo",
                time = "00:05",
                labelImage = "https://static01.nyt.com/images/2018/05/24/arts/24clairo1/merlin_138539625_2983f99c-a11b-4cf5-a47e-09b35992e12d-superJumbo.jpg"
            )
        )
    }
}


@Parcelize
data class Music(
    val musicName: String,
    val artistName: String,
    val time: String,
    val labelImage: String
): Parcelable