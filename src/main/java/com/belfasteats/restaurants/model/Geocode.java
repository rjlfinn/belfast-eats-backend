package com.belfasteats.restaurants.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Geocode {
    private Long longitude;
    private Long latitude;
}
