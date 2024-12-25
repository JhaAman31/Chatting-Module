package com.sca.chattingmodule.API

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sca.chattingmodule.Messaging.Models.Message
//
//@Database(entities = [Message::class], version = 1, exportSchema = false)
//abstract class MessageDatabase : RoomDatabase() {
//    abstract fun messageDao(): MessageDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: MessageDatabase? = null
//
//        fun getDatabase(context: Context): MessageDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MessageDatabase::class.java,
//                    "chat_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}
