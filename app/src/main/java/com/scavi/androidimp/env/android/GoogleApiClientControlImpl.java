package com.scavi.androidimp.env.android;

import android.app.PendingIntent;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/**
 * @author Michael Heymel
 */
public class GoogleApiClientControlImpl implements ILocationClientControl {
    private static final String TAG = "GoogleApiClientControl";
    private final GoogleApiClient mLocationClient;


    /**
     * Constructor
     *
     * @param googleApiClient the Google play API client
     */
    public GoogleApiClientControlImpl(final GoogleApiClient googleApiClient) {
        mLocationClient = googleApiClient;
    }


    @Override
    public void connect() {
        if (mLocationClient != null) {
            mLocationClient.connect();
        }
    }


    @Override
    public void disconnect() {
        if (mLocationClient != null) {
            mLocationClient.disconnect();
        }
    }


    @Override
    public boolean isConnecting() {
        return mLocationClient != null && mLocationClient.isConnecting();
    }


    @Override
    public boolean isConnected() {
        return mLocationClient != null && mLocationClient.isConnected();
    }


    @Override
    public void requestLocationUpdates(final LocationRequest locationRequest,
                                       final LocationListener locationListener) {
        if (mLocationClient != null) {
            try {
                LocationServices.FusedLocationApi.requestLocationUpdates(mLocationClient,
                        locationRequest,
                        locationListener);
            } catch (SecurityException ex) {
                Log.w(TAG, ex.getMessage(), ex);
                throw ex;
            }
        }
    }


    @Override
    public void requestLocationUpdates(LocationRequest locationRequest,
                                       PendingIntent pendingIntent) {
        if (mLocationClient != null) {
            try {
                LocationServices.FusedLocationApi.requestLocationUpdates(mLocationClient,
                        locationRequest,
                        pendingIntent);
            } catch (SecurityException ex) {
                Log.w(TAG, ex.getMessage(), ex);
                throw ex;
            }
        }
    }


    @Override
    public void removeLocationUpdates(final LocationListener listener) {
        if (mLocationClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mLocationClient, listener);
        }
    }


    @Override
    public void removeLocationUpdates(final PendingIntent callbackIntent) {
        if (mLocationClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mLocationClient,
                    callbackIntent);
        }
    }
}
