package com.example.homeforpaws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homeforpaws.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var filtered = "강아지"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.filterView.setOnClickListener{

        }
        val itemList = ArrayList<MainListItem>()
        val mainListAdapter = MainListAdapter(itemList,object:MainListAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, listItem: MainListItem) {
                val id = itemList[position]

            }
        })
        val retAPI = RetrofitClient.getRetrofitService
        retAPI.getMainList().enqueue(object: Callback<MainAnimalResponse>{
            override fun onResponse(
                call: Call<MainAnimalResponse>,
                response: Response<MainAnimalResponse>
            ) {
                if(response.isSuccessful){
                    Log.d("chanho","successful")
                    val data:MainAnimalResponse?=response.body()
                    for(result in data!!.result){
                        itemList.add(MainListItem(result.name,result.imageUrl))
                    }
                    mainListAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(applicationContext,"Not Successful", Toast.LENGTH_SHORT)
                    Log.d("chanho","have response, but not successful")
                }
            }

            override fun onFailure(call: Call<MainAnimalResponse>, t: Throwable) {
                Log.d("chanho","have no response")
            }

        })
        mainListAdapter.notifyDataSetChanged()
        binding.mainListRecyclerView.adapter = mainListAdapter
        binding.mainListRecyclerView.layoutManager = GridLayoutManager(this,2)
    }
}