package com.example.datasecurity

import android.content.pm.PackageInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        val info : PackageInfo = intent.extras?.get("packageInfo") as PackageInfo
        var text  = ""
        val permissions:TextView = findViewById(R.id.Permissions)
        if(info.permissions!=null){
        for ((cnt) in info.permissions.withIndex()) {
            text += info.permissions[cnt].toString() + "\n"
        }




            permissions.text = text
        }
        else
            permissions.text = "No Permissions Required"
    }
}