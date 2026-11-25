package com.example.miapp3.componentes

data class Midata(
    val title: String="Listado de items",
    val items: List<String> = (1..50)
        .map { "Item $it" }
        //.toMutableList()
)
