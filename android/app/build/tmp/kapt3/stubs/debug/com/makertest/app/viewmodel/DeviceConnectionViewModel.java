package com.makertest.app.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0019J\b\u0010 \u001a\u00020\u0019H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/makertest/app/viewmodel/DeviceConnectionViewModel;", "Landroidx/lifecycle/ViewModel;", "bluetoothManager", "Lcom/makertest/app/bluetooth/BluetoothManager;", "(Lcom/makertest/app/bluetooth/BluetoothManager;)V", "_connectionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/makertest/app/bluetooth/BluetoothConnectionState;", "_deviceInfo", "Lcom/makertest/app/data/models/DeviceInfo;", "_isScanning", "", "_pairedDevices", "", "Landroid/bluetooth/BluetoothDevice;", "connectionState", "Lkotlinx/coroutines/flow/StateFlow;", "getConnectionState", "()Lkotlinx/coroutines/flow/StateFlow;", "deviceInfo", "getDeviceInfo", "isScanning", "pairedDevices", "getPairedDevices", "connectToDevice", "", "deviceAddress", "", "disconnect", "loadPairedDevices", "refreshDeviceStatus", "startScanning", "updateDeviceInfo", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class DeviceConnectionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.bluetooth.BluetoothManager bluetoothManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> _connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<android.bluetooth.BluetoothDevice>> _pairedDevices = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<android.bluetooth.BluetoothDevice>> pairedDevices = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isScanning = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isScanning = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.makertest.app.data.models.DeviceInfo> _deviceInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.DeviceInfo> deviceInfo = null;
    
    @javax.inject.Inject
    public DeviceConnectionViewModel(@org.jetbrains.annotations.NotNull
    com.makertest.app.bluetooth.BluetoothManager bluetoothManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> getConnectionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<android.bluetooth.BluetoothDevice>> getPairedDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isScanning() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.DeviceInfo> getDeviceInfo() {
        return null;
    }
    
    public final void loadPairedDevices() {
    }
    
    public final void startScanning() {
    }
    
    public final void connectToDevice(@org.jetbrains.annotations.NotNull
    java.lang.String deviceAddress) {
    }
    
    public final void disconnect() {
    }
    
    public final void refreshDeviceStatus() {
    }
    
    private final void updateDeviceInfo() {
    }
}