package com.example.presencemanager

class Student(numberOfStudent : Int, studentName : String) : Person(studentName) {

    // Properties
    var studentNumber = numberOfStudent
    private set

    override fun identification(): String { return super.identification() + "; student number: " + this.studentNumber }

}