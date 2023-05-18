package com.example.ekura

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

class CandidateActivity : AppCompatActivity() {
    private lateinit var CandidateID: EditText
    private lateinit var CandidateName: EditText
    private lateinit var CandidateParty: EditText
    private lateinit var CandidatePosition: EditText
    private lateinit var PictureUpload: Button
    private lateinit var SubmitData: Button
    private var fileUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate)

        // on below line initializing variables for buttons and image view.
        CandidateID = findViewById(R.id.edt_CandID)
        CandidateName = findViewById(R.id.edt_candname)
        CandidateParty = findViewById(R.id.edt_candParty)
        CandidatePosition = findViewById(R.id.edt_position)
        PictureUpload = findViewById(R.id.btn_picha)
        SubmitData = findViewById(R.id.btn_submit)

        //initialise Firebase
        val database = FirebaseDatabase.getInstance()
        val databaseRef = database.getReference("candidates")



        // on below line adding click listener for our choose image button.
        SubmitData.setOnClickListener {
            val id = CandidateID.toString().trim()
            val name = CandidateName.toString().trim()
            val party = CandidateParty.toString().trim()
            val position = CandidatePosition.toString().trim()

            //Progressbar
            var progress = ProgressDialog(this)
            progress.setTitle("Saving Data")
            progress.setMessage("Please Wait")

            //Never ever trust a user :)
            //So we validate the EditTexts

            if (id.isEmpty()||name.isEmpty()||position.isEmpty()){
                Toast.makeText(this, "Kindly fill all compulsory fields", Toast.LENGTH_SHORT).show()
            }else{
                //Saving info kwa database "db"
                val candi_details = Candidate(id,name,party,position)
                val ref = FirebaseDatabase.getInstance().reference.child("candidates")

                ref.setValue(candi_details).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this, "Candidate data uploaded successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Failed to save candidate info. Please try again", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        // on below line adding click listener to upload image.
        PictureUpload.setOnClickListener {
            // on below line calling intent to get our image from phone storage.
            val intent = Intent()
            // on below line setting type of files which we want to pick in our case we are picking images.
            intent.type = "image/*"
            // on below line we are setting action to get content
            intent.action = Intent.ACTION_GET_CONTENT
            // on below line calling start activity for result to choose image.
            startActivityForResult(
                // on below line creating chooser to choose image.
                Intent.createChooser(
                    intent,
                    "Pick your image to upload"),
                22
            )

            // on below line calling upload image button to upload our image.
            uploadImage()
        }
    }

    // on below line adding on activity result method this method is called when user picks the image.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        // on below line we are checking if the result is ok
        if (requestCode == 22 && resultCode == RESULT_OK && data != null && data.data != null) {
            // on below line initializing file uri with the data which we get from intent
            fileUri = data.data
            try {
                // on below line getting bitmap for image from file uri.
                val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, fileUri);
                // on below line setting bitmap for our image view.
                //imageView.setImageBitmap(bitmap)
            } catch (e: Exception) {
                // handling exception on below line
                e.printStackTrace()
            }
        }
    }

    // on below line creating a function to upload our image.
    private fun uploadImage() {
        // on below line checking weather our file uri is null or not.
        if (fileUri != null) {
            // on below line displaying a progress dialog when uploading an image.
            val progressDialog = ProgressDialog(this)
            // on below line setting title and message for our progress dialog and displaying our progress dialog.
            progressDialog.setTitle("Uploading...")
            progressDialog.setMessage("Uploading your image..")
            progressDialog.show()

            // on below line creating a storage reference for firebase storage and creating a child in it with
            // random uuid.
            val ref: StorageReference = FirebaseStorage.getInstance().reference
                .child(UUID.randomUUID().toString())
            // on below line adding a file to our storage.
            ref.putFile(fileUri!!).addOnSuccessListener {
                // this method is called when file is uploaded.
                // in this case we are dismissing our progress dialog and displaying a toast message
                progressDialog.dismiss()
                Toast.makeText(applicationContext, "Image Uploaded..", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                // this method is called when there is failure in file upload.
                // in this case we are dismissing the dialog and displaying toast message
                progressDialog.dismiss()
                Toast.makeText(applicationContext, "Fail to Upload Image..", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}



