package co.ke.soundcloud.util

import androidx.recyclerview.widget.DiffUtil
import co.ke.soundcloud.ui.playlist.model.Track

/**
 * Class compares existing and new lists allowing adapters to refresh faster
 * This is more important when you are loading large amounts of data into a list.
 */

class TrackDiffCallback(private val newTracks: List<Track>, private val oldTracks: List<Track>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldTracks.size
    }

    override fun getNewListSize(): Int {
        return newTracks.size
    }

    /**
     * method leverages on the equals override on the data class
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTracks[oldItemPosition].id == newTracks[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTracks[oldItemPosition] == newTracks[newItemPosition]
    }
}