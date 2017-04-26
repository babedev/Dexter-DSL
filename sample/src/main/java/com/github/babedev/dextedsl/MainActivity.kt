package com.github.babedev.dextedsl

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.babedev.dexter.dsl.runtimePermission
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_single_permission.setOnClickListener {
            runtimePermission {
                permission(Manifest.permission.READ_EXTERNAL_STORAGE) {
                    granted {
                        toast("Permission granted")
                    }

                    denied {
                        toast("Permission denied")
                    }

                    rationaleShouldBeShown { _, token ->
                        token.continuePermissionRequest()
                    }
                }
            }
        }

        btn_multiple_permission.setOnClickListener {
            runtimePermission {
                permissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CALL_PHONE) {
                    checked {
                        toast("Permission checked")
                    }

                    rationaleShouldBeShown { _, token ->
                        token.continuePermissionRequest()
                    }
                }
            }
        }
    }
}
