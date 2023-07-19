package com.facundoduarte.pokemon;

public class PokemonTest {
    public static void main(String[] args) {
        Pokemon Lugia = new Pokemon("Lugia", 200, "Psiquico/Volador");
        Pokedex pokedex = new Pokedex();

        Pokemon Groudon = pokedex.createPokemon("Groudon", 200, "Tierra");
        Lugia.attackPokemon(Groudon);
        System.out.println("Vida actual: " + Groudon.getHealth());

        // Listando todos los Pokemones en la Pokedex
        pokedex.createPokemon("Mewtwo", 500, "Psiquico");
        pokedex.createPokemon("Rayquaza", 400, "Dragon/Volador");
        pokedex.createPokemon("Deoxys", 400, "Psiquico");
        pokedex.listPokemon();
    }
}
