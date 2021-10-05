package com.study.recycler

import androidx.fragment.app.Fragment
import com.study.recycler.data.User

class UserListFragment : Fragment(R.layout.fragment_user_list) {
    private val users = listOf(
        User(
            name = "John Smith",
            avatarLink = "https://cdn.pixabay.com/photo/2014/04/03/10/32/businessman-310819_1280.png",
            age = 32,
            isDeveloper = true
        ),
        User(
            name = "Kevin Costner",
            avatarLink = "https://png.pngtree.com/png-clipart/20190922/original/pngtree-business-male-user-avatar-vector-png-image_4774078.jpg",
            age = 29,
            isDeveloper = false
        ),
        User(
            name = "Jane Blane",
            avatarLink = "https://png.pngtree.com/png-clipart/20190924/original/pngtree-female-user-avatars-flat-style-women-profession-vector-png-image_4822944.jpg",
            age = 25,
            isDeveloper = false
        ),
        User(
            name = "Helen Snow",
            avatarLink = "https://cdn.pixabay.com/photo/2014/04/03/10/32/user-310807_1280.png",
            age = 40,
            isDeveloper = true
        ),
    )
}