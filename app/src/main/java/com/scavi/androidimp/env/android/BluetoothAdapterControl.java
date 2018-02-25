package com.scavi.androidimp.env.android;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.bluetooth.BluetoothServerSocket;
import android.content.Context;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

/**
 * @author Michael Heymel
 */
public class BluetoothAdapterControl implements IBluetoothAdapterControl {
    private static final String TAG = "BluetoothAdapterControl";
    private BluetoothAdapter mBtAdapter;


    public BluetoothAdapterControl() {
        this(null);
    }


    public BluetoothAdapterControl(final BluetoothAdapter btAdapter) {
        mBtAdapter = btAdapter;
    }


    @Override
    public boolean isEnabled() {
        boolean retVal = false;
        try {
            retVal = isEnabled(mBtAdapter != null ? mBtAdapter : getBtAdapter());
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return retVal;
    }


    /**
     * Call the IBluetoothAdapterControl#isEnabled() in a safe manner. This might be necessary
     * because under some circumstances the {@link BluetoothAdapter} object was removed by the GC
     */
    private boolean isEnabled(final BluetoothAdapter adapter) {
        return adapter != null && adapter.isEnabled();
    }


    @Override
    public BluetoothServerSocket listenUsingRfcommWithServiceRecord(final String name,
                                                                    final UUID uuid) throws
            IOException {
        BluetoothServerSocket socket = null;
        try {
            socket = listenUsingRfcommWithServiceRecord(
                    mBtAdapter != null ? mBtAdapter : getBtAdapter(), name, uuid);
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return socket;
    }


    private BluetoothServerSocket listenUsingRfcommWithServiceRecord(
            final BluetoothAdapter adapter,
            final String name,
            final UUID uuid) throws IOException {
        return adapter != null ? adapter.listenUsingRfcommWithServiceRecord(name, uuid) : null;
    }


    @Override
    public BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(final String name,
                                                                            final UUID uuid)
            throws IOException {
        BluetoothServerSocket socket = null;
        try {
            socket = listenUsingInsecureRfcommWithServiceRecord(
                    mBtAdapter != null ? mBtAdapter : getBtAdapter(), name, uuid);
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return socket;
    }


    private BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(
            final BluetoothAdapter adapter,
            final String name,
            final UUID uuid) throws IOException {
        return adapter != null ? adapter.listenUsingInsecureRfcommWithServiceRecord(name, uuid) :
                null;
    }


    @Override
    public boolean isDiscovering() {
        return isDiscovering(mBtAdapter != null ? mBtAdapter : getBtAdapter());
    }


    private boolean isDiscovering(final BluetoothAdapter adapter) {
        boolean retVal = false;
        try {
            retVal = adapter != null && adapter.isDiscovering();
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return retVal;
    }


    @Override
    public boolean startDiscovery() {
        boolean retVal = false;
        try {
            retVal = startDiscovery(mBtAdapter != null ? mBtAdapter : getBtAdapter());
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return retVal;
    }


    private boolean startDiscovery(final BluetoothAdapter adapter) {
        return adapter != null && adapter.startDiscovery();
    }


    @Override
    public boolean cancelDiscovery() {
        boolean retVal = false;
        try {
            retVal = cancelDiscovery(mBtAdapter != null ? mBtAdapter : getBtAdapter());
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return retVal;
    }


    private boolean cancelDiscovery(final BluetoothAdapter adapter) {
        boolean retVal = false;
        try {
            retVal = adapter != null && adapter.cancelDiscovery();
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return retVal;
    }


    @Override
    public Set<BluetoothDevice> getBondedDevices() {
        Set<BluetoothDevice> devices = null;
        try {
            devices = getBondedDevices(mBtAdapter != null ? mBtAdapter : getBtAdapter());
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return devices;
    }


    private Set<BluetoothDevice> getBondedDevices(final BluetoothAdapter adapter) {
        return adapter != null ? adapter.getBondedDevices() : null;
    }


    @Override
    public boolean enable() {
        return enable(mBtAdapter != null ? mBtAdapter : getBtAdapter());
    }


    private boolean enable(final BluetoothAdapter adapter) {
        return adapter != null && adapter.enable();
    }


    @Override
    public boolean disable() {
        boolean retVal = false;
        try {
            retVal = disable(mBtAdapter != null ? mBtAdapter : getBtAdapter());
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return retVal;
    }


    private boolean disable(final BluetoothAdapter adapter) {
        return adapter != null && adapter.disable();
    }


    private BluetoothAdapter getBtAdapter() {
        if (mBtAdapter == null) {
            try {
                Looper.prepare();
            } catch (Exception e) {
                Log.w(TAG, e.getMessage(), e);
            }
            mBtAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        return mBtAdapter;
    }


    @Override
    public int getState() {
        return mBtAdapter != null ? mBtAdapter.getState() : BluetoothAdapter.ERROR;
    }


    @Override
    public boolean getProfileProxy(final Context context,
                                   final ServiceListener listener,
                                   final int profile) {
        boolean retVal = false;
        try {
            retVal = getProfileProxy(mBtAdapter != null ? mBtAdapter : getBtAdapter(),
                    context,
                    listener,
                    profile);
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
        return retVal;
    }


    private boolean getProfileProxy(final BluetoothAdapter adapter,
                                    final Context context,
                                    final ServiceListener listener,
                                    final int profile) {
        boolean isValid = false;
        if (adapter != null) {
            isValid = adapter.getProfileProxy(context, listener, profile);
        }
        return isValid;
    }


    @Override
    public void closeProfileProxy(final int profile,
                                  final BluetoothProfile proxy) {
        if (mBtAdapter != null) {
            try {
                mBtAdapter.closeProfileProxy(profile, proxy);
            } catch (Exception e) {
                Log.w(TAG, e.getMessage(), e);
            }
        }
    }
}
