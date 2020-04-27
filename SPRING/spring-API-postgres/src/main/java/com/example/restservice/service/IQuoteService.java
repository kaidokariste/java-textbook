package com.example.restservice.service;

import com.example.restservice.model.Tsitaadid;

import java.util.List;

public interface IQuoteService {
    List<Tsitaadid> findAll();
    Tsitaadid save(Tsitaadid tsitaadid);
}
