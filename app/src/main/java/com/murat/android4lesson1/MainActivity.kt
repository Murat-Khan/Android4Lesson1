package com.murat.android4lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.murat.android4lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val images = mutableListOf (
        "https://mobimg.b-cdn.net/v3/fetch/2c/2c346b247b5d12cdaa0ef5bccb004142.jpeg",
        "https://i.pinimg.com/originals/bb/b1/f7/bbb1f733b1201db48eac9b6e72e8a316.jpg",
        "https://i.pinimg.com/736x/9f/b9/dd/9fb9dd03c70f132cc730870ca728450e--red-mustang--ford-mustang.jpg",
        "https://st-gdefon.gallery.world/wallpapers_medium/136639_gallery.world.jpg"
    )

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

    }

    private fun setupView() {
        with(binding){
            btnRandom.setOnClickListener {
                imageUrl.loadImage(images.random())
            }

            binding.btnSubmit.setOnClickListener{
                if (etUrl.text.isNullOrEmpty()){
                    etUrl.error = getString(R.string.it_not_url)
                }else if(Patterns.WEB_URL.matcher(etUrl.text.toString()).matches()) {
                    images.add(etUrl.text.toString())
                    imageUrl.loadImage(etUrl.text.toString())
                    etUrl.text.clear()
                }else showToast(getString(R.string.it_not_url))


            }
        }
    }


}