package com.example.kb

import android.content.Context
import android.widget.Toast
import androidx.core.graphics.convertTo
import com.google.firebase.Timestamp

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat

class Utility {

    fun getCollectionReferenceForNotes(): CollectionReference {
        val currentUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        return FirebaseFirestore.getInstance().collection("question")
            .document(currentUser?.uid.toString()).collection("my question")
    }

    fun showToast(context: Context, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun timestampToString(timestamp: Timestamp): String {
        return SimpleDateFormat("MM/DD/yyyy").format(timestamp.toDate())

    }


}