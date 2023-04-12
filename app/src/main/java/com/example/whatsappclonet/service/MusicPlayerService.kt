package com.example.whatsappclonet.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import com.example.whatsappclonet.R

class MusicPlayerService: Service(){

    lateinit var mediaPlayer: MediaPlayer


    override fun onBind(intent: Intent?) = null

    override fun onCreate(){
        super.onCreate()
    }

    override fun onStartCommand(intent:Intent?, flags:Int, startId: Int): Int{
        mediaPlayer = MediaPlayer.create(this, R.raw.sofia)
        mediaPlayer.isLooping = false
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onDestroy(){
        super.onDestroy()
        mediaPlayer.stop()
    }
}