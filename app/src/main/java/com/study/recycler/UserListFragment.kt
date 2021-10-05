package com.study.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.recycler.adapter.UserAdapter
import com.study.recycler.data.User
import com.study.recycler.util.AutoClearedValue
import com.study.recycler.databinding.FragmentUserListBinding

class UserListFragment : Fragment(R.layout.fragment_user_list) {
    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private var users = listOf(
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

    private var userAdapter: UserAdapter by AutoClearedValue(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        binding.addFab.setOnClickListener { addUser() }
        userAdapter.updateUsers(users)
        userAdapter.notifyItemRangeInserted(0, users.size)
    }

    private fun initList() {
        userAdapter = UserAdapter {position -> deleteUser(position) }
        with(binding.userList) {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
            //размер не будет изменяться со временем
            setHasFixedSize(true)
        }
    }

    private fun deleteUser(position: Int) {
        users = users.filterIndexed{index, user -> index != position}
        userAdapter.updateUsers(users)
        userAdapter.notifyItemRemoved(position)
    }

    private fun addUser() {
        val newUser = users.random()
        users = listOf(newUser) + users
        userAdapter.updateUsers(users)
        userAdapter.notifyItemInserted(0)
        binding.userList.scrollToPosition(0)
    }
}