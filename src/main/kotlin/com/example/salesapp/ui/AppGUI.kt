package com.example.salesapp.ui

import com.example.salesapp.SalesAppApplication
import javafx.application.Application
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