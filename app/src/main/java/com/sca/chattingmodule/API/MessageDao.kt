package com.sca.chattingmodule.API

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sca.chattingmodule.Messaging.Models.Message
//
//@Dao
//interface MessageDao {
//    @Query("SELECT * FROM messages WHERE chatId = :chatId ORDER BY timestamp ASC")
//    fun getMessages(chatId: String): LiveData<List<Message>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertMessage(message: Message)
//}
