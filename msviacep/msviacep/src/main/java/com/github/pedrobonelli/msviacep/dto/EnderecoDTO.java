package com.github.pedrobonelli.msviacep.dto;

import com.github.pedrobonelli.msviacep.model.EnderecoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public EnderecoDTO(EnderecoModel entity){
        this.cep = entity.getCep();
        this.localidade = entity.getLogradouro();
        this.logradouro = entity.getLogradouro();
        this.complemento = entity.getComplemento();
        this.bairro = entity.getBairro();
        this.uf = entity.getUf();
    }


}
