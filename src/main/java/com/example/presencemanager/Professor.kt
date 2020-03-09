package com.example.presencemanager

class Professor(professorName : String, teachingSubject : String) : Person(professorName){

    var subject = teachingSubject

    override fun identification() : String {
        return super.identification() + "; subject: " + subject
    }

}