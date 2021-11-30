package com.mixelectronico.shoppinglist.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items") // Declaro la entidad y le doy el nombre a la tabla en la base de datos.
data class ShoppingItem (
    @ColumnInfo(name = "item_name") // Con esto le doy el nombre a la columna (campo) en la base de datos
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
        ){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}