package com.mixelectronico.shoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mixelectronico.shoppinglist.data.database.entities.ShoppingItem
import com.mixelectronico.shoppinglist.databinding.ActivityShoppingBinding


class ShoppingActivity : AppCompatActivity() {

    private var shoppingItems = ArrayList<ShoppingItem>()
    private lateinit var viewModel : ShoppingViewModel
    private lateinit var adapter: ShoppingItemAdapter
    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Iniciamos el ViewModel
        viewModel = ViewModelProvider(this)[ShoppingViewModel::class.java]

        //Iniciamos el adapter y se lo asignamos al recylerview
        //adapter = ShoppingItemAdapter(shoppingItems, viewModel)
        //binding.shoppingItemsRV.adapter = adapter

        //binding.shoppingItemsRV.layoutManager = LinearLayoutManager(this)


        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.updateData(it)
        })

        binding.fab.setOnClickListener {
            DialogShoppingItemAdd(this,
            object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}