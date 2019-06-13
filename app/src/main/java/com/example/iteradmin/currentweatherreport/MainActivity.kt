package com.example.iteradmin.currentweatherreport

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b=findViewById<Button>(R.id.save)
        val e=findViewById<EditText>(R.id.city)
        val t=findViewById<TextView>(R.id.text)
        val queue=Volley.newRequestQueue(this)
        val url="https://api.openweathermap.org/data/2.5/weather?q="
        val api= "&appid=49bb28a4136ed7bf5ae53787433eab30"

        b.setOnClickListener{
           val complink=url+e.text.toString()+api
           val jsnRequest:JsonObjectRequest= JsonObjectRequest(Request.Method.GET,complink,null,Response.Listener<JSONObject> {
               response ->
               val ar:JSONObject=response.getJSONObject("coord")
               val s:String="longitude:"+ar.get("lon")+"lattitude:"+ar.get("lat")
               t.text=s
           },
                   Response.ErrorListener{

           })
            queue.add(jsnRequest)
        }
    }
}
