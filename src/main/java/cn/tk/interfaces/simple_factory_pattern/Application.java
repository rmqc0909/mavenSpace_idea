package cn.tk.interfaces.simple_factory_pattern;

import java.sql.*;

/**
 * Created by xiedan11 on 2016/10/12.
 * 简单工厂模式在JDK中最典型的应用要数JDBC了。
 * 可以把关系型数据库认为是一种抽象产品，各厂商提供的具体关系型数据库（MySQL，PostgreSQL，Oracle）则是具体产品。
 * DriverManager是工厂类。
 * 应用程序通过JDBC接口使用关系型数据库时，并不需要关心具体使用的是哪种数据库，而直接使用DriverManager的静态方法去得到该数据库的Connection。
 */
public class Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName ("org.apache.hive.jdbc.HiveDriver");
        connection = DriverManager.getConnection ("jdbc:hive2://127.0.0.1:10000/default");
        PreparedStatement preparedStatement = connection.prepareStatement ("select count(*) from test");
        preparedStatement.execute ();
    }
}
