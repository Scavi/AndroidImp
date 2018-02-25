package com.scavi.androidimp.env.android;

import android.app.PendingIntent;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

/**
 * @author Michael Heymel
 */
public interface ILocationClientControl {
    void connect();

    /**
     * The disconnect of the used location client
     */
    void disconnect();

    /**
     * Verifies if the location client is currently connecting
     *
     * @return <code>true</code> is connecting <br> <code>false</code> is not connecting
     */
    boolean isConnecting();

    /**
     * Verifies if the location client is currently connected
     *
     * @return <code>true</code> is connected <br> <code>false</code> is not connected
     */
    boolean isConnected();

    /**
     * Requests location updates for the given location request object for the passed {@link
     * LocationListener}
     *
     * @param locationRequest  the location request object
     * @param locationListener the location listener to process the locations
     */
    void requestLocationUpdates(final LocationRequest locationRequest,
                                final LocationListener locationListener);

    /**
     * Requests location updates for the given location request object for the passed {@link
     * PendingIntent}
     *
     * @param locationRequest the location request object
     * @param pendingIntent   the pending intent to process the the locations
     */
    void requestLocationUpdates(final LocationRequest locationRequest,
                                final PendingIntent pendingIntent);

    /**
     * Removes the location request object for the listener
     */
    void removeLocationUpdates(final LocationListener listener);

    /**
     * Removes the location request object for the pending intent
     */
    void removeLocationUpdates(final PendingIntent callbackIntent);
}
