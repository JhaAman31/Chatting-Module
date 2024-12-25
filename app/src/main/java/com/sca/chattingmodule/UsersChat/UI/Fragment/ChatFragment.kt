package com.sca.chattingmodule.UsersChat.UI.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sca.chattingmodule.Utils.Constants
import com.sca.chattingmodule.Messaging.UI.Activity.ChattingActivity
import com.sca.chattingmodule.UsersChat.Epoxy.UserEpoxyController
import com.sca.chattingmodule.UsersChat.UI.ViewModel.UserViewModel
import com.sca.chattingmodule.databinding.FragmentChatBinding


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
        private lateinit var userAdapter: UserEpoxyController
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userAdapter = UserEpoxyController()


        binding.userEpoxyRecycler.layoutManager = LinearLayoutManager(context)
        binding.userEpoxyRecycler.setController(userAdapter)

        userViewModel.users.observe(viewLifecycleOwner, Observer { users ->
            userAdapter.users = users
            userAdapter.requestModelBuild()
        })

        userAdapter.onUserClick = { user ->
            val chatId = generateChatId(user.id)
           val intent = Intent(requireContext(),ChattingActivity::class.java).apply {
               putExtra("otherUserName",user.name)
               putExtra("otherUserPic",user.profilePic)
               putExtra("Chat_ID",chatId)
           }
            startActivity(intent)
        }

        return binding.root
    }

    private fun generateChatId(userId: Int): String {
        return if (Constants.CURRENT_USER_ID < userId) {
            "${Constants.CURRENT_USER_ID}_$userId"
        } else {
            "${userId}_${Constants.CURRENT_USER_ID}"
        }
    }
}
