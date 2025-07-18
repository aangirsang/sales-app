package com.example.salesapp.controller

import com.example.salesapp.model.Product
import com.example.salesapp.service.ProductService
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import org.springframework.stereotype.Component
import java.net.URL
import java.util.*


@Component
class GUIController(private val productService: ProductService) : Initializable {

    @FXML private lateinit var productTable: TableView<Product>
    @FXML private lateinit var nameField: TextField
    @FXML private lateinit var priceField: TextField
    @FXML private lateinit var stockField: TextField

    @FXML private lateinit var namecolumn: TableColumn<Product, String>
    @FXML private lateinit var hargaColumn: TableColumn<Product, Double>
    @FXML private lateinit var stokColumn: TableColumn<Product, Int>


    @FXML
    private lateinit var labelWelcome: Label

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        namecolumn.setCellValueFactory { ReadOnlyStringWrapper(it.value.name) }
        hargaColumn.setCellValueFactory { ReadOnlyObjectWrapper(it.value.price) }
        stokColumn.setCellValueFactory { ReadOnlyObjectWrapper(it.value.stock) }
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
        labelWelcome.text = "Produk tersedia: ${products.size}"
        nameField.clear()
        priceField.clear()
        stockField.clear()
    }
}