package com.example.datasecurity

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list : List<PackageInfo> = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS)

        val rv : RecyclerView = findViewById(R.id.rv)

        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.adapter = Adapter(list,packageManager,this::itemClickHandler)
    }

    private fun itemClickHandler(packageInfo:PackageInfo){
        val intent = Intent(this,PermissionActivity::class.java)
        intent.putExtra("packageInfo",packageInfo)
        startActivity(intent)
    }

}