package com.study.recycler.holder

import android.view.View
import com.study.recycler.data.Person

class UserHolder(
    view: View,
    onItemClicked: (position: Int) -> Unit
) : BasePersonHolder(view, onItemClicked) {

    fun bind(person: Person.User) {
        bindMainInfo(person.name, person.avatarLink, person.age)
    }
}