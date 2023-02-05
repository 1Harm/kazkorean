package com.kaz.kazkoreanapp.model;

import androidx.annotation.NonNull;

import com.kaz.kazkoreanapp.R;

import java.util.ArrayList;

public class ItemData {
    public static ArrayList<Item> orders = new ArrayList<>();

    @NonNull
    public static ArrayList<Item> getListPerfume() {
        ArrayList<Item> drinks = new ArrayList<>();
        drinks.add(new Item("Perfume", 400, R.drawable.perfume1));
        drinks.add(new Item("Perfume", 800, R.drawable.p2));
        drinks.add(new Item("Perfume", 900, R.drawable.p3));
        drinks.add(new Item("Perfume", 700, R.drawable.p4));
        drinks.add(new Item("Perfume", 800, R.drawable.p5));
        drinks.add(new Item("Perfume", 700, R.drawable.p6));
        drinks.add(new Item("Perfume", 100, R.drawable.p7));
        drinks.add(new Item("Air Perfume", 800, R.drawable.p8));
        return drinks;
    }

    @NonNull
    public static ArrayList<Item> getListLipsticks() {
        ArrayList<Item> lip = new ArrayList<>();
        lip.add(new Item("Lipsticks", 45, R.drawable.l1));
        lip.add(new Item("Lipsticks", 30, R.drawable.l2));
        lip.add(new Item("Lipsticks", 28, R.drawable.l3));
        lip.add(new Item("Lipsticks", 25, R.drawable.l4));
        return lip;
    }

    @NonNull
    public static ArrayList<Item> getListCream() {
        ArrayList<Item> cream = new ArrayList<>();
        cream.add(new Item("Hand cream", 30, R.drawable.cream2));
        cream.add(new Item("Dreams", 40, R.drawable.cream3));
        cream.add(new Item("Face cream", 70, R.drawable.cream4));
        cream.add(new Item("Cream", 50, R.drawable.cream5));
        return cream;
    }

    @NonNull
    public static ArrayList<Item> getListOrder() {
        return orders;
    }

}
