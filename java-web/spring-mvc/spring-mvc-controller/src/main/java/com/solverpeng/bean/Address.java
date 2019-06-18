package com.solverpeng.bean;

import java.util.Objects;

public class Address {
    private String addressName;
    private String email;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressName, address.addressName) &&
                Objects.equals(email, address.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressName, email);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressName='" + addressName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
