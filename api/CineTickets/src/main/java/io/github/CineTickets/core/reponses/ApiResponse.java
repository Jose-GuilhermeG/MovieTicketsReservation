package io.github.CineTickets.core.reponses;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse <T>(
        LocalDateTime timestamp,
        String detail,
        T data
){
    public ApiResponse(String detail){
        this(LocalDateTime.now() , detail , null);
    }

    public ApiResponse(String detail , T data){
        this(LocalDateTime.now() , detail , data);
    }
}
