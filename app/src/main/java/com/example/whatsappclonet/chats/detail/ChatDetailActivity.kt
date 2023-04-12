package com.example.whatsappclonet.chats.detail

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsappclonet.R
import com.example.whatsappclonet.broadcastReceivers.BroadcastConstants.DYNAMIC_BROADCAST
import com.example.whatsappclonet.broadcastReceivers.BroadcastConstants.STATIC_BROADCAST
import com.example.whatsappclonet.broadcastReceivers.DynamicBroadcastReceiver

class ChatDetailActivity: AppCompatActivity() {

    var name: String? = null

    private val dynamicBroadcastReceiver = DynamicBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_detail)

        name = intent.getStringExtra("ARG_NAME")
        setupView()

        registerDynamicBroadcast()
    }

    private fun registerDynamicBroadcast(){
        val filter = IntentFilter(DYNAMIC_BROADCAST)
        this.registerReceiver(dynamicBroadcastReceiver, filter)
    }

    private fun setupView() {
        val textView = findViewById<TextView>(R.id.textview)
        val dynamicButton = findViewById<Button>(R.id.dynamicButton)
        val staticButton = findViewById<Button>(R.id.staticButton)
        val greeting = name
        textView.text = "Hi $greeting"

        dynamicButton.setOnClickListener{
            val intent = Intent()
            intent.action = DYNAMIC_BROADCAST
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            sendBroadcast(intent)
        }

        staticButton.setOnClickListener {
            val intent = Intent()
            intent.action = STATIC_BROADCAST
            sendBroadcast(intent)
        }
    }

    override fun onStop(){
        super.onStop()
        unregisterReceiver(dynamicBroadcastReceiver)
    }
}