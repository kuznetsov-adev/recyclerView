package com.study.recycler.data

sealed class Person {
    data class User(
        val name: String,
        val avatarLink: String,
        val age: Int,
    ) : Person()

    data class Developer(
        val name: String,
        val avatarLink: String,
        val age: Int,
        val programmingLanguage: String
    ) : Person()
}