package com.example.restservice.controller;

import com.example.restservice.model.Tsitaadid;
import com.example.restservice.service.QuoteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Quotations")
public class TsitaadidController {

    @Resource
    QuoteService quoteService;

    @GetMapping(value = "/quotesList")
    public List<Tsitaadid> getQuotes() {
        return quoteService.findAll();
    }

    @PostMapping(path = "/createQuote", consumes = "application/json")
    public Tsitaadid createQuote(@RequestBody Tsitaadid quote) {
        return quoteService.save(quote);
    }

}
