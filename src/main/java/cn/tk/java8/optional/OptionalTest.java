package cn.tk.java8.optional;

import org.junit.Test;

import java.util.Optional;

import static java.lang.System.out;

/**
 * Created by xiedan11 on 2016/11/24.
 */
public class OptionalTest {
    @Test
    public void testOptional() {
        java.util.Optional<String> name = java.util.Optional.of("pig_sun");     //创建对象时传入的参数不能为空
        java.util.Optional<String> nullName = java.util.Optional.ofNullable("puppy");      //创建对象时传入的参数可以为空
        if (nullName.isPresent())
            out.println("name: " + nullName.get());     //如果Optional中有值则将其返回，否则抛出NoSuchElementException异常
        else
            out.println("name default: " + nullName.orElse("default"));     //如果有值则将其返回，否则返回指定的其他值
        out.println("name orElseGet:" + nullName.orElseGet(() -> "Default value"));

        java.util.Optional<String> empty = java.util.Optional.empty();

        out.println("empty :" + empty.orElseGet(() -> "Default empty value"));
        try {
            empty.orElseThrow(ValueAbsentException::new);   //在orElseThrow中我们可以传入一个lambda表达式或方法，如果值不存在来抛出异常
        } catch (ValueAbsentException e) {
            e.printStackTrace();
        }
        java.util.Optional<String> upperName = name.map((val) -> val.toUpperCase());      //如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional
        out.println(upperName.orElse("No upperCase value found!"));

        java.util.Optional<String> lowerName = upperName.flatMap((val) -> java.util.Optional.of(val.toLowerCase()));
        out.println(lowerName.orElse("No lowerCase value found!"));      //flatMap方法与map方法类似，区别在于mapping函数的返回值不同。map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional
    }


    @Test
    public void testMap() {
        Insurance insurance = new Insurance();
        insurance.setName("tianping!");
        Optional<Insurance> insuranceOptional = Optional.ofNullable(insurance);
        Optional<String> name = insuranceOptional.map(Insurance :: getName);
        out.println("Insurance name: " + name);
    }

    @Test
    public void testFlatMap() {
        Person person = new Person();
        Optional<Person> personOptional = Optional.of(person);
        String name = personOptional.flatMap(Person :: getCar)
                .flatMap(Car :: getInsurance)
                .map(Insurance :: getName)
                .orElse("unknown");
        out.println("name: " + name);
    }

}


class ValueAbsentException extends Throwable {
    public ValueAbsentException() {
        super();
    }

    public ValueAbsentException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "No value present in the OptionalTest instance";
    }
}
