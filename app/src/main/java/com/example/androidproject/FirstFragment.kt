package com.example.androidproject
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FirstFragment : Fragment(R.layout.fragment_first) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val button = view.findViewById<Button>(R.id.event1)
        button.setOnClickListener {
            showDialog()
        }

        return view
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("")
        builder.setMessage("")
//        builder.setPositiveButton("OK") { dialog, which ->
//            // Do something when user clicks OK
//        }
//        builder.setNegativeButton("Cancel") { dialog, which ->
//            dismiss()
//        }

        val dialog = builder.create()
        dialog.show()
    }


}