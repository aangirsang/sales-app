package com.example.salesapp.ui

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class AppGUI : Application() {
    override fun start(primaryStage: Stage) {
        val fxmlLoader = FXMLLoader(AppGUI::class.java.getResource("/view/gui.fxml"))
        val scene = Scene(fxmlLoader.load())
        primaryStage.scene = scene
        primaryStage.title = "Sales App"
        primaryStage.show()
    }
}