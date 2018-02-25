/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.scavi.androidimp.util;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.widget.TextView;

import com.scavi.androidimp.env.android.INotificationManagerAccess;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class AndroidVersionHelper {
    private static final String TAG = "AndroidVersionHelper";

    /**
     * Private constructor for the helper
     */
    private AndroidVersionHelper() {
    }

    /**
     * @param context  the context to global information about the application environment
     * @param textView the text view we want to set the appearance
     * @param style    the appearance style
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static void setTextAppearance(final Context context,
                                         final TextView textView,
                                         @StyleRes final int style) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            textView.setTextAppearance(context, style);
        } else {
            textView.setTextAppearance(style);
        }
    }


    /**
     * Determines if the airplane mode of the phone is enabled or disabled
     *
     * @param context the context to global information about the application environment
     * @return <code>true</code>The airplane mode is enabled<br> <code>false</code> the airplane
     * mode is disabled
     */
    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean isAirplaneModeOn(final Context context) {
        boolean isActivated = false;
        try {
            isActivated = Settings.Global.getInt(context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON,
                    0) != 0;
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return isActivated;
    }


    /**
     * This method creates a channel id. Since Android 8.1 it is required to create / register the
     * ID.
     *
     * @param manager    the notification access manager
     * @param id         the created id
     * @param name       the name
     * @param importance the importance
     * @return The created channel ID for the notification
     */
    @TargetApi(Build.VERSION_CODES.O)
    public static String createNotificationChannelId(final INotificationManagerAccess manager,
                                                     final String id,
                                                     final String name,
                                                     final int importance) {
        // in earlier versions the ID will be ignored.
        // https://developer.android.com/reference/android/support/v4/app/NotificationCompat.
        // Builder.html#NotificationCompat.Builder(android.content.Context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(id, name, importance);
            manager.createNotificationChannel(channel);
        }
        return id;
    }
}
