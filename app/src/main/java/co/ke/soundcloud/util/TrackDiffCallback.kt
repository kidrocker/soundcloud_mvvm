package co.ke.soundcloud.util

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import co.ke.soundcloud.ui.playlist.data.remote.Track


class TrackDiffCallback(private val newTracks: List<Track>, private val oldTracks: List<Track>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldTracks.size
    }

    override fun getNewListSize(): Int {
        return newTracks.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTracks[oldItemPosition].id == newTracks[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTracks[oldItemPosition] == newTracks[newItemPosition]
    }
}