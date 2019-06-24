package com.solverpeng.config;

import com.solverpeng.bean.Location;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class LocationFormatter implements Formatter<Location> {
    private Style style = Style.FULL;

    public void setStyle (Style style) {
        this.style = style;
    }
    @Override
    public Location parse(String text, Locale locale) throws ParseException {
        if (text != null) {
            String[] parts = text.split(",");
            if (style == Style.FULL && parts.length == 4) {
                Location location = new Location();
                location.setStreet(parts[0].trim());
                location.setCity(parts[1].trim());
                location.setZipCode(parts[2].trim());
                location.setCounty(parts[3].trim());
                return location;
            } else if (style == Style.REGION && parts.length == 3) {
                Location location = new Location();
                location.setCity(parts[0].trim());
                location.setZipCode(parts[1].trim());
                location.setCounty(parts[2].trim());
                return location;
            }
        }
        return null;
    }

    @Override
    public String print(Location location, Locale locale) {
        if (location == null) {
            return "";
        }
        switch (style) {
            case FULL:
                return String.format(locale, "%s, %s, %s, %s", location.getStreet(), location.getCity(),
                        location.getZipCode(), location.getCounty());
            case REGION:
                return String.format(locale, "%s, %s, %s", location.getCity(), location.getZipCode(),
                        location.getCounty());
        }
        return location.toString();
    }


    public enum Style {
        FULL,
        REGION
    }
}
