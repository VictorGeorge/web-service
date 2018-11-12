package com.vita1.rest;

import com.google.gson.reflect.TypeToken;
import com.vita1.api.Flight;
import com.vita1.app.ServerInterfaceImpl;


import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

@Path("/")
public class flightRest {
    List<Flight> flights = ServerInterfaceImpl.getFlights();
    @GET // This annotation indicates GET request
    @Path("/flight")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Type listType = new TypeToken<List<Flight>>() {}.getType();
        Gson gson = new Gson();
        String userIdList = gson.toJson(flights, listType);
        return Response.ok(userIdList).build();
    }
}