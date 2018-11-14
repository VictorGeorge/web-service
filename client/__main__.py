import requests

url = 'http://localhost'

flights_path = '/flight/'
accommodation_path = '/accommodation/'

def main(args=None):
    while True:
        option = input("1 - Hospedagem\n2 - Passagem de aviao")
        if option == 1:
            hotel = input("Hotel: ")
            data_entrada = input("Data da Entrada: ")
            data_saida = input("Data da Saida: ")
            numero_quartos = input("Numero de Quartos: ")
            numero_pessoas = input("Numero de Pessoas: ")

            params = {'hotel': hotel, 'dataEntrada': data_entrada, 'dataSaida': data_saida, 'numeroQuartos': numero_quartos,
                      'numeroPessoas': numero_pessoas}

            r = requests.get(url + accommodation_path, params)
            if r.ok:
                json = r.json()
                print(json)

                option2 = input("1 - Comprar\n2 - Voltar ao menu")
                if option2 == 1:
                    r2 = requests.post(url + accommodation_path + "buy", params)
                    if r2.ok:
                        json = r2.json()
                        print(json)
                    else:
                        r2.raise_for_status()
                else:
                    return
            else:
                r.raise_for_status()
            return
        elif option == 2:
            origem = input("Origem: ")
            destino = input("Destino: ")
            data_ida = input("Data da Ida: ")
            data_volta = input("Data da Volta: ")
            numero_pessoas = input("Numero de Pessoas: ")

            params = {'origem': origem, 'destino': destino, 'dataIda': data_ida, 'dataVolta': data_volta,
                      'numeroPessoas': numero_pessoas}

            r = requests.get(url + accommodation_path, params)
            if r.ok:
                json = r.json()
                print(json)

                option2 = input("1 - Comprar\n2 - Voltar ao menu")
                if option2 == 1:
                    r2 = requests.post(url + accommodation_path + "buy", params)
                    if r2.ok:
                        json = r2.json()
                        print(json)
                    else:
                        r2.raise_for_status()
                else:
                    return
            else:
                r.raise_for_status()
            return
        else:
            break
    return
