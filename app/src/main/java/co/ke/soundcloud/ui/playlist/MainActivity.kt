package co.ke.soundcloud.ui.playlist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.ke.soundcloud.R
import co.ke.soundcloud.core.Resource
import co.ke.soundcloud.ui.playlist.data.remote.Playlist
import co.ke.soundcloud.util.Constants.PLAYLIST_ID
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * Class is concern with with UI based interactions
 */
@AndroidEntryPoint  // Application entry point
class MainActivity : AppCompatActivity() {

    private val playlistViewModel: PlaylistViewModel by viewModels()
    private lateinit var adapter: TrackListAdapter
    private lateinit var playlistTitle: TextView
    private lateinit var playlistSize: TextView
    private lateinit var trackList: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var mainView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ui
        playlistTitle = findViewById(R.id.titleText)
        playlistSize = findViewById(R.id.trackCountText)
        trackList = findViewById(R.id.trackList)
        progressBar = findViewById(R.id.progressBar)
        mainView = findViewById(R.id.mainView)
        adapter = TrackListAdapter()

        // set up the recyclerview
        trackList.adapter = adapter
        trackList.layoutManager = LinearLayoutManager(this@MainActivity)


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
                    updateUI(playlist = playlist.data)
                }

                is Resource.Failure -> {
                    showErrorMessage(playlist.error)
                }

                is Resource.Loading -> {
                    progressBar.showProgress(true)
                }
            }
        }
    }

    private fun updateUI(playlist: Playlist) {
        progressBar.showProgress(false)

        playlistTitle.text = playlist.title
        playlistSize.text = "${playlist.tracks.size} tracks"
        adapter.updateTrackList(playlist.tracks)
    }

    private fun showErrorMessage(message: String) {
        progressBar.showProgress(false)
        Snackbar.make(mainView, message, Snackbar.LENGTH_SHORT).show()
    }

    /**
     * Use kotlin extensions to extend functionality
     * We extend progress bar as the visibility toggle is used on multiple places
     */
    private fun ProgressBar.showProgress(state: Boolean) {
        visibility = when (state) {
            true -> View.VISIBLE
            false -> View.GONE
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