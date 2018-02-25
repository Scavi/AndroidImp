package com.scavi.androidimp.env.android;

import android.content.Context;

import static com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;

/**
 * @author Michael Heymel
 */
public interface IProviderInstaller {

    /**
     * Installs the provider asynchronous.
     *
     * @param context  the context to global information about the application environment
     * @param listener the provider listener for the result
     */
    void installIfNeededAsync(final Context context,
                              final ProviderInstallListener listener);
}
