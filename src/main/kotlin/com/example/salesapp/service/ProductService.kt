package com.example.salesapp.service

import com.example.salesapp.model.Product
import com.example.salesapp.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepo: ProductRepository) {
    fun findAll(): List<Product> = productRepo.findAll()
    fun save(product: Product): Product = productRepo.save(product)
    fun deleteById(id: Long) = productRepo.deleteById(id)
}