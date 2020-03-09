package com.example.presencemanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView

class PersonAdapter(context: Context, objects : ArrayList<Person>) : ArrayAdapter<Person>(context, R.layout.person_layout, objects ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var personView = convertView

        // Check if the existing view is being reused, otherwise inflate the view
        if (personView == null) {
            personView = LayoutInflater.from(context).inflate(
            R.layout.person_layout, parent, false)
        }

        // Get the Person object located at this position in the list
        var currentPerson = getItem(position)

        // Find the TextViews in the personView (person_layout.xml file)
        val tvName = personView!!.findViewById<TextView>(R.id.tv_name)
        val tvDetail = personView!!.findViewById<TextView>(R.id.tv_detail)
        val tvPresences = personView!!.findViewById<TextView>(R.id.tv_presences)
        // Set its text to the person's data
        //      Name
        tvName.text = currentPerson!!.name
        //      Detail
        if (currentPerson is Professor) {
            tvDetail.text = "professor of " + currentPerson.subject
            tvDetail.visibility = View.VISIBLE
        } else if (currentPerson is Student) {
            tvDetail.text = "Student no. " + currentPerson.studentNumber
            tvDetail.visibility = View.VISIBLE

        } else {
            tvDetail.visibility = View.GONE
        }
        //      Presences
        tvPresences.text = currentPerson.presences.toString() + " presences registered"

        var btnAddPresence = personView.findViewById<Button>(R.id.btn_add_presence)

        btnAddPresence.setOnClickListener {
            currentPerson.presences ++
                        tvPresences.text = currentPerson.presences.toString() + " presences registered"
        }

        return personView
    }

}