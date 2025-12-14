package com.makertest.app.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010$\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/makertest/app/viewmodel/NGOPartnersViewModel;", "Landroidx/lifecycle/ViewModel;", "ngoRepository", "Lcom/makertest/app/data/repository/NGORepository;", "(Lcom/makertest/app/data/repository/NGORepository;)V", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_ngoPartners", "", "Lcom/makertest/app/data/models/NGOPartner;", "_selectedTab", "", "_workshops", "Lcom/makertest/app/data/models/NGOWorkshop;", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "ngoPartners", "getNgoPartners", "selectedTab", "getSelectedTab", "workshops", "getWorkshops", "contactNGO", "", "ngoId", "", "loadNGOPartners", "loadWorkshops", "registerForWorkshop", "workshopId", "", "selectTab", "index", "viewNGODetails", "viewWorkshopDetails", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class NGOPartnersViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.repository.NGORepository ngoRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.makertest.app.data.models.NGOPartner>> _ngoPartners = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.NGOPartner>> ngoPartners = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.makertest.app.data.models.NGOWorkshop>> _workshops = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.NGOWorkshop>> workshops = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _selectedTab = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> selectedTab = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    
    @javax.inject.Inject
    public NGOPartnersViewModel(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.repository.NGORepository ngoRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.NGOPartner>> getNgoPartners() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.makertest.app.data.models.NGOWorkshop>> getWorkshops() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSelectedTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    public final void loadNGOPartners() {
    }
    
    public final void loadWorkshops() {
    }
    
    public final void selectTab(int index) {
    }
    
    public final void contactNGO(long ngoId) {
    }
    
    public final void viewNGODetails(long ngoId) {
    }
    
    public final void registerForWorkshop(@org.jetbrains.annotations.NotNull
    java.lang.String workshopId) {
    }
    
    public final void viewWorkshopDetails(@org.jetbrains.annotations.NotNull
    java.lang.String workshopId) {
    }
}