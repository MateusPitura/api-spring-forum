package com.mobilebee.api.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DtoCreate(
    @NotBlank(message = "O titulo não pode ser vazio")
    String titulo,
    @Pattern(regexp = "^(?!\s+$).+", message = "A mensagem não pode ser vazia")
    String mensagem,
    @NotBlank(message = "O autor não pode ser vazio")
    String autor,
    @NotNull(message = "O curso não pode ser vazio")
    Curso curso
){
    public DtoCreate(Topico t){
        this(t.getTitulo(), t.getMensagem(), t.getAutor(), t.getCurso());
    }
}
