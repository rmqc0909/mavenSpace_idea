package cn.tk.access_control;

/**Think in Java Chapter vi - 8th   Page 123
 * Created by xiedan11 on 2016/9/12.
 */
class Connection {
    private Connection() {}
    public static Connection makeConnection() {
        return new Connection();
    }
}

public class ConnectionManager {
    private static int counter = 0;
    private static Connection[]  pool = {Connection.makeConnection(), Connection.makeConnection(), Connection.makeConnection()};
    public static Connection getConnection() {
        if(counter < pool.length) {
            System.out.println("get connection number: " + (counter + 1));
            return pool[counter++];
        }
        return null;
    }
    public static void main(String args[]) {
        Connection connection1 = ConnectionManager.getConnection();
        Connection connection2 = ConnectionManager.getConnection();
        Connection connection3 = ConnectionManager.getConnection();
        Connection connection4 = ConnectionManager.getConnection();
        System.out.println("connection1: " + connection1 + "|connection2: " + connection2 + "|connection3: " + connection3 + "|connection4: " + connection4);
    }
}
