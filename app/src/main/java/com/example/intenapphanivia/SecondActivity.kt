package com.example.intenapphanivia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intenapphanivia.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private val launcher= registerForActivityResult(contract = ActivityResultContracts.StartActivityForResult))
    //memeriksa kode dari result
    if (result.resultCode == Activity.RESULT_OK)
    {
        // Mengambil data Intent
        val data = result.data
        //Mendapatkan alamat dari data Intent
        val name = data?.getStringExtra(EXTRA_NAME)
        val address = data?.getStringExtra(EXTRA_ADDRESS)
        //Menetapkan teks di TextView
        binding.txtName.text = "$name beralamat di $address"
    }

companion object{
    const val EXTRA_ADDRESS = "extra_address"
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        with(binding){
            txtName.text = name
        }
    }
}