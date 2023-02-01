package com.example.controller;

import com.example.dto.DataDto;
import com.example.exception.EntryException;
import com.example.model.Entry;
import com.example.services.ApiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    private ApiServices apiServices;


    @GetMapping("/{category}")
    public ResponseEntity<List<DataDto>> getListByCategoryHandler(@PathVariable String category) throws EntryException {
        List<DataDto> allList = apiServices.getListByCategory(category);
        return new ResponseEntity<List<DataDto>>(allList, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Entry> insertEntryHandler(@RequestBody Entry entry) throws EntryException{
        Entry entry1 = apiServices.insertEntry(entry);
        return new ResponseEntity<Entry>(entry1,HttpStatus.CREATED);
    }
}
