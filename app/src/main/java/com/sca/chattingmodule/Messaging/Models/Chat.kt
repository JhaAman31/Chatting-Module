package com.sca.chattingmodule.Messaging.Models

data class Chat(
    val chatId: String,
    val participants: List<Int>,
    val messages: List<Message>
)

