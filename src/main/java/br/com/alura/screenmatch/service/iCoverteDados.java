package br.com.alura.screenmatch.service;

public interface iCoverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
