package com.example.presencemanager

open class Person(PersonName: String) {

    // Properties
    val name = PersonName
    var presences = 0

    // Functionality
    open fun identification() : String {
        return "name: " + this.name
    }

}