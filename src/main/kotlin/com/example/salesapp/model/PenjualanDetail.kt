package com.example.salesapp.model

import jakarta.persistence.*


@Entity
class PenjualanDetail (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var jumlah: Int = 0,
    var hargaSatuan: Double = 0.0,

    @ManyToOne
    @JoinColumn(name = "penjualan_id")
    var penjualan: Penjualan? = null,

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product? = null

)