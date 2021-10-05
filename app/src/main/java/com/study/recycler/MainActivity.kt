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