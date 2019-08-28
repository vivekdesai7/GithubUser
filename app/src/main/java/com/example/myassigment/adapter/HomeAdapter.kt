package com.example.myassigment.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.assignment.ui.util.DataBindingViewHolder
import com.example.myassigment.databinding.UserItemRowBinding
import com.example.myassigment.datamodel.Users
import com.example.myassigment.BR.row_item

class HomeAdapter(

    private var items: MutableList<Users> = arrayListOf<Users>()
) : RecyclerView.Adapter<HomeAdapter.SimpleHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SimpleHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleHolder {
//        val binding  = FoodItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val binding  = UserItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SimpleHolder(binding)
    }

    inner class SimpleHolder(dataBinding: ViewDataBinding)
        : DataBindingViewHolder<Users>(dataBinding)  {

        override fun onBind(t: Users): Unit = with(t) {
            dataBinding.setVariable(row_item, t)
        }
    }

    fun add(list: List<Users>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }
}