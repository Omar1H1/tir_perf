package fr.maif.tirperf.utils;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonValidator {

    public static boolean isValid (String json) {
        try {
            JsonParser.parseString(json);
        } catch (JsonSyntaxException e) {
            return false;
        }
        return true;
    }
}
