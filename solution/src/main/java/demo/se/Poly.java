package demo.se;

import java.util.Arrays;

public class Poly {
    public static void main(String... args) {
        Arrays.asList(
                new Cat(),
                new RedCat(),
                new Dog(),
                new Car()
        ).forEach(HasSound::sound);

        System.out.println("------------------");

        Arrays.asList(
                new Cat(),
                new RedCat(),
                new Dog(),
                new Book()
        ).forEach(nameHolder -> System.out.println(nameHolder.getName()));

        System.out.println("------------------");

        Cat cat = new Cat();
        System.out.println(cat.getName() + " == " + cat.name);

        RedCat redCat = new RedCat();
        System.out.println(redCat.getName() + " == " + redCat.name);

        cat = redCat;
        System.out.println(cat.getName() + " != " + cat.name);

    }
}

interface HasName {
    String getName();
}

interface HasSound {
    void sound();
}

interface Animal extends HasName, HasSound {

}

class Cat implements Animal {

    String name = "Cat";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sound() {
        System.out.println(getName() + " says miau");
    }
}

class RedCat extends Cat {
    String name = "Red Cat";

    @Override
    public String getName() {
        return name;
    }
}

class Dog implements Animal {

    String name = "Dog";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sound() {
        System.out.println(getName() + " says gaw");
    }
}

class Book implements HasName {

    String name = "Some java book";

    @Override
    public String getName() {
        return name;
    }
}

class Car implements HasSound {
    @Override
    public void sound() {
        System.out.println("Car makes beep");
    }
}