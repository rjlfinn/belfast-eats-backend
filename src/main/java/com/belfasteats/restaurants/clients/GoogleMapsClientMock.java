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
    public Long distanceBetweenTwoGeoCodes(Geocode geocodeOne, Geocode geocodeTwo) {
        return (long) (Math.random() * 10);
    }

    /*
     * Fake converting postcode to Geocode
     */
    public Geocode getGeocodeFromPostcode(String postCode) {
        return Geocode.builder()
                      .latitude((long) (Math.random() * 10))
                      .longitude((long) (Math.random() * 10))
                      .build();
    }
}
