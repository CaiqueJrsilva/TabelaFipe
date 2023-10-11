package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.Serviços.ConsumoApi;
import br.com.alura.tabelafipe.Serviços.ConverteDados;
import br.com.alura.tabelafipe.models.Tipo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String URLBASE= "https://parallelum.com.br/fipe/api/v1/";
    private ConverteDados conversor = new ConverteDados();
    private ConsumoApi consumo = new ConsumoApi();

    public void exibeMenu() {
        var menu = """
                ***OPPCAO***
                Carro
                Moto
                Caminhoes
                
                Digite a opçao desejada :
                """;
        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if(opcao.toLowerCase().contains("carr")){
            endereco = URLBASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URLBASE + "motos/marcas";
        } else {
            endereco = URLBASE + "caminhoes/marcas";
        }
        var json = consumo.obterDados(endereco);
        System.out.println(json);

        var marcas = conversor.obterList(json, Tipo.class);

        marcas.stream()
                .sorted(Comparator.comparing(Tipo::codigo))
                .forEach(System.out::println);
    }
}
