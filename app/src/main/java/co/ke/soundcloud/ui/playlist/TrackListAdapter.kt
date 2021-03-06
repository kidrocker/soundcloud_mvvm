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
import co.ke.soundcloud.ui.playlist.model.Track
import co.ke.soundcloud.util.TrackDiffCallback
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


/**
 * Class loads the track list item
 */
class TrackListAdapter : RecyclerView.Adapter<TrackListAdapter.ItemViewHolder>() {

    private var tracks: List<Track> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.track_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val track = tracks[position]
        holder.title.text = track.title
        holder.artist.text = track.user.userName

        // using glide for efficient image loading and caching
        Glide.with(holder.itemView)
            .load(track.artwork)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(12)))
            .placeholder(R.drawable.ic_outline_image_24) // default image before artwork loads
            .into(holder.albumArt)
    }

    override fun getItemCount() = tracks.size

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.trackTitleText)
        val artist: TextView = view.findViewById(R.id.trackSubtitleText)
        val albumArt: ImageView = view.findViewById(R.id.albumArtworkImage)
    }

    /**
     * Submits, compares tracks in an effient manner using Diffutil
     */
    fun submitTrackList(newList: List<Track>) {
        val oldList = tracks
        val diffResult: DiffUtil.DiffResult = calculateDiff(TrackDiffCallback(oldList, newList))
        tracks = newList
        diffResult.dispatchUpdatesTo(this)
    }
}