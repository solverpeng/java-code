package com.solverpeng.example;

import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/");
        URLConnection connection = url.openConnection();
        try (ObjectInputStream inputStream = new ObjectInputStream(connection.getInputStream())) {
            Object o = inputStream.readObject();
            Map<String, BigInteger> map = (Map<String, BigInteger>) o;
            map.forEach((k, v) -> System.out.println(k + " = " + v));
        }
    }
}
