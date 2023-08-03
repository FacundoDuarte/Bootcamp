package com.facundoduarte.mvc.mvc.services;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Ninja;
import com.facundoduarte.mvc.mvc.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
}
