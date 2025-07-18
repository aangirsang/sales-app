package com.example.salesapp.ui

import ch.qos.logback.core.Context
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.util.Callback
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component


@Component
class SpringFXMLLoader (
    private val context: ApplicationContext
) {

    fun load(fxmlPath: String): Parent {
        val loader = FXMLLoader(javaClass.getResource(fxmlPath))
        loader.controllerFactory = Callback { clazz -> context.getBean(clazz) }
        return loader.load()
    }

}