package cn.tk.java8.optional;

import java.util.Optional;

/**
 * Created by xiedan on 2016/11/27.
 */
public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}

class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name;

    public String getName() {
        return name;
    }
}
