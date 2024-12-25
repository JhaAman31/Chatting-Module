//package com.sca.chattingmodule.Messaging.UI.ViewModel
//
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.sca.chattingmodule.Messaging.Repository.MessageRepository
//
//class MessageViewModelFactory(private val repository: MessageRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MessageViewModel::class.java)) {
//            return MessageViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
