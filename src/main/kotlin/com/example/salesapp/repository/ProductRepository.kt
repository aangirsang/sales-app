package com.example.salesapp.repository

import com.example.salesapp.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>