package com.vita1.rest;

import com.google.gson.reflect.TypeToken;
import com.vita1.api.Accommodation;
import com.vita1.api.SearchParams;
import com.vita1.app.ServerInterfaceImpl;


import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

@Path("/package")
public class packageRest {
    @GET // This annotation indicates GET request
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("origem") String origem, @QueryParam("destino") String destino,
                         @QueryParam("dataIda") String dataIda, @QueryParam("dataVolta") String dataVolta, @QueryParam("hotel") String hotel,
                         @QueryParam("dataEntrada") String dataEntrada, @QueryParam("dataSaida") String dataSaida,
                         @QueryParam("numeroQuartos") int numeroQuartos, @QueryParam("numeroPessoas") int numeroPessoas) {
        SearchParams searchParams = new SearchParams(hotel, dataEntrada, dataSaida, numeroQuartos, numeroPessoas, origem, destino, dataIda, dataVolta);
        List<Object> filteredPackages = ServerInterfaceImpl.getPackages(searchParams);
        Type listType = new TypeToken<List<Accommodation>>() {}.getType();
        Gson gson = new Gson();
        String userIdList = gson.toJson(filteredPackages, listType);
        return Response.ok(userIdList).build();
    }

    @POST
    @Path("/buy")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buy(@FormParam("origem") String origem, @FormParam("destino") String destino,
                        @FormParam("dataIda") String dataIda, @FormParam("dataVolta") String dataVolta, @FormParam("hotel") String hotel,
                        @FormParam("dataEntrada") String dataEntrada, @FormParam("dataSaida") String dataSaida,
                        @FormParam("numeroQuartos") int numeroQuartos, @FormParam("numeroPessoas") int numeroPessoas) {
        SearchParams searchParams = new SearchParams(hotel, dataEntrada, dataSaida, numeroQuartos, numeroPessoas, origem, destino, dataIda, dataVolta);
        if(ServerInterfaceImpl.buyPackage(searchParams)) {
            return Response.ok().build();
        }
        else
            return Response.serverError().build();
    }
}
