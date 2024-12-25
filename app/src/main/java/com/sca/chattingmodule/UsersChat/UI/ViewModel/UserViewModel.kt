package com.sca.chattingmodule.UsersChat.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sca.chattingmodule.UsersChat.Models.User
import com.sca.chattingmodule.UsersChat.Repository.UserRepository

class UserViewModel : ViewModel() {

        private val repository = UserRepository()
        val users: LiveData<List<User>> = repository.fetchUsers()

}
