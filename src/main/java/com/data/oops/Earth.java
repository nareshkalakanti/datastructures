package com.data.oops;

public class Earth {

    public static void main(String[] args) {

        Human human1 = new Human("Tom",25,36,"Blue");
        Human human2 = new Human("Joe",26,37,"Green");
        Human human3 = new Human("Jane",27,38,"Black");

        human1.speak();
        human2.speak();
        human3.speak();

    }
}
