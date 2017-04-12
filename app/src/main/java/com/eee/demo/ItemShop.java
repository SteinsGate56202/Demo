package com.eee.demo;

import java.io.Serializable;

/**
 * Created by li124 on 2017/3/20.
 */

public class ItemShop implements Serializable {
    private String Name;
    private int health;
    private int power;
    private int sen;

    public ItemShop(String name, int health, int power, int sen) {
        Name = name;
        this.health = health;
        this.power = power;
        this.sen = sen;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSen() {
        return sen;
    }

    public void setSen(int sen) {
        this.sen = sen;
    }
}
