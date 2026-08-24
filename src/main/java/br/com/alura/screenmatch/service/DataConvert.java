package br.com.alura.screenmatch.service;

import tools.jackson.databind.ObjectMapper;

public class DataConvert implements IDataConvert{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> classe) {
        return mapper.readValue(json, classe);
    }
}
