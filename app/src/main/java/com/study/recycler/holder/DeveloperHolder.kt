package com.study.recycler.holder

import android.view.View
import android.widget.TextView
import com.study.recycler.R
import com.study.recycler.data.Person

class DeveloperHolder(
    view: View,
    onItemClicked: (position: Int) -> Unit
) : BasePersonHolder(view, onItemClicked) {

    private val programmingLanguageView: TextView = view.findViewById(R.id.programmingLanguageTextView)

    fun bind(person: Person.Developer) {
        bindMainInfo(person.name, person.avatarLink, person.age)
        programmingLanguageView.text = person.programmingLanguage
    }
}