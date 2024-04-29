package com.example.viewpager2


import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.edtTxt.addTextChangedListener {
            binding.edtTxt.setBackgroundResource(R.drawable.style1)
        }

        try {
            binding.btn.setOnClickListener {
                if (binding.edtTxt.text.toString().toInt() < 1000) {
                    binding.edtTxt.setBackgroundResource(R.drawable.style2) }
                val media = MediaPlayer.create(this, R.raw.sound)
                val pul = binding.edtTxt.text.toString().toInt()
                val yuz = pul / 100000
                val ellik = (pul - yuz * 100000) / 50000
                val on = (pul - (yuz * 100000 + ellik * 50000)) / 10000
                val besh = (pul - (yuz * 100000 + ellik * 50000 + on * 10000)) / 5000
                val bir = (pul - (yuz * 100000 + ellik * 50000 + on * 10000 + besh * 5000)) / 1000
                media.start()
                binding.txt1.text = yuz.toString()
                binding.txt2.text = ellik.toString()
                binding.txt3.text = on.toString()
                binding.txt4.text = besh.toString()
                binding.txt5.text = bir.toString()
                if (binding.txt1.text.toString() == "0 ta") {
                    binding.txt1.visibility = View.GONE
                    binding.img1.visibility = View.GONE
                } else {
                    binding.txt1.visibility = View.VISIBLE
                    binding.img1.visibility = View.VISIBLE
                }

                if (binding.txt2.text.toString() == "0 ta") {
                    binding.txt2.visibility = View.GONE
                    binding.img2.visibility = View.GONE
                } else {
                    binding.txt2.visibility = View.VISIBLE
                    binding.img2.visibility = View.VISIBLE
                }

                if (binding.txt3.text.toString() == "0 ta") {
                    binding.txt3.visibility = View.GONE
                    binding.img3.visibility = View.GONE
                } else {
                    binding.txt3.visibility = View.VISIBLE
                    binding.img3.visibility = View.VISIBLE
                }

                if (binding.txt4.text.toString() == "0 ta") {
                    binding.txt4.visibility = View.GONE
                    binding.img4.visibility = View.GONE
                } else {
                    binding.txt4.visibility = View.VISIBLE
                    binding.img4.visibility = View.VISIBLE
                }

                if (binding.txt5.text.toString() == "0 ta") {
                    binding.txt5.visibility = View.GONE
                    binding.img5.visibility = View.GONE
                } else {
                    binding.txt5.visibility = View.VISIBLE
                    binding.img5.visibility = View.VISIBLE
                }

            }
        } catch (e: Exception) {
            binding.edtTxt.setBackgroundResource(R.drawable.style2)
        }
    }
}