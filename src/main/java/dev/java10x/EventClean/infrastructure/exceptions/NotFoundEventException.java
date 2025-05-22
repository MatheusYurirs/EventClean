package dev.java10x.EventClean.infrastructure.exceptions;

public class NotFoundEventException extends RuntimeException{

    public NotFoundEventException (String msg){
        super(msg);
    }
}
