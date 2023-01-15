package com.example.androidproject
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.util.Date
import java.time.*
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {
    companion object {
        private const val READ_ACTIVITIES_PERMISSION_CODE = 111
        private const val WRITE_ACTIVITIES_PERMISSION_CODE = 112
        private const val UPDATE_ACTIVITIES_PERMISSION_CODE = 113
        private const val DELETE_ACTIVITIES_PERMISSION_CODE = 114
    }
    var cName:String = ""
    var cID:String =""
    var cActivity:String =""
    var cTime:Int =1
//    var cDate:Date = LocalDate.parse("")
    var cType:String =""
    var cLocation:String =""
    var cMobile:Int =1
    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                permission
            ) == PackageManager.PERMISSION_DENIED
        ) {
            // Requesting the permission
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT)
                .show()
        }
    }
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
//                checkPermission(
//                    android.Manifest.permission.READ_ACTIVITIES,
//                    READ_ACTIVITIES_PERMISSION_CODE)
//                checkPermission(
//                    android.Manifest.permission.WRITE_ACTIVITIES,
//                    WRITE_ACTIVITIES_PERMISSION_CODE)
//                checkPermission(
//                    android.Manifest.permission.UPDATE_ACTIVITIES,
//                    UPDATE_ACTIVITIES_PERMISSION_CODE)
//                checkPermission(
//                    android.Manifest.permission.DELETE_ACTIVITIES,
//                    DELETE_ACTIVITIES_PERMISSION_CODE)

                    var dialog_var = CustomDialogFragment()
                    dialog_var.show(supportFragmentManager, "Custom Dialog")
                    val firstFragment = FirstFragment()
                    val secondFragment = SecondFragment()
                    val fragment1: Button = findViewById(R.id.fragment1)
                    val fragment2: Button = findViewById(R.id.fragment2)
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.FLfragment, firstFragment)
                        commit()
                    }
                    fragment1.setOnClickListener {
                        supportFragmentManager.beginTransaction().apply{
                            replace(R.id.FLfragment, firstFragment)
                            commit()
                        }
                    }
                    fragment2.setOnClickListener {
                        supportFragmentManager.beginTransaction().apply{
                            replace(R.id.FLfragment, secondFragment)
                            commit()
                        }
                    }
            }
//            fun receiveFeedback(feedback: String){
//                val ratingTV : TextView = findViewById(R.id.textView)
//                ratingTV.text = feedback;
//
//            }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var Permissions_counter: Int = 0
        if (requestCode == READ_ACTIVITIES_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Read Activities Permission Granted", Toast.LENGTH_SHORT).show()
                Permissions_counter += 1
            } else {  Toast.makeText(this@MainActivity, "Read activitysPermission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        if (requestCode == WRITE_ACTIVITIES_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Write Activities Permission Granted", Toast.LENGTH_SHORT).show()
                Permissions_counter += 1
            } else { Toast.makeText(this@MainActivity, "Write activitys Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        Toast.makeText(this@MainActivity, "Counter"+Permissions_counter, Toast.LENGTH_SHORT).show()
        if (Permissions_counter==2)
            Toast.makeText(this@MainActivity, "Write Activities Permission Granted", Toast.LENGTH_SHORT).show()
}
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.activities_menu, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var dialog_var = CustomDialogFragment()
        dialog_var.show(supportFragmentManager, "Add activity Dialog")
        return true;
    }


}



