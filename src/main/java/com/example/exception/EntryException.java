package com.example.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntryException extends  Exception{

    public EntryException (String str){
        super(str);
    }
}
