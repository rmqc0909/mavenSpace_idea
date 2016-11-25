package cn.tk.guava;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Set;

/**
 * Created by xiedan11 on 2016/11/24.
 */
public class GuavaOptional {


    /**
     * 1.Optional.of(T)：获得一个Optional对象，其内部包含了一个非null的T数据类型实例，若T=null，则立刻报错。
     * 2.Optional.absent()：获得一个Optional对象，其内部包含了空值。
     * 3.Optional.fromNullable(T)：将一个T的实例转换为Optional对象，T的实例可以不为空，也可以为空，Optional.fromNullable(null)，和Optional.absent()等价。
     * @throws Exception
     */
    @Test
    public void testOptional() throws Exception {
        Optional<Integer> possible = Optional.of(6);
        Optional<Integer> possibleNull = Optional.of(null);     //运行时报空指针。
        Optional<Integer> absentOpt = Optional.absent();
        Optional<Integer> NullableOpt = Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt = Optional.fromNullable(10);
        if(possible.isPresent()){
            System.out.println("possible isPresent:" + possible.isPresent());
            System.out.println("possible value:" + possible.get());
        }
        if(absentOpt.isPresent()){
            System.out.println("absentOpt isPresent:" + absentOpt.isPresent()); ;
        }
        if(NullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:" + NullableOpt.isPresent()); ;
        }
        if(NoNullableOpt.isPresent()){
            System.out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent()); ;
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
            System.out.println("获得返回值: " + value.get());
        }else{
            Set<Long> set = value.asSet();
            System.out.println("获得null返回值 set 的 size : " + set.size());
            //System.out.println("获得返回值: " + value.get());
            System.out.println("获得返回值: " + value.or(-12L));
            //System.out.println("获得null返回值: " + value.get());    抛出IllegalStateException异常
        }
        System.out.println("获得返回值 orNull: " + value.orNull());
        Optional<Long> valueNoNull = methodNoNull();
        if(valueNoNull.isPresent() == true){
            Set<Long> set = valueNoNull.asSet();
            System.out.println("获得返回值 set 的 size : " + set.size());
            System.out.println("获得返回值: " + valueNoNull.get());
        }else{
            System.out.println("获得返回值: " + valueNoNull.or(-12L));
        }
        System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
    }

    private Optional<Long> method() {
        return Optional.fromNullable(null);
    }
    private Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }

}
