package com.example.intenapphanivia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intenapphanivia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private val TAG = "MainActivityLifecycle"

//Buat properti untuk simpan binding
private lateinit var binding: ActivityMainBinding

companion object{
    const val EXTRA_NAME = "extra_name"
}

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    //Inisialisasi binding
    binding = ActivityMainBinding.inflate(layoutInflater)

    //set UI
    setContentView(binding.root)

    //gunakan binding
    with(binding) {
        btnToSecondActivity.setOnClickListener {
            val intentToSecondActivity =
                Intent(this@MainActivity, SecondActivity::class.java)
            intentToSecondActivity.putExtra(EXTRA_NAME, edtName.text.toString())

            startActivity(intentToSecondActivity)
        }
    }
    Log.d(TAG, "onCreate: dipanggil")
}

override fun onStart() {
    super.onStart()
    Log.d(TAG, "onStart: dipanggil")
    }

override fun onResume() {
    super.onResume()
    Log.d(TAG, "onResume: dipanggil")
    }

override fun onPause() {
    super.onPause()
    Log.d(TAG, "onPause: dipanggil")
    }

override fun onStop() {
    super.onStop()
    Log.d(TAG, "onStop: dipanggil")
    }

override fun onDestroy() {
    super.onDestroy()
    Log.d(TAG, "onDestroy: dipanggil")
    }
}