package com.example.salesapp.ui

import com.example.salesapp.SalesAppApplication
import com.example.salesapp.controller.GUIController
import com.example.salesapp.controller.ProductController
import com.example.salesapp.service.ProductService
import com.example.salesapp.service.impl.ProductServiceImpl
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component


@Component
class AppGUI : Application() {

    private lateinit var context: ConfigurableApplicationContext
    override fun init() {
        context = SpringApplication.run(SalesAppApplication::class.java)
    }


    override fun start(primaryStage: Stage) {

        val load = context.getBean(SpringFXMLLoader::class.java)
        val root = load.load("/view/main.fxml")

        val scene = Scene(root)
        primaryStage.scene = scene
        primaryStage.title = "Sales App"
        primaryStage.show()
    }
}