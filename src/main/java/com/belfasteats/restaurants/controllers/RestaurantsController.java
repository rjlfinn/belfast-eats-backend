package com.belfasteats.restaurants.controllers;

import com.belfasteats.restaurants.model.entities.Restaurant;
import com.belfasteats.restaurants.service.RestaurantsService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/custom/restaurants")
public class RestaurantsController {

    private final RestaurantsService restaurantsService;

    @Autowired
    public RestaurantsController(RestaurantsService restaurantsService) {
        this.restaurantsService = restaurantsService;
    }

    @GetMapping("/{postcode}")
    @ApiResponse(description = "Operation Success", responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Restaurant.class))))
    @ApiResponse(description = "Bad parameter", responseCode = "400")
    public List<Restaurant> getRestaurantsInPostcode(@PathVariable String postcode) {
        return restaurantsService.getRestaurantsInPostcode(postcode);
    }
}
