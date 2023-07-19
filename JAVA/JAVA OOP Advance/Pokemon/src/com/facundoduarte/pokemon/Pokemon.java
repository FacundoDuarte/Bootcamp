package com.facundoduarte.pokemon;

public class Pokemon {
    private String name;
    private int health;
    private String type;
    private static int count;

    public Pokemon(String name, int health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        count++;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public static int getCount() {
        return count;
    }
    public String displayInfo(){
        return "Nombre: " + this.getName() +
        " - Vida: " + this.getHealth() + 
        " - Tipo: " + this.getType();
    }
    public void attackPokemon(Pokemon pokemon){
        pokemon.health -= 10;
        System.out.println("El pokemon " + pokemon.getName() + " ha perdido 10 puntos de vida... -> Vida actual: " + pokemon.getHealth());
    }
}
