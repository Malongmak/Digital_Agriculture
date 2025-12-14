package com.makertest.app;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = MakerTestApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface MakerTestApplication_GeneratedInjector {
  void injectMakerTestApplication(MakerTestApplication makerTestApplication);
}
