package com.example.androidproject
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.androidproject.R


class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val button = view.findViewById<Button>(R.id.btn_add_event)
        button.setOnClickListener {
            showDialog()
        }

        return view
    }

    private fun showDialog() {
        val dialog = CustomDialogFragment()
        val fragmentManager = parentFragmentManager
        dialog.show(fragmentManager, "dialog")
    }
//    val m1:MainActivity=getActivity() as MainActivity;

}


