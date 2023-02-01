package com.example.services;

import com.example.dto.DataDto;
import com.example.exception.EntryException;
import com.example.model.Entry;

import java.util.List;

public interface ApiServices {

    public List<DataDto> getListByCategory(String category) throws EntryException;

    public Entry insertEntry(Entry entry) throws EntryException;

}
