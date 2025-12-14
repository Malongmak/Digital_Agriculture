package com.makertest.app.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aJ\u0006\u0010%\u001a\u00020\u001aJ\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\u001aJ\u0006\u0010\'\u001a\u00020\u001aJ\u0006\u0010(\u001a\u00020\u001aR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/makertest/app/viewmodel/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "profileRepository", "Lcom/makertest/app/data/repository/ProfileRepository;", "(Lcom/makertest/app/data/repository/ProfileRepository;)V", "_farmFields", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/makertest/app/data/models/FarmField;", "_selectedFieldId", "", "_showAddFieldDialog", "", "_userProfile", "Lcom/makertest/app/data/models/UserProfile;", "farmFields", "Lkotlinx/coroutines/flow/StateFlow;", "getFarmFields", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedFieldId", "getSelectedFieldId", "showAddFieldDialog", "getShowAddFieldDialog", "userProfile", "getUserProfile", "addFarmField", "", "name", "cropType", "size", "", "location", "deleteField", "fieldId", "editField", "hideAddFieldDialog", "loadFarmFields", "loadUserProfile", "selectField", "showEditProfileDialog", "updateTestCount", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.repository.ProfileRepository profileRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.makertest.app.data.models.UserProfile> _userProfile = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.UserProfile> userProfile = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.makertest.app.data.models.FarmField>> _farmFields = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.FarmField>> farmFields = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _showAddFieldDialog = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> showAddFieldDialog = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedFieldId = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedFieldId = null;
    
    @javax.inject.Inject
    public ProfileViewModel(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.repository.ProfileRepository profileRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.makertest.app.data.models.UserProfile> getUserProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.FarmField>> getFarmFields() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getShowAddFieldDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedFieldId() {
        return null;
    }
    
    public final void loadUserProfile() {
    }
    
    public final void loadFarmFields() {
    }
    
    public final void showAddFieldDialog() {
    }
    
    public final void hideAddFieldDialog() {
    }
    
    public final void addFarmField(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String cropType, float size, @org.jetbrains.annotations.NotNull
    java.lang.String location) {
    }
    
    public final void editField(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId) {
    }
    
    public final void deleteField(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId) {
    }
    
    public final void selectField(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId) {
    }
    
    public final void showEditProfileDialog() {
    }
    
    public final void updateTestCount() {
    }
}