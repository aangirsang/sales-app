package com.example.salesapp.controller

import com.example.salesapp.model.Product
import com.example.salesapp.service.ProductService
//import org.springframework.web.bind.annotation.*

//@RestController
//@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

//    @GetMapping
    fun all() = productService.findAll()

//    @PostMapping
//    fun create(@RequestBody product: Product) = productService.save(product)

//    @PutMapping("/{id}")
    fun update(id: Long, product: Product): Product {
        return productService.save(product.copy(id = id))
    }

//    @DeleteMapping("/{id}")
    fun delete(id: Long) = productService.deleteById(id)
}