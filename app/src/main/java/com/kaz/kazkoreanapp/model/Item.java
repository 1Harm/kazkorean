package com.kaz.kazkoreanapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.kaz.kazkoreanapp.R;

public class Item implements Parcelable {
    private String name;
    private int price, img;

    public Item(String name, int price, int img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    protected Item(Parcel in) {
        name = in.readString();
        price = in.readInt();
        img = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public static final Item[] orderItems = {
            new Item("Sirloin Steak", 45000, R.drawable.sirloin),
            new Item("Donut", 15000, R.drawable.donut),
            new Item("Strawberry Juice", 10000, R.drawable.straw),
            new Item("Soto Ayam", 25000, R.drawable.soto),
            new Item("Grape Juice", 8000, R.drawable.grape),
            new Item("Mineral Water", 4000, R.drawable.mineral),
            new Item("Mango Juice", 8000, R.drawable.mango),
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeInt(img);
    }
}
