package com.example.salesapp.controller

import com.example.salesapp.model.Product
import com.example.salesapp.service.ProductService
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import org.springframework.beans.factory.annotation.Autowired
import java.net.URL
import java.util.*

class GUIController : Initializable {

    @FXML private lateinit var productTable: TableView<Product>
    @FXML private lateinit var nameField: TextField
    @FXML private lateinit var priceField: TextField
    @FXML private lateinit var stockField: TextField

    @Autowired
    @FXML
    lateinit var productService: ProductService

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        // Simplified: skip column setup for brevity
        loadProducts()
    }

    @FXML
    fun handleSave() {
        val name = nameField.text
        val price = priceField.text.toDoubleOrNull() ?: return
        val stock = stockField.text.toIntOrNull() ?: return
        val product = Product(name = name, price = price, stock = stock)
        productService.save(product)
        loadProducts()
    }

    private fun loadProducts() {
        val products = productService.findAll()
        productTable.items = FXCollections.observableArrayList(products)
    }
}