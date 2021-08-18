package com.belfasteats.restaurants.service;

import com.belfasteats.restaurants.clients.GoogleMapsClientMock;
import com.belfasteats.restaurants.dao.RestaurantsDao;
import com.belfasteats.restaurants.exceptions.InvalidParametersException;
import com.belfasteats.restaurants.model.Geocode;
import com.belfasteats.restaurants.model.entities.Restaurant;
import com.belfasteats.restaurants.utils.PostcodeVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantsService {

    private final RestaurantsDao restaurantsDao;
    private final GoogleMapsClientMock googleMapsClientMock;

    @Autowired
    public RestaurantsService(RestaurantsDao restaurantsDao, GoogleMapsClientMock googleMapsClientMock) {
        this.restaurantsDao = restaurantsDao;
        this.googleMapsClientMock = googleMapsClientMock;
    }

    public List<Restaurant> getRestaurantsInPostcode(@PathVariable String postcode) {
        if (!PostcodeVerifier.isValidPostcode(postcode)) {
            throw new InvalidParametersException();
        }

        Iterable<Restaurant> restaurants = restaurantsDao.findAll();
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurants.forEach(restaurantList::add);

        Geocode postcodeGeocode = googleMapsClientMock.getGeocodeFromPostcode(postcode);

        return restaurantList.stream()
                             .filter(restaurant -> isWithinFiveMiles(restaurant, postcodeGeocode))
                             .collect(Collectors.toList());
    }

    private Boolean isWithinFiveMiles(Restaurant restaurant, Geocode postcodeGeocode) {
        Geocode restaurantGeoCode = Geocode.builder()
                                           .latitude(restaurant.getLatitude())
                                           .longitude(restaurant.getLongitude())
                                           .build();
        return googleMapsClientMock.distanceBetweenTwoGeoCodes(restaurantGeoCode, postcodeGeocode) < 5;
    }
}
