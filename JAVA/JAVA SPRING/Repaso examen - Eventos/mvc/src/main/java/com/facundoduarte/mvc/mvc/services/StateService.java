package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.State;
import com.facundoduarte.mvc.mvc.repositories.StateRepository;

@Service
public class StateService {
    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> allStates() {
        return stateRepository.findAll();
    }

    public State findState(Long id) {
        Optional<State> optionalState = stateRepository.findById(id);
        if (optionalState.isPresent()) {
            return optionalState.get();
        } else {
            return null;
        }
    }
}
