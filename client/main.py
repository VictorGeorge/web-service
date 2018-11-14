import requests
import os

os.environ['NO_PROXY'] = '127.0.0.1'
url = 'http://127.0.0.1'

flights_path = '/flight/'
accommodation_path = '/accommodation/'
package_path = '/package/'


def main():
    while True:
        option = input("1 - Hospedagem\n2 - Passagem de aviao\n3 - Pacotes\n4 - Sair\n")

        if option == '1':
            hotel = input("Hotel: ")
            data_entrada = input("Data da Entrada: ")
            data_saida = input("Data da Saida: ")
            numero_quartos = input("Numero de Quartos: ")
            numero_pessoas = input("Numero de Pessoas: ")

            query_string = {}

            if hotel != '':
                query_string['hotel'] = hotel

            if data_entrada != '':
                query_string['dataEntrada'] = data_entrada

            if data_saida != '':
                query_string['dataSaida'] = data_saida

            if numero_quartos != '':
                query_string['numeroQuartos'] = numero_quartos

            if numero_pessoas != '':
                query_string['numeroPessoas'] = numero_pessoas

            path = url + accommodation_path

            r = requests.get(path, params=query_string)
            if r.ok:
                json = r.json()
                if json != "[]":
                    print(json)
                else:
                    print("NADA ENCONTRADO COM ESSAS CARACTERISTICAS!\n")

                option2 = input("1 - Comprar\n2 - Voltar ao menu\n")
                if option2 == '1':
                    r2 = requests.post(url + accommodation_path + "buy/", data=query_string)
                    if r2.ok:
                        print("COMPRA EFETUADA!!!")
                    else:
                        r2.raise_for_status()
            else:
                r.raise_for_status()
        elif option == '2':
            origem = input("Origem: ")
            destino = input("Destino: ")
            data_ida = input("Data da Ida: ")
            data_volta = input("Data da Volta: ")
            numero_pessoas = input("Numero de Pessoas: ")

            query_string = {}

            if origem != '':
                query_string['origem'] = origem

            if destino != '':
                query_string['destino'] = destino

            if data_ida != '':
                query_string['dataIda'] = data_ida

            if data_volta != '':
                query_string['dataVolta'] = data_volta

            if numero_pessoas != '':
                query_string['numeroPessoas'] = numero_pessoas

            path = url + flights_path

            r = requests.get(path, params=query_string)
            if r.ok:
                json = r.json()
                if json != "[]":
                    print(json)
                else:
                    print("NADA ENCONTRADO COM ESSAS CARACTERISTICAS!\n")

                option2 = input("1 - Comprar\n2 - Voltar ao menu\n")
                if option2 == '1':
                    r2 = requests.post(path + "buy/", data=query_string)
                    if r2.ok:
                        print("COMPRA EFETUADA!!!")
                    else:
                        r2.raise_for_status()
            else:
                r.raise_for_status()
        elif option == '3':
            origem = input("Origem: ")
            destino = input("Destino: ")
            data_ida = input("Data da Ida: ")
            data_volta = input("Data da Volta: ")
            hotel = input("Hotel: ")
            data_entrada = input("Data da Entrada: ")
            data_saida = input("Data da Saida: ")
            numero_quartos = input("Numero de Quartos: ")
            numero_pessoas = input("Numero de Pessoas: ")

            query_string = {}

            if origem != '':
                query_string['origem'] = origem

            if destino != '':
                query_string['destino'] = destino

            if data_ida != '':
                query_string['dataIda'] = data_ida

            if data_volta != '':
                query_string['dataVolta'] = data_volta

            if hotel != '':
                query_string['hotel'] = hotel

            if data_entrada != '':
                query_string['dataEntrada'] = data_entrada

            if data_saida != '':
                query_string['dataSaida'] = data_saida

            if numero_quartos != '':
                query_string['numeroQuartos'] = numero_quartos

            if numero_pessoas != '':
                query_string['numeroPessoas'] = numero_pessoas

            path = url + package_path

            r = requests.get(path, params=query_string)
            if r.ok:
                json = r.json()
                if json != "[]":
                    print(json)
                else:
                    print("NADA ENCONTRADO COM ESSAS CARACTERISTICAS!\n")

                option2 = input("1 - Comprar\n2 - Voltar ao menu\n")
                if option2 == '1':
                    r2 = requests.post(path + "buy/", data=query_string)
                    if r2.ok:
                        print("COMPRA EFETUADA!!!")
                    else:
                        r2.raise_for_status()
            else:
                r.raise_for_status()
        else:
            break
    return


if __name__ == "__main__":
    main()
