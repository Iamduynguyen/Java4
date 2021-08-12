package com.example.Duyshop;

import com.example.Duyshop.Dao.DaoTransaction;

public class Test {
    public static void main(String[] args) {
        System.out.println(new DaoTransaction().findall().get(0).toString());
    }
}
