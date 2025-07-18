package com.example.salesapp.service

import com.example.salesapp.model.Penjualan
import com.example.salesapp.repository.PenjualanRepository
import org.springframework.stereotype.Service


@Service
open class PenjualanService(

    private val penjualanRepository: PenjualanRepository
) {
    open fun getAllPenjualan(): List<Penjualan> = penjualanRepository.findAll()

    fun save(penjualan: Penjualan): Penjualan = penjualanRepository.save(penjualan)

    fun update(id: Long, penjualan: Penjualan): Penjualan = penjualanRepository.save(penjualan)

    fun findById(id: Long): Penjualan? = penjualanRepository.findById(id).orElse(null)

    fun deleteById(id: Long) = penjualanRepository.deleteById(id)
    open fun savePenjualan(penjualan: Penjualan): Penjualan {
        TODO("Not yet implemented")
    }

    open fun getPenjualanById(id: Long): Penjualan? {
        TODO("Not yet implemented")
    }

    open fun deletePenjualan(id: Long) {}
}