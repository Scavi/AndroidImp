package com.scavi.androidimp.env.android;

import android.content.Context;

import com.scavi.androidimp.util.AndroidVersionHelper;

import javax.annotation.ParametersAreNonnullByDefault;


/**
 * @author Michael Heymel
 */
@ParametersAreNonnullByDefault
public class AirplaneModeControlImpl implements IAirplaneModeControl {

    @Override
    public boolean isAirplaneModeEnabled(final Context context) {
        return AndroidVersionHelper.isAirplaneModeOn(context);
    }
}
