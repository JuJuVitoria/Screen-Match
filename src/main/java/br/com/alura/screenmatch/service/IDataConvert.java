package br.com.alura.screenmatch.service;

public interface IDataConvert {
    <T> T getData(String json, Class<T> classe);
}
