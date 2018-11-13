package com.vita1.rest;

import com.google.gson.reflect.TypeToken;
import com.vita1.api.Flight;
import com.vita1.app.ServerInterfaceImpl;


import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

@Path("/flight")
public class flightRest {
    List<Flight> flights = ServerInterfaceImpl.getFlights();
    @GET // This annotation indicates GET request
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("origem") String origem, @QueryParam("destino") String destino,
                         @QueryParam("dataIda") String dataIda, @QueryParam("dataVolta") String dataVolta,
                         @QueryParam("numeroPessoas") Long numeroPessoas) {
        Type listType = new TypeToken<List<Flight>>() {}.getType();
        Gson gson = new Gson();
        String userIdList = gson.toJson(flights, listType);
        return Response.ok(userIdList).build();
    }

    @POST
    @Path("/buy")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buy(@QueryParam("origem") String origem, @QueryParam("destino") String destino,
                        @QueryParam("dataIda") String dataIda, @QueryParam("dataVolta") String dataVolta,
                        @QueryParam("numeroPessoas") Long numeroPessoas) {
        if(ServerInterfaceImpl.buyFlight()) {
            return Response.ok().build();
        }
        else
            return Response.serverError().build();
    }
}