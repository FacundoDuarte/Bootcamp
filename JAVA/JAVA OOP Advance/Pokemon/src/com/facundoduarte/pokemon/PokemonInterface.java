package com.facundoduarte.pokemon;

public interface PokemonInterface {
        Pokemon creatPokemon(String name, int health, String type);
        String pokemonInfo(Pokemon pokemon);
        void listPokemon();
 }
