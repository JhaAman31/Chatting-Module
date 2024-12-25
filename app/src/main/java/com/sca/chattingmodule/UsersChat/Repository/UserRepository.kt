package com.sca.chattingmodule.UsersChat.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sca.chattingmodule.UsersChat.Models.User

class UserRepository {
    fun fetchUsers(): LiveData<List<User>> {
        val usersLiveData = MutableLiveData<List<User>>()
        // For Demo Api call
        usersLiveData.postValue(listOf(
            User(1, "Alice Johnson", "https://example.com/images/alice.jpg", "Online"),
            User(2, "Bob Smith", "https://example.com/images/bob.jpg", "Offline"),
            User(3, "Charlie Brown", "https://example.com/images/charlie.jpg", "Online")
        ))
        return usersLiveData
    }
}
