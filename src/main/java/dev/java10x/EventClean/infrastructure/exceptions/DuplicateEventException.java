package dev.java10x.EventClean.infrastructure.exceptions;

public class DuplicateEventException extends RuntimeException{

    public DuplicateEventException(String msg){
        super(msg);
    }
}
