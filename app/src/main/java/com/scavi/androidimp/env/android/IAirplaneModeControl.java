package com.scavi.androidimp.env.android;

import android.app.Activity;
import android.content.Context;


/**
 * @author Michael Heymel
 */
public interface IAirplaneModeControl {
    /**
     * Determines if the airplane mode is activated or not
     *
     * @param context the context to global information about the application environment
     * @return <code>true</code>The airplane mode is activated<br> <code>false</code> the airplane
     * mode is deactivated (or no context is specified)
     */
    boolean isAirplaneModeEnabled(final Context context);
}
