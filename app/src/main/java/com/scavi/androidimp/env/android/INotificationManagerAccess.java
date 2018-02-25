package com.scavi.androidimp.env.android;

import android.app.Notification;
import android.app.NotificationChannel;

public interface INotificationManagerAccess {
    void notify(final int id,
                final Notification notification);

    void createNotificationChannel(final NotificationChannel channel);
}
