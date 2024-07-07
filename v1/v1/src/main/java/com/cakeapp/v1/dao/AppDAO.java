package com.cakeapp.v1.dao;

import com.cakeapp.v1.entity.Cake;
import com.cakeapp.v1.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppDAO {

    void save(Cake cake);

    Cake findCakeById(int id);

    Ingredient findIngredientById(int id);

    List<Ingredient> findIngredientsByCakeId(int id);

    Cake findCakeWithIngredientsByJoinFetch(int id);
}
