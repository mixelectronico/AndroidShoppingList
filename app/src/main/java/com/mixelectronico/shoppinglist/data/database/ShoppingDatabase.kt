package com.mixelectronico.shoppinglist.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mixelectronico.shoppinglist.data.database.entities.ShoppingItem


@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var INSTANCE: ShoppingDatabase? = null

        fun getShoppingData(context: Context): ShoppingDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingDatabase::class.java,
                    "baseDeDatos"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}