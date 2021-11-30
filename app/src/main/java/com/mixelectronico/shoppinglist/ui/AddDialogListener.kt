package com.mixelectronico.shoppinglist.ui

import com.mixelectronico.shoppinglist.data.database.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}