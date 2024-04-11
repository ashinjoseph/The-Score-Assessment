package org.the.score.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class RandomIdGenerator {
    public static final Integer MAX_LENGTH = 6;

    public static String generateNumeric(){
        return RandomStringUtils.randomNumeric(MAX_LENGTH);
    }

    public static String generateAlphabetic(){
        return RandomStringUtils.randomAlphabetic(MAX_LENGTH).toUpperCase(Locale.ROOT);
    }

    public static String generateAlphanumeric(){
        return RandomStringUtils.randomAlphanumeric(MAX_LENGTH).toUpperCase(Locale.ROOT);
    }
}
