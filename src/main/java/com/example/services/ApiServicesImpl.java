package com.example.services;

import com.example.dto.DataDto;
import com.example.dto.EntriesDto;
import com.example.exception.EntryException;
import com.example.model.Entry;
import com.example.repository.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServicesImpl implements ApiServices{

    @Autowired
    private EntryRepo entryRepo;

    // API that lists the title, description based on the category passed as an
    // input parameter.
    @Override
    public List<DataDto> getListByCategory(String category) throws EntryException {

        RestTemplate restTemplate = new RestTemplate();
        EntriesDto allEntry = restTemplate.getForObject("https://api.publicapis.org/entries",EntriesDto.class);
        List<DataDto> myList = new ArrayList<>();
        System.out.println("Chirag:-" + allEntry.getEntries() );
        for(Entry e: allEntry.getEntries()){
            if(e.getCategory().equals(category)){
                myList.add(new DataDto(e.getApi(),e.getDescription()));
            }
        }
        if(myList.size() == 0){
            throw new EntryException("Entry for category not found: " + category);
        }
        return myList;
    }


    @Override
    public Entry insertEntry(Entry entry) {
        return null;
    }
}
