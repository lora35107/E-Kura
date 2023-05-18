package com.example.ekura

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewUsers : AppCompatActivity() {

    private lateinit var  mylistview: ListView
    private lateinit var  btnresults: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_users)
        btnresults = findViewById(R.id.btn_result1)
        mylistview = findViewById(R.id.listview_lora)
        val users:ArrayList<Candidate>  = ArrayList()

        val myadapter = CustomAdapter(applicationContext, users )

        //access the table

        val mydb = FirebaseDatabase.getInstance().reference.child("candidates")

        mydb.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                //get data and display in array
                users.clear()
                for (snap in snapshot.children){
                    val person = snap.getValue(Candidate::class.java)
                    users.add(person!!)
                }

                myadapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "Failed to Display Data", Toast.LENGTH_SHORT).show()

            }

        })

        mylistview.adapter = myadapter

    }
}




