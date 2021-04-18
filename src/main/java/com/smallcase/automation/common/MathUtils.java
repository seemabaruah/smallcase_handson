package com.smallcase.automation.common;

public class MathUtils {

    public static Float convertStringToFloat(String value) {
        String filteredValue;
        filteredValue = value.replaceAll("[^\\d+\\.]", "");
        filteredValue = filteredValue.trim();
        return Float.parseFloat(filteredValue);
    }
}
