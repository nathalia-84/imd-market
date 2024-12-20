package com.ufrn.imdmarket.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ufrn.imdmarket.db.ProductDao
import com.ufrn.imdmarket.model.ProductEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(private val productDao: ProductDao) : ViewModel() {

    // Função para adicionar um produto
    fun addProduct(product: ProductEntity, onResult: (Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { // Executa no Dispatchers.IO
            try {
                productDao.insertProduct(product)
                withContext(Dispatchers.Main) {
                    onResult(true) // Operação concluída com sucesso
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onResult(false) // Operação falhou
                }
            }
        }
    }

    // Função para deletar um produto
    fun removeProduct(code: Int, onResult: (Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val product = productDao.getProductByCode(code)
            if (product != null) {
                productDao.deleteProduct(code)
                withContext(Dispatchers.Main) {
                    onResult(true) // Produto deletado
                }
            } else {
                withContext(Dispatchers.Main) {
                    onResult(false) // Produto não encontrado
                }
            }
        }
    }

    // Função para buscar todos os produtos
    fun fetchAllProducts(onResult: (List<ProductEntity>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val products = productDao.getAllProducts()
            withContext(Dispatchers.Main) {
                onResult(products)
            }
        }
    }

    // Função para atualizar um produto no banco
    fun updateProduct(code: Int, updatedProduct: ProductEntity, onResult: (Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val product = productDao.getProductByCode(code)
            if (product != null) {
                try {
                    productDao.updateProduct(
                        code = code,
                        name = updatedProduct.productName,
                        description = updatedProduct.productDescription,
                        stock = updatedProduct.productStock
                    )
                    withContext(Dispatchers.Main) {
                        onResult(true) // Produto atualizado com sucesso
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        onResult(false) // Erro ao atualizar o produto
                    }
                }
            } else {
                withContext(Dispatchers.Main) {
                    onResult(false) // Produto não encontrado
                }
            }
        }
    }

}

