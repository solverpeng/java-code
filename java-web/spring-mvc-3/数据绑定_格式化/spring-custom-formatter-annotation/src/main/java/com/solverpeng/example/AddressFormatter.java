package com.solverpeng.example;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class AddressFormatter implements Formatter<Address> {
    private Style style = Style.FULL;

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public Address parse(String text, Locale locale) throws ParseException {
        if (text != null) {
            String[] parts = text.split(",");
            if (style == Style.FULL && parts.length == 4) {
                Address address = new Address();
                address.setStreet(parts[0].trim());
                address.setCity(parts[1].trim());
                address.setZipCode(parts[2].trim());
                address.setCounty(parts[3].trim());
                return address;
            } else if(style == Style.REGION && parts.length == 3) {
                Address address = new Address();
                address.setCity(parts[0].trim());
                address.setZipCode(parts[1].trim());
                address.setCounty(parts[2].trim());
                return address;
            }
        }
        return null;
    }

    @Override
    public String print(Address address, Locale locale) {
        if (address == null) {
            return "";
        }
        switch (style) {
            case FULL:
                return String.format(locale, "%s, %s, %s, %s", address.getStreet(), address.getCity(),
                        address.getZipCode(), address.getCounty());
            case REGION:
                return String.format(locale, "%s, %s, %s", address.getCity(), address.getZipCode(), address.getCounty());
        }
        return address.toString();
    }

    public enum Style{
        FULL,
        REGION
    }
}
