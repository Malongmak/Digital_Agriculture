package com.makertest.app.bluetooth;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0007J\u0006\u0010\u001e\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u0017J\u0013\u0010 \u001a\u0004\u0018\u00010!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/makertest/app/bluetooth/BluetoothManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_connectedDevice", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/bluetooth/BluetoothDevice;", "_connectionState", "Lcom/makertest/app/bluetooth/BluetoothConnectionState;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "bluetoothSocket", "Landroid/bluetooth/BluetoothSocket;", "connectedDevice", "Lkotlinx/coroutines/flow/StateFlow;", "getConnectedDevice", "()Lkotlinx/coroutines/flow/StateFlow;", "connectionState", "getConnectionState", "connectToDevice", "", "device", "(Landroid/bluetooth/BluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "", "getPairedDevices", "", "hasBluetoothPermission", "isBluetoothEnabled", "readData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCommand", "command", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class BluetoothManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private final android.bluetooth.BluetoothManager bluetoothManager = null;
    @org.jetbrains.annotations.Nullable
    private final android.bluetooth.BluetoothAdapter bluetoothAdapter = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> _connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<android.bluetooth.BluetoothDevice> _connectedDevice = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<android.bluetooth.BluetoothDevice> connectedDevice = null;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothSocket bluetoothSocket;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String MAKERTEST_UUID = "00001101-0000-1000-8000-00805F9B34FB";
    @org.jetbrains.annotations.NotNull
    public static final com.makertest.app.bluetooth.BluetoothManager.Companion Companion = null;
    
    @javax.inject.Inject
    public BluetoothManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> getConnectionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<android.bluetooth.BluetoothDevice> getConnectedDevice() {
        return null;
    }
    
    public final boolean isBluetoothEnabled() {
        return false;
    }
    
    public final boolean hasBluetoothPermission() {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<android.bluetooth.BluetoothDevice> getPairedDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object connectToDevice(@org.jetbrains.annotations.NotNull
    android.bluetooth.BluetoothDevice device, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    public final void disconnect() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendCommand(@org.jetbrains.annotations.NotNull
    java.lang.String command, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object readData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/makertest/app/bluetooth/BluetoothManager$Companion;", "", "()V", "MAKERTEST_UUID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}