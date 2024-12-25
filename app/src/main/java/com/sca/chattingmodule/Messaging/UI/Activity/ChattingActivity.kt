package com.sca.chattingmodule.Messaging.UI.Activity

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.bumptech.glide.Glide
import com.sca.chattingmodule.Messaging.Epoxy.MessageEpoxyModel
import com.sca.chattingmodule.Messaging.Epoxy.MessageEpoxyModel_
import com.sca.chattingmodule.Messaging.UI.ViewModel.MessageViewModel
import com.sca.chattingmodule.R
import com.sca.chattingmodule.databinding.ActivityChattingBinding
import org.java_websocket.client.WebSocketClient

class ChattingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChattingBinding


    private lateinit var chatViewModel: MessageViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val chatId = intent.getStringExtra("Chat_ID")
        val userName = intent.getStringExtra("otherUserName")
        val profile = intent.getStringExtra("otherUserPic")

        // Set up UI
        binding.otherUserName.text = userName
        Glide.with(this).load(profile).placeholder(R.drawable.ic_profile_circle)
            .into(binding.otherUserImg)

        chatViewModel = ViewModelProvider(this).get(MessageViewModel::class.java)
        setupRecyclerView()

        // Observe LiveData for messages
        chatViewModel.messages.observe(this) {
            (binding.messageRecycler as EpoxyRecyclerView).requestModelBuild()
        }

        // Handle sending messages
        binding.sendBtn.setOnClickListener {
            val messageText = binding.messageWriter.text.toString()
            if (messageText.isNotBlank()) {
                chatViewModel.sendMessage(messageText)
                binding.messageWriter.text.clear() // Clear input field
            }
        }

        // Handle "Done" button on keyboard
        binding.messageWriter.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                binding.sendBtn.performClick()
                true
            } else false
        }
    }


    private fun setupRecyclerView() {
        val epoxyController = object : com.airbnb.epoxy.EpoxyController() {
            override fun buildModels() {
                chatViewModel.messages.value?.forEach { message ->
                    MessageEpoxyModel_()
                        .id(message.timestamp) // Use timestamp as unique ID
                        .message(message)
                        .addTo(this)
                }
            }
        }

        binding.messageRecycler.apply {
            layoutManager = LinearLayoutManager(this@ChattingActivity)
            setController(epoxyController)
        }
    }
}
