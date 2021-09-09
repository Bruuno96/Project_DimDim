package com.project.DimDim.exception;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException(String mensagem){
        super(mensagem);
    }
}
