package com.scavi.androidimp.env.android;

import android.content.Context;

import com.google.android.gms.security.ProviderInstaller;

import static com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;

/**
 * @author Michael Heymel
 */
public class ProviderInstallerImpl implements IProviderInstaller {
    /**
     * Installs the provider asynchronous.
     *
     * @param context  the context to global information about the application environment
     * @param callback the provider listener for the result
     */
    @Override
    public void installIfNeededAsync(final Context context,
                                     final ProviderInstallListener callback) {
        ProviderInstaller.installIfNeededAsync(context, callback);
    }
}
