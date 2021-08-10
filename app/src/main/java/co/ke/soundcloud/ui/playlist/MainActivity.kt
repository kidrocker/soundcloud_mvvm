package co.ke.soundcloud.ui.playlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.ke.soundcloud.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint  // Application entry point
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}