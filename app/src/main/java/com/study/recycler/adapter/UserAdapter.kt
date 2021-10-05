package com.study.recycler.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.study.recycler.R
import com.study.recycler.data.User
import com.study.recycler.extensions.inflate

class UserAdapter(
) : RecyclerView.Adapter<UserAdapter.Holder>() {

    private var users: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent.inflate(R.layout.item_user))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    fun updateUsers(newUsers: List<User>) {
        users = newUsers
        notifyDataSetChanged()
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val ageTextView: TextView = view.findViewById(R.id.ageTextView)
        private val developerTextView: TextView = view.findViewById(R.id.devTextView)
        private val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)

        fun bind(user: User) {
            nameTextView.text = user.name
            ageTextView.text = "Age = ${user.age}"
            if(!user.isDeveloper) {
                developerTextView.visibility = View.GONE
            } else {
                developerTextView.visibility = View.VISIBLE
            }

            Glide.with(itemView)
                .load(user.avatarLink)
                .placeholder(R.drawable.ic_portrait)
                .into(avatarImageView)

        }
    }
}