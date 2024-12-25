package com.sca.chattingmodule.UsersChat.Epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.sca.chattingmodule.R
import com.sca.chattingmodule.UsersChat.Models.User
import com.sca.chattingmodule.databinding.ItemChatsBinding

@EpoxyModelClass
abstract class UserEpoxyModel : EpoxyModelWithHolder<UserEpoxyModel.Holder>() {
    override fun getDefaultLayout(): Int {
        return R.layout.item_chats
    }

    @EpoxyAttribute
    lateinit var user: User
    @EpoxyAttribute
    lateinit var profile: String
    @EpoxyAttribute
    lateinit var onUserClick: (User) -> Unit

    override fun bind(holder: Holder) {
        holder.binding.userName.text = user.name
//        holder.binding.use.text = user.status
        // Setting profilePic
        Glide.with(holder.binding.userName.context).load(user.profilePic)
            .placeholder(R.drawable.ic_profile_circle).into(holder.binding.userProfilePicture)
        holder.binding.root.setOnClickListener {
            onUserClick(user)
        }
    }

    inner class Holder : EpoxyHolder() {
        lateinit var binding: ItemChatsBinding

        override fun bindView(itemView: View) {
            binding = ItemChatsBinding.bind(itemView)
        }
    }
}

