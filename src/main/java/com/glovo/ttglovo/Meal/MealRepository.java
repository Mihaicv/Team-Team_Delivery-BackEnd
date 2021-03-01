package com.glovo.ttglovo.Meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<Meal> findById(Long id);

    List<Meal> findAll();


//    Set<Meal> findAllByUser(AppUser user);
}