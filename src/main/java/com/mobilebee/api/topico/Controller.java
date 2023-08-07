package com.mobilebee.api.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/topico")
public class Controller {
    @Autowired
    private RepositoryDefault repositoryDefault;

    @Autowired
    private RepositoryPageable repositoryPageable;

    @PostMapping
    @Transactional
    public void create(@RequestBody DtoCreate d){
        repositoryDefault.save(new Topico(d));
    }

    @GetMapping
    public Page<DtoRead> read(@PageableDefault(
        size = 10, 
        page = 0, 
        sort = "dataCriacao",
        direction = Sort.Direction.DESC
    ) Pageable p){
        return repositoryPageable.listar(p);
    }

    @GetMapping("/{ano}")
    public Page<DtoRead> read(@PageableDefault(
        size = 10, 
        page = 0, 
        sort = "dataCriacao",
        direction = Sort.Direction.DESC
    ) Pageable p, @PathVariable(required = false) String ano){
        return repositoryPageable.listarPeloAno(p, ano);
    }
}
