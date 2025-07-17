package com.example.salesapp

import com.example.salesapp.ui.AppGUI
import javafx.application.Application
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SalesAppApplication

fun main(args: Array<String>) {
    runApplication<SalesAppApplication>(*args)
    Application.launch(AppGUI::class.java)
}