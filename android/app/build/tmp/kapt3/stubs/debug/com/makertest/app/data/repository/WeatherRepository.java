package com.makertest.app.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/makertest/app/data/repository/WeatherRepository;", "", "()V", "generateSampleWeatherData", "Lcom/makertest/app/data/models/WeatherData;", "location", "", "getCurrentWeather", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
public final class WeatherRepository {
    
    @javax.inject.Inject
    public WeatherRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.makertest.app.data.models.WeatherData> getCurrentWeather(@org.jetbrains.annotations.NotNull
    java.lang.String location) {
        return null;
    }
    
    private final com.makertest.app.data.models.WeatherData generateSampleWeatherData(java.lang.String location) {
        return null;
    }
}