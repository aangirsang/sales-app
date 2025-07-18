package com.example.salesapp.model

import jakarta.persistence.*
import java.util.Date


@Entity
data class Penjualan (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Temporal(TemporalType.DATE)
    var tanggal: Date = Date(),

    @OneToMany(mappedBy = "penjualan", cascade = [CascadeType.ALL], orphanRemoval = true)
    val penjualanDetails: MutableList<PenjualanDetail> = mutableListOf()

)

