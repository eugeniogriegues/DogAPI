package com.example.dogapi.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dogapi.R

class MainAdapter (val itemList: List<String>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {          // TODO ****  listener para cada item del recyclerView ****


        }


        fun bindData(item: String) {

            val imagen = itemView.findViewById<ImageView>(R.id.ivItem)

            imagen.load(item)


        }
    }


        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MainAdapter.MainViewHolder {

            return MainViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {

            holder.bindData(itemList[position])
        }

        override fun getItemCount(): Int {

            return itemList.size
        }

    }
