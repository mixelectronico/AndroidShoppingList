package com.mixelectronico.shoppinglist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mixelectronico.shoppinglist.ShoppingViewModel
import com.mixelectronico.shoppinglist.data.database.entities.ShoppingItem
import com.mixelectronico.shoppinglist.databinding.ShoppingItemBinding

class ShoppingItemAdapter(var items: List<ShoppingItem>, private val viewmodel: ShoppingViewModel): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    fun updateData(newListOfItems : List<ShoppingItem>){
        items = newListOfItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        val binding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemNameTV.text = currentShoppingItem.name
        holder.itemAmountTV.text = currentShoppingItem.amount.toString()
        holder.deleteImgV.setOnClickListener {
            viewmodel.delete(currentShoppingItem)
        }
        holder.plusImgV.setOnClickListener {
            currentShoppingItem.amount++
            viewmodel.upsert(currentShoppingItem)
        }
        holder.minusImgV.setOnClickListener {
            if (currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
                viewmodel.upsert(currentShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ShoppingViewHolder(binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root){
        var itemNameTV = binding.itemNameTV
        var itemAmountTV = binding.itemAmountTV
        var deleteImgV = binding.deleteIV
        var plusImgV = binding.plusIV
        var minusImgV = binding.minusIV
    }

}