package io.github.CineTickets.exceptions;

public class NotExistsException extends RuntimeException {
    public NotExistsException(String field , String value) {
        super(createMessage(field,value));
    }

    public NotExistsException(Integer id){
        super(createMessage("id" , id.toString()));
    }

    public static String createMessage(String field , String value){
        return String.format("a %s with %s not exists" , field , value);
    }
}
