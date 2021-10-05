package com.study.recycler.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.recycler.R
import com.study.recycler.adapter.PersonAdapter
import com.study.recycler.data.Person
import com.study.recycler.databinding.FragmentUserListBinding
import com.study.recycler.util.AutoClearedValue
import jp.wasabeef.recyclerview.animators.ScaleInAnimator

class PersonListFragment : Fragment(R.layout.fragment_user_list) {
    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private var persons = listOf(
        Person.Developer(
            name = "John Smith",
            avatarLink = "https://cdn.pixabay.com/photo/2014/04/03/10/32/businessman-310819_1280.png",
            age = 32,
            programmingLanguage = "Java"
        ),
        Person.User(
            name = "Kevin Costner",
            avatarLink = "https://png.pngtree.com/png-clipart/20190922/original/pngtree-business-male-user-avatar-vector-png-image_4774078.jpg",
            age = 29,
        ),
        Person.User(
            name = "Jane Blane",
            avatarLink = "https://png.pngtree.com/png-clipart/20190924/original/pngtree-female-user-avatars-flat-style-women-profession-vector-png-image_4822944.jpg",
            age = 25,

        ),
        Person.Developer(
            name = "Helen Snow",
            avatarLink = "https://cdn.pixabay.com/photo/2014/04/03/10/32/user-310807_1280.png",
            age = 40,
            programmingLanguage = "Kotlin"
        ),
    )

    private var personAdapter: PersonAdapter by AutoClearedValue(this)

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
        binding.addFab.setOnClickListener { addPerson() }
        personAdapter.updatePersons(persons)
        personAdapter.notifyItemRangeInserted(0, persons.size)
    }

    private fun initList() {
        personAdapter = PersonAdapter { position -> deletePerson(position) }
        with(binding.userList) {
            adapter = personAdapter
            layoutManager = LinearLayoutManager(requireContext())
            //размер не будет изменяться со временем
            setHasFixedSize(true)
            val vDividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(vDividerItemDecoration)
            itemAnimator = ScaleInAnimator()
        }
    }

    private fun deletePerson(position: Int) {
        persons = persons.filterIndexed{ index, user -> index != position}
        personAdapter.updatePersons(persons)
        personAdapter.notifyItemRemoved(position)
    }

    private fun addPerson() {
        val newUser = persons.random()
        persons = listOf(newUser) + persons
        personAdapter.updatePersons(persons)
        personAdapter.notifyItemInserted(0)
        binding.userList.scrollToPosition(0)
    }
}