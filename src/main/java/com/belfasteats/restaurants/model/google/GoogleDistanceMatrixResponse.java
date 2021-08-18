package com.belfasteats.restaurants.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GoogleDistanceMatrixResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("rows")
    private List<Row> rows;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Row {
        @JsonProperty("elements")
        private List<Element> elements;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Element {
        @JsonProperty("distance")
        public Distance distance;

        @JsonProperty("duration")
        public Duration duration;
    }

    public static class Distance {
       @JsonProperty("text")
       public String distance;

        @JsonProperty("value")
        public double distanceValue;
    }

    public static class Duration {
        @JsonProperty("text")
        public String duration;

        @JsonProperty("value")
        public double durationValue;
    }
}
