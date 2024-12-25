package com.sca.chattingmodule.Messaging.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sca.chattingmodule.Utils.Constants
import com.sca.chattingmodule.Messaging.Models.Message
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MessageViewModel() : ViewModel() {


    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages

    init {
        //Initializing with an empty list
        _messages.value = listOf()
    }

    fun sendMessage(message: String) {
        val newMessage = Message(
            senderId = Constants.CURRENT_USER_ID,
            message = message,
            timestamp = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date()),
            seen = false
        )

        // Adding new message to the list
        val updatedMessages = _messages.value?.toMutableList() ?: mutableListOf()
        updatedMessages.add(newMessage)
        _messages.value = updatedMessages
    }


//    fun getMessages(chatId: String): LiveData<List<Message>> {
//        return repository.getMessages(chatId)
//    }
//
//    fun sendMessage(message: String, chatId: String, senderId: Int) {
//        val newMessage = Message(
//            chatId = chatId,
//            senderId = senderId,
//            message = message,
//            timestamp = System.currentTimeMillis().toString(), // Use proper timestamp formatting
//            seen = false
//        )
//        viewModelScope.launch {
//            repository.addMessage(newMessage)
//        }
//    }
}

