package co.ke.soundcloud.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    public fun convertToString(millis: Long):String{
        val date = Date(millis)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault())
        return format.format(date)    }
}