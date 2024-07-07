package com.cakeapp.v1.dao;

import com.cakeapp.v1.App;
import com.cakeapp.v1.entity.Cake;
import com.cakeapp.v1.entity.Ingredient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Cake cake) {
        entityManager.persist(cake);
    }

    @Override
    public Cake findCakeById(int id) {
        Cake foundCake = entityManager.find(Cake.class, id);
        return foundCake;
    }

    @Override
    public Ingredient findIngredientById(int id) {
        Ingredient foundCake = entityManager.find(Ingredient.class, id);
        return foundCake;
    }

    @Override
    public List<Ingredient> findIngredientsByCakeId(int id) {
        TypedQuery<Ingredient> query = entityManager.createQuery("" +
                "from Ingredient where cake.id = :data", Ingredient.class);
        query.setParameter("data", id);
        List<Ingredient> ingredients = query.getResultList();
        return ingredients;
    }

    @Override
    public Cake findCakeWithIngredientsByJoinFetch(int id) {
        TypedQuery<Cake> query = entityManager.createQuery("select c from Cake c " +
                                                                "JOIN FETCH c.ingredients " +
                                                                "where c.id = :data", Cake.class);
        query.setParameter("data", id);
        Cake cake = query.getSingleResult();
        return cake;
    }
}
