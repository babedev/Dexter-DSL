# Dexter DSL
[![Download](https://api.bintray.com/packages/babedev/maven/Dexter-DSL/images/download.svg) ](https://bintray.com/babedev/maven/Dexter-DSL/_latestVersion)
[![Build Status](https://travis-ci.org/babedev/Dexter-DSL.svg?branch=master)](https://travis-ci.org/babedev/Dexter-DSL)

Dexter runtime permission with Kotlin DSL style

Download
--------
```gradle
repositories {
  ..
  maven { url "https://dl.bintray.com/babedev/maven" }
  ..
}

dependencies {
  ..
  compile 'com.github.babedev.dexter.dsl:dsl:1.0.0'
  ..
}
```

Sample
--------
```Kotlin
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
```

Libraries used in this project
------------------------------

* [Dexter][1]

[1]: https://github.com/Karumi/Dexter