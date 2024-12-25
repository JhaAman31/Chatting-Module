package com.sca.chattingmodule.Messaging.Models

data class Message(
    val senderId: Int,
    val message: String,
    val timestamp: String,
    val seen: Boolean
)



