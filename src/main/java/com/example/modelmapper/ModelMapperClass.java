package com.example.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperClass {
    public static ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
