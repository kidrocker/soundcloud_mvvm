package co.ke.soundcloud.ui.playlist

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.ke.soundcloud.R
import co.ke.soundcloud.core.Resource
import co.ke.soundcloud.util.Constants.PLAYLIST_ID
import dagger.hilt.android.AndroidEntryPoint

/**
 * Class is concern with with UI based interactions
 */
@AndroidEntryPoint  // Application entry point
class MainActivity : AppCompatActivity() {

    private val playlistViewModel: PlaylistViewModel by viewModels()
    private lateinit var adapter: TrackListAdapter
    private lateinit var playlistTitle: TextView
    private lateinit var playlistDuration: TextView
    private lateinit var trackList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ui
        playlistTitle = findViewById(R.id.titleText)
        playlistDuration = findViewById(R.id.durationText)
        trackList = findViewById(R.id.trackList)


        // set up the recyclerview
        trackList.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        // subscribe to state change observers
        subscribeToObservers()

        // Request playlist from the repository
        // The playlist ID should come from an intent/ callback
        // Since that is beyond the project scope we hardcode
        // this method is not expected to return values
        playlistViewModel.getPlaylist(PLAYLIST_ID)
    }

    private fun subscribeToObservers() {
        playlistViewModel.playlist.observe(this) { playlist ->
            when (playlist) {
                is Resource.Success -> {

                }

                is Resource.Failure -> {

                }

                is Resource.Loading -> {

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unSubScribeObservers()
    }

    /**
     * unsubscribe from observers
     * We do not need any more updates on the data
     * Though not a must, it is a good practice
     */
    private fun unSubScribeObservers() {
        playlistViewModel.playlist.removeObservers(this)
    }
}