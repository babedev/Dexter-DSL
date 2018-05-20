package com.github.babedev.dextedsl

import android.Manifest
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.babedev.dexter.dsl.runtimePermission

class MainFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        runtimePermission {
            permission(Manifest.permission.READ_EXTERNAL_STORAGE) {
                granted {
                    Toast.makeText(activity!!, "Permission granted", Toast.LENGTH_LONG).show()
                }

                denied {
                    Toast.makeText(activity!!, "Permission denied", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}