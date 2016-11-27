package cn.tk.guava;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Set;

import static java.lang.System.out;

/**
 * Created by xiedan11 on 2016/11/24.
 *
 *
 * Guava optional常用的有如下方法：
 * 1) Optional<T>.of(T):为Optional赋值，当T为Null直接抛NullPointException,建议这个方法在调用的时候直接传常量，不要传变量。
 * 2) Optional<T>.fromNullable(T):为Optional赋值，当T为Null则使用默认值。建议与or方法一起用。
 * 3) Optional<T>.absent():为Optional赋值，采用默认值。
 * 4) T or(T):当Optional的值为null时，使用or赋予的值返回。与fromNullable是一对好基友。
 * 5) boolean isPresent():如果Optional存在值，则返回True。
 * 6) T get():当Optional的值为null时，抛出IllegalStateException，返回Optional的值。
 */
public class GuavaOptional {


    /**
     * @throws Exception
     */
    @Test
    public void testOptional() throws Exception {
        Optional<Integer> possible = Optional.of(6);
        //Optional<Integer> possibleNull = Optional.of(null);     //运行时报空指针。
        Optional<Integer> absentOpt = Optional.absent();
        String nullableOpt = (String) Optional.fromNullable(null).or("is null!");
        Optional<Integer> NoNullableOpt = Optional.fromNullable(10);
        if(possible.isPresent()){
            out.println("possible isPresent:" + possible.isPresent());
            out.println("possible value:" + possible.get());
        }
        if(absentOpt.isPresent()){
            out.println("absentOpt isPresent:" + absentOpt.isPresent()); ;
        }
        out.println("nullableOpt:" + nullableOpt);
        if(NoNullableOpt.isPresent()){
            out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent()); ;
        }
    }

    /**
     * 1.boolean isPresent()：如果Optional包含的T实例不为null，则返回true；若T实例为null，返回false.
     * 2.T get()：返回Optional包含的T实例，该T实例必须不为空；否则，对包含null的Optional实例调用get()会抛出一个IllegalStateException异常
     *
     */
    @Test
    public void testMethodReturn() {
        Optional<Long> value = method();
        if(value.isPresent() == true){
            out.println("获得返回值: " + value.get());
        }else{
            Set<Long> set = value.asSet();
            out.println("获得null返回值 set 的 size : " + set.size());
            //System.out.println("获得返回值: " + value.get());
            out.println("获得返回值: " + value.or(-12L));
            //System.out.println("获得null返回值: " + value.get());    抛出IllegalStateException异常
        }
        out.println("获得返回值 orNull: " + value.orNull());
        Optional<Long> valueNoNull = methodNoNull();
        if(valueNoNull.isPresent() == true){
            Set<Long> set = valueNoNull.asSet();
            out.println("获得返回值 set 的 size : " + set.size());
            out.println("获得返回值: " + valueNoNull.get());
        }else{
            out.println("获得返回值: " + valueNoNull.or(-12L));
        }
        out.println("获得返回值 orNull: " + valueNoNull.orNull());
    }

    private Optional<Long> method() {
        return Optional.fromNullable(null);
    }
    private Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }

}
