package com.vita1.app;

import com.vita1.api.Accommodation;
import com.vita1.api.Flight;
import com.vita1.api.SearchParams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServerInterfaceImpl {

    private static List<Flight> flights = new ArrayList();
    private static List<Accommodation> accommodations = new ArrayList();
    private static final ServerInterfaceImpl INSTANCE = new ServerInterfaceImpl();

    ServerInterfaceImpl(){

        flights.add(new Flight("CWB", "GRU", "10/02/2019", 150, 100));
        flights.add(new Flight("GRU", "CWB", "11/02/2019", 140, 100));
        flights.add(new Flight("CWB", "REC", "10/02/2019", 150, 100));
        flights.add(new Flight("REC", "CWB", "11/02/2019", 150, 100));
        flights.add(new Flight("GRU", "YYZ", "10/02/2019", 150, 100));
        flights.add(new Flight("YYZ", "GRU", "11/02/2019", 150, 100));
        flights.add(new Flight("JFK", "GRU", "10/02/2019", 150, 100));
        flights.add(new Flight("GRU", "JFK", "11/02/2019", 150, 100));
        flights.add(new Flight("q", "w", "e", 150, 100));

        accommodations.add(new Accommodation(0, "Copacabana", "10/02/2019", "14/02/2019", 100, 400, 320, 100, 420));
        accommodations.add(new Accommodation(1, "b", "11/02/2019", "11/02/2019", 120, 420, 320, 100, 420));
    }

    public static ServerInterfaceImpl getInstance() {
        return INSTANCE;
    }

    public static List<Flight> getFlights(){
        return flights;
    }

    public static List<Flight> getFlights(SearchParams searchParams){
        //filter through flights
        Stream<Flight> departureFlightStream = flights.stream().filter(flight ->
                ((searchParams.origem == null) || (flight.getOrigem().equals(searchParams.origem))) &&
                        ((searchParams.destino == null) || (flight.getDestino().equals(searchParams.destino))) &&
                        ((searchParams.dataIda == null) || (flight.getData().equals(searchParams.dataIda))) &&
                        ((searchParams.numeroPessoas <= 0) || (flight.getVagas() >= searchParams.numeroPessoas))
        );
        if(searchParams.dataVolta != null){ //If there's return flight we check if there is also one to add to return
            Stream<Flight> departureFlightStreamReturn = flights.stream().filter(flight ->
                    ((searchParams.destino == null) || (flight.getOrigem().equals(searchParams.destino))) &&
                            ((searchParams.origem == null) || (flight.getDestino().equals(searchParams.origem))) &&
                            ((searchParams.dataVolta == null) || (flight.getData().equals(searchParams.dataVolta))) &&
                            ((searchParams.numeroPessoas <= 0) || (flight.getVagas() >= searchParams.numeroPessoas)));

            return Stream.concat(departureFlightStream, departureFlightStreamReturn).collect(Collectors.toList()); //returns merge of 2 lists
        }
        return departureFlightStream.collect(Collectors.toList());
    }

    public static List<Accommodation> getAccommodations(){return accommodations;}



    public static boolean buyFlight(){return true;}

    public static boolean buyAccommodation(){return true;}

    public void addFlight(String origem,String destino,String data, int vagas, int preço){
        flights.add(new Flight(origem, destino, data, vagas, preço));
    }

}
