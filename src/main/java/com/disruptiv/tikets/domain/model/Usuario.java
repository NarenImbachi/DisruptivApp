package com.disruptiv.tikets.domain.model;

import com.disruptiv.tikets.domain.exception.BusinessException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Usuario {

    private Long id;
    private String nombre;
    private String email;

    public static Usuario crear( String nombre, String email) {

        validarNombre(nombre);
        validarEmail(email);

        return new Usuario(null, nombre, email);
    }

    private static void validarNombre(String nombre) {
        if(nombre == null || nombre.isBlank()) 
            throw new BusinessException("El nombre del usuario es obligatorio");
    }

    private static void validarEmail(String email) {

        if(email == null || email.isBlank()) 
            throw new BusinessException("El correo es obligatorio");

        //Podria mas adelante validar el formato del email con una expresion regular
    }
}