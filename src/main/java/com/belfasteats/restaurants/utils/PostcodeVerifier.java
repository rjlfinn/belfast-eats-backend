package com.belfasteats.restaurants.utils;

import org.assertj.core.util.Strings;

public class PostcodeVerifier {
    private static final int POSTCODE_MIN_LENGTH = 6;

    public static Boolean isValidPostcode(String postcode) {
        return !Strings.isNullOrEmpty(postcode) && postcode.length() > POSTCODE_MIN_LENGTH;
    }
}
