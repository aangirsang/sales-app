package com.example.salesapp.controller

import com.example.salesapp.model.Product
import com.example.salesapp.service.ProductService
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import javafx.scene.input.MouseEvent
import org.springframework.stereotype.Component
import java.net.URL
import java.util.*

@Component
class GUIController(private val productService: ProductService) : Initializable {

    @FXML private lateinit var productTable: TableView<Product>
    @FXML private lateinit var nameField: TextField
    @FXML private lateinit var priceField: TextField
    @FXML private lateinit var stockField: TextField

    @FXML private lateinit var idcolumn: TableColumn<Product, Long>
    @FXML private lateinit var namecolumn: TableColumn<Product, String>
    @FXML private lateinit var hargaColumn: TableColumn<Product, Double>
    @FXML private lateinit var stokColumn: TableColumn<Product, Int>


    @FXML
    private lateinit var labelWelcome: Label


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        hargaColumn.setCellFactory {
            object : TableCell<Product, Double>() {
                override fun updateItem(item: Double?, empty: Boolean) {
                    super.updateItem(item, empty)
                    text = if (empty || item == null) "" else "Rp %,d".format(item.toInt())
                }
            }
        }
        idcolumn.setCellValueFactory { ReadOnlyObjectWrapper(it.value.id) }
        namecolumn.setCellValueFactory { ReadOnlyStringWrapper(it.value.name) }
        hargaColumn.setCellValueFactory { ReadOnlyObjectWrapper(it.value.price) }
        stokColumn.setCellValueFactory { ReadOnlyObjectWrapper(it.value.stock) }
        loadProducts()
    }

    @FXML
    fun handleSave() {

        val selected = productTable.selectionModel.selectedItem
        if (selected == null) {
            val name = nameField.text
            val price = priceField.text.toDoubleOrNull() ?: return
            val stock = stockField.text.toIntOrNull() ?: return
            val product = Product(name = name, price = price, stock = stock)
            productService.save(product)
            println("Data Baru Disimpan")
            loadProducts()
        }else{
            var produk = productService.findByID(selected.id)
            if (produk!= null) {
                val id = selected.id
                val name = nameField.text
                val price = priceField.text.toDoubleOrNull() ?: return
                val stock = stockField.text.toIntOrNull() ?: return
                val product = Product(id = id, name = name, price = price, stock = stock)
                productService.update(id, product)
                loadProducts()
                println("Data Di Update")
                println("Data Di Update $id")
            }
        }


    }

    @FXML
    fun handleDelete(){
        val selected = productTable.selectionModel.selectedItem
        if (selected != null) {
            var produk = productService.findByID(selected.id)
            if (produk!= null) {
                productService.deleteById(selected.id)
                println("Data Di Hapus ${selected.id}")
                loadProducts()
            }
        }
    }

            @FXML
    fun handleTableClick(event: MouseEvent){
        if (event.clickCount == 1) {
            val selected = productTable.selectionModel.selectedItem
            if(selected !=null) {
                val produk = productService.findByID(selected.id)
                nameField.text = produk.get().name
                priceField.text = produk.get().price.toInt().toString()
                stockField.text = produk.get().stock.toString()
                println("Dipilih: ${produk.get().id}")
            }
        }
    }

    private fun loadProducts() {
        val products = productService.findAll()
        productTable.items = FXCollections.observableArrayList(products)
        labelWelcome.text = "Produk tersedia: ${products.size}"
        nameField.clear()
        priceField.clear()
        stockField.clear()
        productTable.selectionModel.clearSelection()
    }

}