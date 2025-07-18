package com.example.salesapp.repository

import com.example.salesapp.model.Penjualan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PenjualanRepository : JpaRepository<Penjualan, Long>