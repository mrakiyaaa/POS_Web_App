package com.example.pos_demo.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.google.gson.Gson; // Ensure this import is present
import java.util.ArrayList;

@Converter(autoApply = true)
public class JsonConverter implements AttributeConverter <ArrayList, String> {

    private final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(ArrayList attribute) {
        return gson.toJson(attribute); // Converts ArrayList to JSON string
    }

    @Override
    public ArrayList convertToEntityAttribute(String dbData) {
        return gson.fromJson(dbData, ArrayList.class); // Converts JSON string back to ArrayList
    }

}
