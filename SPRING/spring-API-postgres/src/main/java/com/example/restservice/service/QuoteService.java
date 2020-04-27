package com.example.restservice.service;

import com.example.restservice.model.Tsitaadid;
import com.example.restservice.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService implements IQuoteService{

    @Autowired
    private QuoteRepository repository;

    @Override
    public List<Tsitaadid> findAll() {
        return (List<Tsitaadid>) repository.findAll();
    }

    @Override
    public Tsitaadid save(Tsitaadid tsitaat) {
        return repository.save(tsitaat);
    }

}
