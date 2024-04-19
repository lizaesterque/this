package com.example.finalexam

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalexam.databinding.ActivityListItemBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class ListItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListItemBinding
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //button for save the info in the database
        binding.addBtn2.setOnClickListener{
            val destination = binding.destination.text.toString()
            val description = binding.description.text.toString()



            databaseReference = FirebaseDatabase.getInstance().getReference("Bucket List")
            val bucketList = Bucketlist(destination, description)
            databaseReference.child(destination).setValue(bucketList).addOnSuccessListener {
                binding.destination.text.clear()
                binding.description.text.clear()


                Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
                val intent = Intent (this@ListItemActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()


            }
        }
    }
}