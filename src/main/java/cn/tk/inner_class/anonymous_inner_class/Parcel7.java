package cn.tk.inner_class.anonymous_inner_class;

import cn.tk.inner_class.member_inner_class.Contents;

/**
 * Created by xiedan11 on 2016/10/14.
 * 匿名内部类:
 * 1.contents方法将返回值的生成与表示这个返回值的类的定义结合在一起。
 * 2.在该内部类中，使用了默认的构造器来生成Contents。
 * 3.将局部内部类的使用在深入一步。假如只创建该类的一个对象，就不用命名，这种类就被称为匿名内部类。
 * 4.由于构造器的名字必须与类名相同，而匿名类没有类名，所以，匿名类不能有构造器。
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents (){
            private int i = 11;
            public int value() { return i; }
        };
    }

    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7 ();
        parcel7.contents ();
    }
}
