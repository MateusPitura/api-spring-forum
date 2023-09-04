package com.mobilebee.api.topico;

import java.lang.reflect.Field;

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
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topico")
public class Controller {
    @Autowired
    private RepositoryDefault repositoryDefault;

    @Autowired
    private RepositoryPageable repositoryPageable;

    @PostMapping
    @Transactional
    public ResponseEntity create(@Valid @RequestBody DtoCreate d, UriComponentsBuilder u){
        Topico t = new Topico(d);
        repositoryDefault.save(t);
        var p = u.path("/topico/{id}").buildAndExpand(t.getId()).toUri();
        return ResponseEntity.created(p).body(new DtoCreate(t));
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(
        size = 10, 
        page = 0, 
        sort = "dataCriacao",
        direction = Sort.Direction.DESC
    ) Pageable p, @RequestParam(name = "ano", required = false) String ano){
        Class<?> classe = Topico.class;
        Field[] campos = classe.getDeclaredFields();
        for(Field campo : campos){
            if(p.getSort().toString().contains(campo.getName())){
                if(ano == null){
                    return ResponseEntity.ok(repositoryPageable.listar(p));
                }          
                return ResponseEntity.ok(repositoryPageable.listarPeloAno(p, ano));       
            }
        }
        return ResponseEntity.badRequest().body("O atributo informado não existe");
    }

    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id){
        DtoRead d = repositoryDefault.encontrarPeloId(id);
        if(d!=null){
            return ResponseEntity.ok(d);
        }
        return ResponseEntity.badRequest().body("O id informado não existe ou foi excluído");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody DtoUpdate d){
        Topico topico = repositoryDefault.getReferenceByIdAndStatusTrue(id);
        if(topico!=null){
            topico.update(d);
            return ResponseEntity.ok(new DtoUpdate(topico));
        }
        return ResponseEntity.badRequest().body("O id informado não existe ou foi excluído");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        Topico topico = repositoryDefault.getReferenceByIdAndStatusTrue(id);
        if(topico!=null){
            topico.delete();
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("O id informado não existe ou foi excluído");
    }
}
