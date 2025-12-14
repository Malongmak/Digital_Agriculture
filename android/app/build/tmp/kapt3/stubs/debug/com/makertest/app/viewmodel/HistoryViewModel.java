package com.makertest.app.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001aJ\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0006\u0010\u001f\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\nJ\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013\u00a8\u0006#"}, d2 = {"Lcom/makertest/app/viewmodel/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "soilTestRepository", "Lcom/makertest/app/data/repository/SoilTestRepository;", "profileRepository", "Lcom/makertest/app/data/repository/ProfileRepository;", "(Lcom/makertest/app/data/repository/SoilTestRepository;Lcom/makertest/app/data/repository/ProfileRepository;)V", "_farmFields", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/makertest/app/data/models/FarmField;", "_isLoading", "", "_selectedField", "_testHistory", "Lcom/makertest/app/data/models/SoilTestData;", "farmFields", "Lkotlinx/coroutines/flow/StateFlow;", "getFarmFields", "()Lkotlinx/coroutines/flow/StateFlow;", "isLoading", "selectedField", "getSelectedField", "testHistory", "getTestHistory", "deleteTest", "", "testId", "", "loadFarmFields", "loadFilteredHistory", "loadTestHistory", "selectField", "field", "viewTestDetails", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.repository.SoilTestRepository soilTestRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.repository.ProfileRepository profileRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.makertest.app.data.models.SoilTestData>> _testHistory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.SoilTestData>> testHistory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.makertest.app.data.models.FarmField> _selectedField = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.FarmField> selectedField = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.makertest.app.data.models.FarmField>> _farmFields = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.FarmField>> farmFields = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    
    @javax.inject.Inject
    public HistoryViewModel(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.repository.SoilTestRepository soilTestRepository, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.repository.ProfileRepository profileRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.SoilTestData>> getTestHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.FarmField> getSelectedField() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.FarmField>> getFarmFields() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    public final void loadTestHistory() {
    }
    
    public final void loadFarmFields() {
    }
    
    public final void selectField(@org.jetbrains.annotations.Nullable
    com.makertest.app.data.models.FarmField field) {
    }
    
    private final void loadFilteredHistory() {
    }
    
    public final void viewTestDetails(long testId) {
    }
    
    public final void deleteTest(long testId) {
    }
}