package com.scavi.androidimp.env.android;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class NotificationManagerAccessImpl implements INotificationManagerAccess {
    private final NotificationManager mNotificationManager;

    public NotificationManagerAccessImpl(final Context context) {
        this(context.getSystemService(Context.NOTIFICATION_SERVICE) !=
                null ? (NotificationManager) context.getSystemService(Context
                .NOTIFICATION_SERVICE) : null);
    }

    NotificationManagerAccessImpl(@Nullable final NotificationManager notificationManager) {
        mNotificationManager = notificationManager;
    }


    /**
     * @see {@link NotificationManager#notify(int, Notification)}
     */
    @Override
    public void notify(final int id,
                       final Notification notification) {
        if (mNotificationManager != null) {
            mNotificationManager.notify(id, notification);
        }
    }


    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public void createNotificationChannel(final NotificationChannel channel) {
        if (mNotificationManager != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotificationManager.createNotificationChannel(channel);
        }
    }
}
