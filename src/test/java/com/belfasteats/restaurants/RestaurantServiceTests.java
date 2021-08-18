package com.belfasteats.restaurants;

import com.belfasteats.restaurants.clients.GoogleMapsClientMock;
import com.belfasteats.restaurants.dao.RestaurantsDao;
import com.belfasteats.restaurants.model.Geocode;
import com.belfasteats.restaurants.model.entities.Restaurant;
import com.belfasteats.restaurants.service.RestaurantsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestaurantServiceTests {

    private static RestaurantsService restaurantsService;

    private static RestaurantsDao restaurantsDao;
    private static GoogleMapsClientMock googleMapsClientMock;

    @BeforeAll
    public static void setup() {
        restaurantsDao = Mockito.mock(RestaurantsDao.class);
        googleMapsClientMock = Mockito.mock(GoogleMapsClientMock.class);
        restaurantsService = new RestaurantsService(restaurantsDao, googleMapsClientMock);
    }

    @Test
    public void shouldReturnAllRestaurants() {
        // given
        Restaurant restaurantOne = Restaurant.builder().name("1").latitude(1L).longitude(1L).build();
        Restaurant restaurantTwo = Restaurant.builder().name("1").latitude(2L).longitude(2L).build();
        when(restaurantsDao.findAll()).thenReturn(List.of(restaurantOne, restaurantTwo));

        Geocode postcodeGeocode = Geocode.builder().latitude(1L).longitude(1L).build();
        when(googleMapsClientMock.getGeocodeFromPostcode(anyString())).thenReturn(postcodeGeocode);
        when(googleMapsClientMock.distanceBetweenTwoGeoCodes(any(), any())).thenReturn(3L);

        // when
        List<Restaurant> restaurants = restaurantsService.getRestaurantsInPostcode("test postcode");

        // then
        verify(restaurantsDao, times(1)).findAll();
        verify(googleMapsClientMock, times(2)).distanceBetweenTwoGeoCodes(any(), any());
        assertEquals(2, restaurants.size());
    }
}
