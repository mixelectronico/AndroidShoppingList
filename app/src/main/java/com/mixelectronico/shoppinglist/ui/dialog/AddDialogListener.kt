package com.mixelectronico.shoppinglist.ui.dialog

import com.mixelectronico.shoppinglist.data.database.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}