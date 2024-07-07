package com.cakeapp.v1.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="cake")
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cake", cascade={CascadeType.ALL})
    private List<Ingredient> ingredients;

    public Cake() {
    }

    public Cake(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", name=" + name +
                //", ingredients=" + ingredients +
                '}';
    }

    public void addIngredient(Ingredient ingredient) {
        if(ingredients == null){
            ingredients = new ArrayList<>();
        }
        ingredient.setCake(this);
        ingredients.add(ingredient);
    }
}
