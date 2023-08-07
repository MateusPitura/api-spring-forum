package com.mobilebee.api.topico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/topico")
public class Controller {
    @Autowired
    private Repository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody DtoCreate d){
        repository.save(new Topico(d));
    }

    @GetMapping
    public List<DtoRead> read(){
        return repository.listar();
    }
}
