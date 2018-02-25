package com.scavi.androidimp.env.android;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothServerSocket;
import android.content.Context;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

/**
 * @author Michael Heymel
 */
public interface IBluetoothAdapterControl {
    boolean isEnabled();

    BluetoothServerSocket listenUsingRfcommWithServiceRecord(final String name,
                                                             final UUID uuid)
            throws IOException;

    BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(final String name,
                                                                     final UUID uuid)
            throws IOException;

    boolean isDiscovering();

    boolean startDiscovery();

    boolean cancelDiscovery();

    Set<BluetoothDevice> getBondedDevices();

    boolean enable();

    boolean disable();

    int getState();

    boolean getProfileProxy(final Context context,
                            final BluetoothProfile.ServiceListener listener,
                            final int profile);

    void closeProfileProxy(final int profile,
                           final BluetoothProfile proxy);
}
