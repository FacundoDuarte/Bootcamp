package com.facundoduarte.pokemon;


public class Pokedex extends AbstractPokemon{
    public Pokedex() {}
    public void listPokemon() {
        System.out.println("Listado de pokemons:");
        for (Pokemon pokemon : myPokemons) {
            System.out.println(pokemon.displayInfo());
        }
    }
	@Override
	public Pokemon creatPokemon(String name, int health, String type) {
		return null;
	}
}
