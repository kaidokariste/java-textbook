package com.example.restservice.repository;

import com.example.restservice.model.Tsitaadid;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository

public interface QuoteRepository extends CrudRepository<Tsitaadid, Long> {
}
