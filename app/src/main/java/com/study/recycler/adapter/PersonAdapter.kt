package com.study.recycler.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.study.recycler.R
import com.study.recycler.data.Person
import com.study.recycler.extensions.inflate
import com.study.recycler.holder.DeveloperHolder
import com.study.recycler.holder.UserHolder
import com.study.recycler.util.PersonDiffUtilCallback

class PersonAdapter(
    onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differ = AsyncListDiffer(this, PersonDiffUtilCallback())
    private val delegatesManager = AdapterDelegatesManager<List<Person>>()

    init {
        delegatesManager.addDelegate(UserAdapterDelegate(onItemClicked))
            .addDelegate(DeveloperAdapterDelegate(onItemClicked))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       delegatesManager.onBindViewHolder(differ.currentList, position, holder)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(differ.currentList, position)
    }

    fun updatePersons(newPerson: List<Person>) {
        differ.submitList(newPerson)
    }
}