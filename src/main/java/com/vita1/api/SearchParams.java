package com.vita1.api;

public class SearchParams{
    public String hotel;
    public String dataEntrada;
    public String dataSaida;
    public int numeroQuartos;
    public int numeroPessoas;
    public boolean idaEVolta;
    public String origem;
    public String destino;
    public String dataIda;
    public String dataVolta;
    public int preço;

    public SearchParams(String hotel, String dataEntrada, String dataSaida, int numeroQuartos, int numeroPessoas) {
        this.hotel = hotel;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.numeroQuartos = numeroQuartos;
        this.numeroPessoas = numeroPessoas;
    }

    public SearchParams(String hotel, String dataEntrada, String dataSaida, int numeroQuartos, int numeroPessoas, String origem, String destino, String dataIda, String dataVolta) {
        this.hotel = hotel;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.numeroQuartos = numeroQuartos;
        this.numeroPessoas = numeroPessoas;
        this.origem = origem;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
    }

    public SearchParams(String origem, String destino, String dataIda, String dataVolta, int numeroPessoas) {
        this.origem = origem;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.numeroPessoas = numeroPessoas;
    }
}

