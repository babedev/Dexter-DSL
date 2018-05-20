package com.github.babedev.dextedsl

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.github.babedev.dexter.dsl.runtimePermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_single_permission.setOnClickListener {
            runtimePermission {
                permission(Manifest.permission.READ_EXTERNAL_STORAGE) {
                    granted {
                        Toast.makeText(this@MainActivity, "Permission granted", Toast.LENGTH_LONG).show()
                    }

                    denied {
                        Toast.makeText(this@MainActivity, "Permission denied", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        btn_multiple_permission.setOnClickListener {
            runtimePermission {
                permissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CALL_PHONE) {
                    checked {
                        Toast.makeText(this@MainActivity, "Permission checked", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
