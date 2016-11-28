package cn.tk.java8;

import java.util.Optional;

/**
 * Created by xiedan on 2016/11/27.
 */
public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}




