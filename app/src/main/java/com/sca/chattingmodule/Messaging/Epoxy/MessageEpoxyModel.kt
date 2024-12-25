package com.sca.chattingmodule.Messaging.Epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.sca.chattingmodule.Utils.Constants
import com.sca.chattingmodule.Messaging.Models.Message
import com.sca.chattingmodule.R
import com.sca.chattingmodule.databinding.ItemMessageBinding

@EpoxyModelClass
abstract class MessageEpoxyModel : EpoxyModelWithHolder<MessageEpoxyModel.Holder>() {

    override fun getDefaultLayout(): Int = R.layout.item_message

    @EpoxyAttribute
    lateinit var message: Message

//    @EpoxyAttribute
//    var isCurrentUser: Boolean = false

    override fun bind(holder: Holder) {
        holder.binding.messageText.text = message.message
        holder.binding.senderName.text =
            if (message.senderId == Constants.CURRENT_USER_ID) "You" else "User ${message.senderId}"
        holder.binding.timestamp.text = message.timestamp
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: ItemMessageBinding
        override fun bindView(itemView: View) {
            binding = ItemMessageBinding.bind(itemView)
        }
    }

}


