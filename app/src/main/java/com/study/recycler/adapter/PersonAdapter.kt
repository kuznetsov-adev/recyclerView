package com.study.recycler.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.recycler.R
import com.study.recycler.data.Person
import com.study.recycler.extensions.inflate
import com.study.recycler.holder.DeveloperHolder
import com.study.recycler.holder.UserHolder

class PersonAdapter(
    private val onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var persons: List<Person> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TYPE_USER -> UserHolder(parent.inflate(R.layout.item_user), onItemClicked)
            TYPE_DEVELOPER -> DeveloperHolder(parent.inflate(R.layout.item_developer), onItemClicked)
            else -> error("Incorrect viewType = $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is UserHolder -> {
                val person = persons[position].let { it as? Person.User }
                    ?: error("Person at position = $position is not a User")
                holder.bind(person)
            }
            is DeveloperHolder -> {
                val person = persons[position].let { it as? Person.Developer }
                    ?: error("Person at position = $position is not a Developer")
                holder.bind(person)
            }

            else -> error("Incorrect view holder = $holder")
        }
    }

    override fun getItemCount(): Int = persons.size

    override fun getItemViewType(position: Int): Int {
        return when(persons[position]) {
            is Person.Developer -> TYPE_DEVELOPER
            is Person.User -> TYPE_USER
        }
    }

    fun updatePersons(newPerson: List<Person>) {
        persons = newPerson
    }

    companion object {
        private const val TYPE_USER = 1
        private const val TYPE_DEVELOPER = 2
    }
}