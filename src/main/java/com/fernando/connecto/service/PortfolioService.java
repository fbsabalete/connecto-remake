package com.fernando.connecto.service;

import com.fernando.connecto.exceptions.ObjectNotFoundException;
import com.fernando.connecto.model.Portfolio;
import com.fernando.connecto.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private UserService userService;

    public Portfolio save(Portfolio portfolio){
        userService.findById(portfolio.getUser().getId());
        return portfolioRepository.save(portfolio);
    }

    public Portfolio update(long id, Portfolio portfolio){
        findById(id);
        userService.findById(portfolio.getUser().getId());
        portfolio.setId(id);
        return portfolioRepository.save(portfolio);
    }

    public void delete(long id){
        findById(id);
        portfolioRepository.deleteById(id);
    }

    private Portfolio findById(long id) {
        return portfolioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object id="+id+"not found"));
    }

}
