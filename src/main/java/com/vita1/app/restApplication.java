package com.vita1.app;

import com.vita1.rest.accommodationRest;
import com.vita1.rest.flightRest;
import com.vita1.rest.packageRest;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class restApplication extends javax.ws.rs.core.Application {
    private Set<Object> singletons = new HashSet<Object>();
    public restApplication() {
        // Register our service
        singletons.add(new flightRest());
        singletons.add(new accommodationRest());
        singletons.add(new packageRest());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
