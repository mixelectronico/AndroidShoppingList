package com.mixelectronico.shoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.mixelectronico.shoppinglist.data.database.entities.ShoppingItem
import com.mixelectronico.shoppinglist.databinding.ShoppingItemAddDialogBinding

class DialogShoppingItemAdd(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ShoppingItemAddDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.addTV.setOnClickListener {
            val name = binding.nameET.text.toString()
            val amount = binding.amountET.text.toString()
            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.cancelTV.setOnClickListener {
            cancel()
        }
    }
}