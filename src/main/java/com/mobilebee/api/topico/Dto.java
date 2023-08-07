package com.mobilebee.api.topico;

public record Dto(
    String titulo,
    String mensagem,
    String autor,
    Curso curso
){}
