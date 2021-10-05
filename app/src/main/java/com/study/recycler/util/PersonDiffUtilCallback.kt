package com.study.recycler.util

import androidx.recyclerview.widget.DiffUtil
import com.study.recycler.data.Person

class PersonDiffUtilCallback : DiffUtil.ItemCallback<Person>(){

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return when {
            oldItem is Person.Developer && newItem is Person.Developer -> oldItem.id == newItem.id
            oldItem is Person.User && newItem is Person.User -> oldItem.id == newItem.id
            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}