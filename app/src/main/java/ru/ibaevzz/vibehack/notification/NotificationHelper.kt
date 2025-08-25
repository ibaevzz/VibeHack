package ru.ibaevzz.vibehack.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import ru.ibaevzz.vibehack.R
import javax.inject.Inject

class NotificationHelper @Inject constructor(private val context: Context) {
    private val notificationManager: NotificationManager by lazy {
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    fun showNotification(
        title: String,
        message: String,
        intent: Intent? = null,
        requestCode: Int = 0
    ) {
        NotificationChannelHelper.createNotificationChannel(context)

        val pendingIntent = intent?.let {
            PendingIntent.getActivity(
                context,
                requestCode,
                it,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }

        val notification = NotificationCompat.Builder(context, NotificationChannelHelper.getChannelId())
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(requestCode, notification)
    }
}