package com.example.salesapp.model

import jakarta.persistence.*


@Entity
@Table
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String,
    var price: Double,
    var stock: Int
)