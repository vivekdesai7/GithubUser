package com.example.myassigment.adapter
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.assignment.ui.util.DataBindingViewHolder
import com.example.myassigment.databinding.UserItemRowBinding
import com.example.myassigment.datamodel.Users
import com.example.myassigment.BR.row_item
import com.example.myassigment.view.DetailActivity


class HomeAdapter  (
    private var items: MutableList<Users> = arrayListOf<Users>()
) : RecyclerView.Adapter<HomeAdapter.SimpleHolder>()  {

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: SimpleHolder, position: Int) {
        holder.onBind(items[position])

        holder.itemView.setOnClickListener {
            val context = holder.itemView.getContext()
            var intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id", items[position].id );
            intent.putExtra("name", items[position].login );
            intent.putExtra("url", items[position].thumbnail );
            context.startActivity(intent)
        }

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




