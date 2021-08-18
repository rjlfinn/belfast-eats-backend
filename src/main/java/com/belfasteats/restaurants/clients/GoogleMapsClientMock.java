package com.belfasteats.restaurants.clients;

import com.belfasteats.restaurants.model.Geocode;
import org.springframework.stereotype.Component;

/*
 * Mock fake Google Map client:
 */
@Component
public class GoogleMapsClientMock {

    public GoogleMapsClientMock() {
    }

    /*
     * Fake returning distance between two geocodes
     */
    public Double distanceBetweenTwoGeoCodes(Geocode geocodeOne, Geocode geocodeTwo) {
        return Math.random() * 10;
    }

    /*
     * Fake converting postcode to Geocode
     */
    public Geocode getGeocodeFromPostcode(String postCode) {
        return Geocode.builder()
                      .latitude(Math.random() * 10)
                      .longitude(Math.random() * 10)
                      .build();
    }
}
