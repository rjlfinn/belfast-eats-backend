package com.belfasteats.restaurants.dao;

import com.belfasteats.restaurants.model.entities.MenuSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestResource(excerptProjection = MenuSection.class, collectionResourceRel = "menu_sections")
public interface MenuSectionDao extends CrudRepository<MenuSection, Long> {
    List<MenuSection> findByName(@Param("name") String name);
    List<MenuSection> findByRestaurantId(@Param("restaurant_id") Long id);
}