
package com.heran.launcher2.weather;

public class WeatherLife {

    public String city; // 城市

    public String city_color;

    public String clothes; // 穿衣

    public String clothes_color;

    public String car; // 行車

    public String car_color;

    public String outdoor; // 戶外

    public String outdoor_color;

    public String clothesline; // 曬衣

    public String clothesline_color;

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public void setClothes_color(String clothes_color) {
        this.clothes_color = clothes_color;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public void setOutdoor(String outdoor) {
        this.outdoor = outdoor;
    }

    public void setOutdoor_color(String outdoor_color) {
        this.outdoor_color = outdoor_color;
    }

    public void setClothesline(String clothesline) {
        this.clothesline = clothesline;
    }

    public void setClothesline_color(String clothesline_color) {
        this.clothesline_color = clothesline_color;
    }

    @Override
    public String toString() {
        return "----city:" + city + " city_color:" + city_color + "----clothes:" + clothes + " clothes_color"
                + clothes_color + "----car" + car + " car_color" + car_color + "----outdoor:" + outdoor
                + " outdoor_color:" + outdoor_color + "----clothesline:" + clothesline + " clothesline_color:"
                + clothesline_color;
    }

}