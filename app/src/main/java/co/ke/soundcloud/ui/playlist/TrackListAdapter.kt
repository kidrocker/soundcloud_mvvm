package co.ke.soundcloud.ui.playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import co.ke.soundcloud.R
import co.ke.soundcloud.ui.playlist.data.remote.Track
import co.ke.soundcloud.util.TrackDiffCallback
import com.bumptech.glide.Glide


/**
 * Class loads the track list item
 */
class TrackListAdapter : RecyclerView.Adapter<TrackListAdapter.ItemViewHolder>() {

    private var tracks:List<Track> =ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.track_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val track = tracks[position]
        holder.title.text = track.title
        holder.artist.text =  track.user.userName

        Glide.with(holder.itemView)
            .load(track.artwork)
            .placeholder(R.drawable.ic_outline_image_24) // default image before artwork loads
            .into(holder.albumArt)
    }

    override fun getItemCount() = tracks.size

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.trackTitleText)
        val artist: TextView = view.findViewById(R.id.trackSubtitleText)
        val albumArt: ImageView = view.findViewById(R.id.albumArtworkImage)
    }

    fun updateTrackList(newList: List<Track>) {
        val oldList = tracks
        val diffResult: DiffUtil.DiffResult = calculateDiff(TrackDiffCallback(oldList, newList))
        tracks = newList
        diffResult.dispatchUpdatesTo(this)
    }
}