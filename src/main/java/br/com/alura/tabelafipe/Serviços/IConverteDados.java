package br.com.alura.tabelafipe.Serviços;

import java.util.List;

public interface IConverteDados {
    <T> T obterdados(String json, Class<T> classe);
    <T> List<T> obterList(String json, Class<T> classe);
}
