package cn.tk.java8;

import java.util.Optional;

/**
 * Created by xiedan on 2016/11/27.
 */
public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
