package com.ufrn.imdmarket.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val productCode: Int,
    val productName: String,
    val productDescription: String,
    val productStock: Int
)
