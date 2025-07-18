package com.example.salesapp

import com.example.salesapp.ui.AppGUI
import javafx.application.Application
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    exclude = [
        org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration::class,
        org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration::class
    ]
)
open class SalesAppApplication

fun main(args: Array<String>) {
    runApplication<SalesAppApplication>(*args)
    Application.launch(AppGUI::class.java)
}