package com.vita1.app;

import com.vita1.rest.accommodationRest;
import com.vita1.rest.flightRest;
import com.vita1.api.Flight;

import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class flightApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    ServerInterfaceImpl flights = ServerInterfaceImpl.getInstance();
    public flightApplication() {
        // Register our service
        singletons.add(new flightRest());
        singletons.add(new accommodationRest());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
