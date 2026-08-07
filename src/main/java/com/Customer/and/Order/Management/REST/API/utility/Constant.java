package com.Customer.and.Order.Management.REST.API.utility;


public class Constant {

    public enum UserStatus {
        PENDING("pending"),
        DELIVERED("delivered"),
        ORDERED("ordered");

        public final String values;

        UserStatus(String values) {
            this.values = values;
        }
    }
}