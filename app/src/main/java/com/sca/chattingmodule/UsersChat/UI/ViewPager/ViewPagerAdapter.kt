package com.sca.chattingmodule.UsersChat.UI.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sca.chattingmodule.UsersChat.UI.Fragment.ChatFragment
import com.sca.chattingmodule.Utils.ProfileFragment
import com.sca.chattingmodule.Utils.StatusFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ChatFragment()
            1 -> StatusFragment()
            2 -> ProfileFragment()
            else -> ChatFragment()
        }
    }

}
