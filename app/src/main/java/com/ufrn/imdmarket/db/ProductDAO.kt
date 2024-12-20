package com.ufrn.imdmarket.db
import androidx.room.*
import com.ufrn.imdmarket.model.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: ProductEntity)

    @Query("""
        UPDATE products 
        SET productName = :name, 
            productDescription = :description, 
            productStock = :stock 
        WHERE productCode = :code
    """)
    fun updateProduct(
        code: Int,
        name: String,
        description: String,
        stock: Int
    )

    @Query("DELETE FROM products WHERE productCode = :code")
    fun deleteProduct(code: Int)

    @Query("SELECT * FROM products WHERE productCode = :code")
    fun getProductByCode(code: Int): ProductEntity?

    @Query("SELECT * FROM products")
    fun getAllProducts(): List<ProductEntity>
}
