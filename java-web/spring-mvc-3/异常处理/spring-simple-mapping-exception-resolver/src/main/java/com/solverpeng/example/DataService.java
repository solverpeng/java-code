package com.solverpeng.example;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DataService {
    private Map<String, Object> testData = new HashMap<>();
    private Map<Integer, String> testOrders = new HashMap<>();

    public DataService () {
        testData.put("1", "this is test data");
        testOrders.put(1, "Order 1");
        testOrders.put(2, "Order 2");
    }

    public String getData (String id) {
        //we purposely created NPE scenario for demo
        //only id=1 will return test data
        return testData.get(id).toString();
    }

    public String getOrderDetail (String orderId) {
        try {
            int i = Integer.parseInt(orderId);
            String s = testOrders.get(i);
            return s == null ? "Empty Order" : s;
        } catch (NumberFormatException e) {
            throw new OrderIdNotValidException(
                    "Order id is not valid: " + orderId);
        }
    }
}
