package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }

    fun getPosts(){
        val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        val request=retrofit.getPosts()


        request.enqueue(object :Callback<List<post>> {
            override fun onResponse(call: Call<List<post>>, response: Response<List<post>>) {
                if(response.isSuccessful){
                    val posts=response.body()
                    Toast.makeText(baseContext,"fetched ${posts!!.size} posts",
                    Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<post>>, t: Throwable) {

            }


        })
    }
}