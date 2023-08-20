package com.mobilebee.api.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity create(@RequestBody DtoCreate d, UriComponentsBuilder u){
        Topico t = new Topico(d);
        repositoryDefault.save(t);
        var p = u.path("/topico/{id}").buildAndExpand(t.getId()).toUri();
        return ResponseEntity.created(p).body(new DtoCreate(t));
    }

    @GetMapping
    public ResponseEntity<Page<DtoRead>> list(@PageableDefault(
        size = 10, 
        page = 0, 
        sort = "dataCriacao",
        direction = Sort.Direction.DESC
    ) Pageable p, @RequestParam(name = "ano", required = false) String ano){
        if(ano == null){
            return ResponseEntity.ok(repositoryPageable.listar(p));
        }          
        return ResponseEntity.ok(repositoryPageable.listarPeloAno(p, ano));
    }

    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id){
        return ResponseEntity.ok(repositoryDefault.encontrarPeloId(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long id, @RequestBody DtoUpdate d){
        Topico topico = repositoryDefault.getReferenceByIdAndStatusTrue(id);
        topico.update(d);
        return ResponseEntity.ok(new DtoUpdate(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        Topico topico = repositoryDefault.getReferenceByIdAndStatusTrue(id);
        topico.delete();
        return ResponseEntity.noContent().build();
    }
}
