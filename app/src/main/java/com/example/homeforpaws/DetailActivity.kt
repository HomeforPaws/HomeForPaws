package com.example.homeforpaws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.homeforpaws.databinding.ActivityDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var userId:Int? = null
        val id = intent.getIntExtra("id",1)
        val retAPI = RetrofitClient.getRetrofitService
        retAPI.getAnimal(id).enqueue(object: Callback<DetailResponse>{
            override fun onResponse(
                call: Call<DetailResponse>,
                response: Response<DetailResponse>
            ) {
                if(response.isSuccessful){
                    val data:DetailResponse?=response.body()
                    binding.detail.text = data?.data?.description
                    binding.ag.text = data?.data?.age.toString()+"/"+data?.data?.gender
                    binding.nameTv.text = data?.data?.name
                    binding.sp.text = data?.data?.species
                    binding.areaTv.text = data?.data?.place
                    Glide.with(applicationContext).load(data?.data?.image_url).into(binding.imageView2)
                    userId = data?.data?.rescue_id
                }else{
                    Log.d("chanho","have response, but not successful")
                }
            }


            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                Log.d("chanho","have no response")
            }

        })
        findViewById<Button>(R.id.sponBtn).setOnClickListener{
            var bundle = Bundle()
            bundle.putInt("id",userId!!)
            val bottomSheet = dialogFragment()
            bottomSheet.arguments = bundle
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

}