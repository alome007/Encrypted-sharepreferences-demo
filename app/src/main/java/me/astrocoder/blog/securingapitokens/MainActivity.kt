package me.astrocoder.blog.securingapitokens

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val sharedPreferencesHelper by  lazy {
        SharedPreferencesHelper()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferencesHelper.saveData(applicationContext, "USER_NAME", "Astrocoder")
        sharedPreferencesHelper.saveData(applicationContext, "ACCESS_TOKEN", "MY_ACCESS_TOKEN")

        val username = sharedPreferencesHelper.getData(applicationContext, "USER_NAME")
        val accessToken = sharedPreferencesHelper.getData(applicationContext, "ACCESS_TOKEN")

        Log.d("TAG", "The username is $username and the access token is $accessToken")
    }
}