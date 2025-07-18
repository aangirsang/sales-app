package com.example.salesapp.controller

import com.example.salesapp.model.Penjualan
import com.example.salesapp.model.Product
import com.example.salesapp.service.PenjualanService
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.DatePicker
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.util.StringConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Component
class PenjualanController @Autowired constructor(
    private val penjualanService: PenjualanService
) : Initializable {


    @FXML private lateinit var tglPenjualan: DatePicker
    @FXML private lateinit var tblPenjualan: TableView<Product>
    @FXML private lateinit var idcolumn: TableColumn<Penjualan, Long>
    @FXML private lateinit var datecolumn: TableColumn<Penjualan, Date>

    private val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        tglPenjualan.value = LocalDate.now()
        tglPenjualan.converter = object : StringConverter<LocalDate>(){
            override fun toString(date: LocalDate?): String? {
                return date?.format(formatter) ?: ""
            }

            override fun fromString(string: String?): LocalDate? {
                return try {
                    string?.let { LocalDate.parse(it, formatter) }
                } catch (e: Exception) {
                    null
                }
            }
        }
        idcolumn.setCellValueFactory { ReadOnlyObjectWrapper(it.value.id) }
        datecolumn.setCellValueFactory { ReadOnlyObjectWrapper(it.value.tanggal) }
        loadData()
    }

    private fun loadData() {
        val penjualanList = penjualanService.getAllPenjualan()
        tblPenjualan.items = FXCollections.observableArrayList(penjualanList) as ObservableList<Product?>?
    }
}