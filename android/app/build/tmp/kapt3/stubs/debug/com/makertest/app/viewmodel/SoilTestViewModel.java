package com.makertest.app.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0011\u0010$\u001a\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020 J\u0006\u0010\'\u001a\u00020 J\u000e\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0010J\u0006\u0010*\u001a\u00020 J\u0006\u0010+\u001a\u00020 J\b\u0010,\u001a\u00020 H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/makertest/app/viewmodel/SoilTestViewModel;", "Landroidx/lifecycle/ViewModel;", "bluetoothManager", "Lcom/makertest/app/bluetooth/BluetoothManager;", "repository", "Lcom/makertest/app/data/repository/SoilTestRepository;", "(Lcom/makertest/app/bluetooth/BluetoothManager;Lcom/makertest/app/data/repository/SoilTestRepository;)V", "_connectionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/makertest/app/bluetooth/BluetoothConnectionState;", "_deviceInfo", "Lcom/makertest/app/data/models/DeviceInfo;", "_recommendations", "", "Lcom/makertest/app/ui/components/Recommendation;", "_selectedFieldId", "", "_soilTestData", "Lcom/makertest/app/data/models/SoilTestResult;", "connectionState", "Lkotlinx/coroutines/flow/StateFlow;", "getConnectionState", "()Lkotlinx/coroutines/flow/StateFlow;", "deviceInfo", "getDeviceInfo", "recommendations", "getRecommendations", "selectedFieldId", "getSelectedFieldId", "soilTestData", "getSoilTestData", "generateRecommendations", "", "soilData", "parseSoilData", "data", "readSoilData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshDeviceStatus", "saveTestResult", "setSelectedField", "fieldId", "startNewTest", "startSoilAnalysis", "updateDeviceInfo", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SoilTestViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.bluetooth.BluetoothManager bluetoothManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.repository.SoilTestRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> _connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.makertest.app.data.models.SoilTestResult> _soilTestData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.SoilTestResult> soilTestData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.makertest.app.ui.components.Recommendation>> _recommendations = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.ui.components.Recommendation>> recommendations = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.makertest.app.data.models.DeviceInfo> _deviceInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.DeviceInfo> deviceInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedFieldId = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedFieldId = null;
    
    @javax.inject.Inject
    public SoilTestViewModel(@org.jetbrains.annotations.NotNull
    com.makertest.app.bluetooth.BluetoothManager bluetoothManager, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.repository.SoilTestRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.makertest.app.bluetooth.BluetoothConnectionState> getConnectionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.SoilTestResult> getSoilTestData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.ui.components.Recommendation>> getRecommendations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.DeviceInfo> getDeviceInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedFieldId() {
        return null;
    }
    
    public final void startSoilAnalysis() {
    }
    
    private final java.lang.Object readSoilData(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.makertest.app.data.models.SoilTestResult parseSoilData(java.lang.String data) {
        return null;
    }
    
    private final void generateRecommendations(com.makertest.app.data.models.SoilTestResult soilData) {
    }
    
    private final void updateDeviceInfo() {
    }
    
    public final void refreshDeviceStatus() {
    }
    
    public final void saveTestResult() {
    }
    
    public final void startNewTest() {
    }
    
    public final void setSelectedField(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId) {
    }
}