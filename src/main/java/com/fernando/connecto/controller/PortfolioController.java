package com.fernando.connecto.controller;

import com.fernando.connecto.model.Portfolio;
import com.fernando.connecto.model.dto.PortfolioDTO;
import com.fernando.connecto.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<PortfolioDTO> save(@RequestBody @Valid Portfolio portfolio){
        return ResponseEntity.status(HttpStatus.CREATED).body(new PortfolioDTO(portfolioService.save(portfolio)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioDTO> update(@PathVariable long id, @RequestBody @Valid Portfolio portfolio){
        return ResponseEntity.ok(new PortfolioDTO(portfolioService.update(id, portfolio)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        portfolioService.delete(id);
        return ResponseEntity.ok().build();
    }

}
