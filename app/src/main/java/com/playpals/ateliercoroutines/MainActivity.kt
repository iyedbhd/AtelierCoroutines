package com.playpals.ateliercoroutines

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.playpals.ateliercoroutines.repository.api.TestApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val policy = ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextView>(R.id.textView)


        val btn = findViewById<Button>(R.id.fetchBtn)
        val btn2 = findViewById<Button>(R.id.fetchBtn2)
        btn.setOnClickListener {
            name.text = "Getting data...";
            GlobalScope.launch {

                try {
                    val response = TestApi.getApi()?.getData()?.execute();
                    if (response?.code() == 200) {
                        name.text = response.body()?.data;
                    } else {
                        println(response?.message());
                    }
                }
                catch (e:Exception)
                {

                }

            }

            /**/

        }

        btn2.setOnClickListener {
            val response = TestApi.getApi()?.getData()?.execute();
            if (response?.code() == 200) {
                name.text = response.body()?.data;
            } else {
                println(response?.message());
            }

        }


/*

*/
    }
}