package com.mixelectronico.shoppinglist.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.mixelectronico.shoppinglist.data.database.ShoppingDatabase
import com.mixelectronico.shoppinglist.data.database.entities.ShoppingItem

class ShoppingRepository(context: Context) {
    private val db = ShoppingDatabase.getShoppingData(context)
    val shoppingList : LiveData<List<ShoppingItem>> = db.getShoppingDao().getAllShoppingItems()

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>{
        return shoppingList
    }
}