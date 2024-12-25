package com.sca.chattingmodule.UsersChat.Epoxy

import com.airbnb.epoxy.EpoxyController
import com.sca.chattingmodule.UsersChat.Models.User

class UserEpoxyController : EpoxyController() {
    var users = listOf<User>()
    var onUserClick: (User) -> Unit = {}

    override fun buildModels() {

        users.forEach { user ->
            UserEpoxyModel_()
                .id(user.id)
                .user(user)
                .profile(user.profilePic)
                .onUserClick(onUserClick)
                .addTo(this)
        }
    }
}