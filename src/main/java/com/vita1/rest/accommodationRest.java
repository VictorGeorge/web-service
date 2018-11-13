package com.vita1.rest;

import com.google.gson.reflect.TypeToken;
import com.vita1.api.Accommodation;
import com.vita1.app.ServerInterfaceImpl;


import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

@Path("/accommodation")
public class accommodationRest {
    List<Accommodation> accommodations = ServerInterfaceImpl.getAccommodations();
    @GET // This annotation indicates GET request
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("hotel") String hotel,
                         @QueryParam("dataEntrada") String dataEntrada, @QueryParam("dataSaida") String dataSaida,
                         @QueryParam("numeroQuartos") Long numeroQuartos, @QueryParam("numeroPessoas") Long numeroPessoas) {
        Type listType = new TypeToken<List<Accommodation>>() {}.getType();
        Gson gson = new Gson();
        String userIdList = gson.toJson(accommodations, listType);
        return Response.ok(userIdList).build();
    }

    @POST
    @Path("/buy")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buy(@QueryParam("hotel") String hotel,
                        @QueryParam("dataEntrada") String dataEntrada, @QueryParam("dataSaida") String dataSaida,
                        @QueryParam("numeroQuartos") Long numeroQuartos, @QueryParam("numeroPessoas") Long numeroPessoas) {
        if(ServerInterfaceImpl.buyFlight()) {
            return Response.ok().build();
        }
        else
            return Response.serverError().build();
    }
}