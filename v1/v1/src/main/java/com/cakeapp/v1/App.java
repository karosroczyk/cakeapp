package com.cakeapp.v1;

import com.cakeapp.v1.dao.AppDAO;
import com.cakeapp.v1.entity.Cake;
import com.cakeapp.v1.entity.Ingredient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner -> {
            //createCakeWithIngredients(appDAO);
            //findCakeWithIngredients(appDAO);
            //findIngredientsByCake(appDAO);
            findCakeWithIngredientsByJoinFetch(appDAO);
        };
    }

    private void findCakeWithIngredientsByJoinFetch(AppDAO appDAO) {
        int id = 3;
        Cake foundCake = appDAO.findCakeWithIngredientsByJoinFetch(id);
        System.out.println("Found cake with ingredients: " + foundCake + " Ingredients: " + foundCake.getIngredients());
    }

    private void findIngredientsByCake(AppDAO appDAO) {
        int id = 1;
        Cake foundCake = appDAO.findCakeById(id);
        System.out.println("Found cake: " + foundCake);

        List<Ingredient> ingredients = appDAO.findIngredientsByCakeId(id);
        foundCake.setIngredients(ingredients);
        System.out.println("Ingredients found: " + foundCake.getIngredients());
    }

    private void findCakeWithIngredients(AppDAO appDAO) {
        int id = 1;
        Cake foundCake = appDAO.findCakeById(id);
        System.out.printf("Found cake: " + foundCake);
    }

    private void createCakeWithIngredients(AppDAO appDAO) {
        Ingredient i1 = new Ingredient("jablka", "5 sztuk");
        Ingredient i2 = new Ingredient("maka", "100 g");

        Cake cake = new Cake("szarlotka");
        cake.addIngredient(i1);
        cake.addIngredient(i2);

        System.out.println("Saving to database");
        appDAO.save(cake);
        System.out.println("Saving cake: " + cake);
    }

}
