package com.belfasteats.restaurants.dao;

import com.belfasteats.restaurants.model.entities.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestResource(collectionResourceRel = "restaurants")
public interface RestaurantsDao extends PagingAndSortingRepository<Restaurant, Long> {
    List<Restaurant> findByName(@Param("name") String name);
}
