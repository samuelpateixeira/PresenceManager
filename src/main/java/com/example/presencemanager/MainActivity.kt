package com.example.presencemanager

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.person_layout.*


class MainActivity : AppCompatActivity() {

    var lastStudentNumber = 0

    fun generateStudentNumber() : Int{
        lastStudentNumber ++
        return lastStudentNumber
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)

        var people = ArrayList<Person>()

        people.add(Professor("Samuel Teixeira", "Logic"))
        people.add(Professor("João Dias", "Psychology"))
        people.add(Professor("Bill Gates", "Everything"))
        people.add(Student(generateStudentNumber(), "Alice Teixeira"))
        people.add(Student(generateStudentNumber(), "Elad Rafel"))
        people.add(Student(generateStudentNumber(), "Tony Stark"))
        people.add(Person("Darth Vader"))
        people.add(Student(generateStudentNumber(), "Xavier"))
        people.add(Student(generateStudentNumber(), "Peter"))

        //find the list view
        val listView = findViewById<ListView>(R.id.list_view)

        // Set its adapter to be a new WordAdapter
        listView.adapter = PersonAdapter(this, people)


    }
}
