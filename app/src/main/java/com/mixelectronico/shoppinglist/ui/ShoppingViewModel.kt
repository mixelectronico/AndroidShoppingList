package com.mixelectronico.shoppinglist.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mixelectronico.shoppinglist.data.database.entities.ShoppingItem
import com.mixelectronico.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application): ViewModel() {
    private val repository = ShoppingRepository(application.applicationContext)
    private val shoppingList : LiveData<List<ShoppingItem>> = repository.getAllShoppingItems()

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>{
        return shoppingList
    }
}