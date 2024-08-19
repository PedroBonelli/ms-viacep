package com.github.pedrobonelli.msviacep.controller;

import com.github.pedrobonelli.msviacep.service.EnderecoService;
import com.github.pedrobonelli.msviacep.dto.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoDTO> getCep(@PathVariable("cep") String cep){
        EnderecoDTO dto = service.getCep(cep);
        return ResponseEntity.ok(dto);
    }


}
