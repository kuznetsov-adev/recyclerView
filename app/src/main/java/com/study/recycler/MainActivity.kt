package com.study.recycler

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.recycler.adapter.UserAdapter
import com.study.recycler.data.User
import com.study.recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initList()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initList() {
        with(binding.userList) {
            adapter = UserAdapter(users + users + users)
            layoutManager = LinearLayoutManager(this@MainActivity)
            //размер не будет изменяться со временем
            setHasFixedSize(true)
        }
    }
}