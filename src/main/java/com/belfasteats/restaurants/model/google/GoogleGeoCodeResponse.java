package com.belfasteats.restaurants.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleGeoCodeResponse {

    @JsonProperty("results")
    @Getter
    @Setter
    private List<Results> results;

    @JsonProperty("status")
    @Getter
    @Setter
    private String status;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Results {
        @JsonProperty("geometry")
        @Getter
        @Setter
        public Geometry geometry;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geometry {
        @JsonProperty("location")
        @Getter
        @Setter
        private Location location;
    }

    public static class Location {
        @JsonProperty("lat")
        @Getter
        @Setter
        private Double latitude;

        @JsonProperty("lng")
        @Getter
        @Setter
        private Double longitude;
    }
}
