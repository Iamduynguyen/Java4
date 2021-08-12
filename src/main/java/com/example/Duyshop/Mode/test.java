package com.example.Duyshop.Mode;

import com.example.Duyshop.Dao.DaoCustomer;
import com.example.Duyshop.Dao.DaoFavourite;

public class test {
    public static void main(String[] args) {
        ProductCustomer x = new DaoFavourite().Findlikebycustomer(1,13);
        System.out.println("day"+x.getProduct().getName());
    }
}
