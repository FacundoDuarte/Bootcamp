package com.facundoduarte.pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPokemon implements PokemonInterface{
    protected List<Pokemon> myPokemons;

    public AbstractPokemon() {
        myPokemons = new ArrayList<>();
    }
    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon newPokemon = new Pokemon(name, health, type);
        myPokemons.add(newPokemon);
        return newPokemon;
    }
    public String pokemonInfo(Pokemon pokemon) {
        return "Name: " + pokemon.getName() + ", Health: " + pokemon.getHealth() + ", Type: " + pokemon.getType();
    }



}
