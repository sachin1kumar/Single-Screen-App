package com.manager.singlescreenapp.com.mockito.configuration;

import org.mockito.configuration.DefaultMockitoConfiguration;

public class MockitoConfiguration extends DefaultMockitoConfiguration {

    @Override
    public boolean enableClassCache() {
        return false;
    }
}
