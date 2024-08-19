package com.github.pedrobonelli.msviacep.service;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pedrobonelli.msviacep.dto.EnderecoDTO;
import com.github.pedrobonelli.msviacep.model.EnderecoModel;
import com.github.pedrobonelli.msviacep.service.exception.ClientHttpException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class EnderecoService {

    public EnderecoDTO getCep(String cep){
        String url = "https://viacep.com.br/ws/" + cep + "/json";

        try{
            URI uri = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            ObjectMapper mapper = new ObjectMapper();
            EnderecoModel endereco = mapper.readValue(body, EnderecoModel.class);
            return new EnderecoDTO(endereco);
        } catch (IOException | InterruptedException e){
            throw new ClientHttpException("Error");
        }
    }

}
