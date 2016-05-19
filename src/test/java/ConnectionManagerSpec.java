import org.junit.Assert;
import org.junit.Test;

/**
 * Created by manjushadas on 5/19/16.
 */
public class ConnectionManagerSpec {
    @Test
    public void makeConnectionTest(){
      ConnectionManager connectionManager= new ConnectionManager(1);
        Connection connection=connectionManager.makeConnection("192.168.1",8080,"HTTP");
        Connection connection2=connectionManager.makeConnection("192.168.1",8080,"HTTP");
        Assert.assertNull(connection2);
    }
    @Test
    public void getIPTest(){
        ConnectionManager connectionManager = new ConnectionManager(1);
        Connection connection=connectionManager.makeConnection("192.168.1",8080,"HTTP");
        String expected="192.168.1";
        String actual=connection.getIP();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getPortTest(){
        ConnectionManager connectionManager = new ConnectionManager(1);
        Connection connection=connectionManager.makeConnection("192.168.1",8080,"HTTP");
        int expected=8080;
        int actual=connection.getPort();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getProtocolTest(){
        ConnectionManager connectionManager = new ConnectionManager(1);
        Connection connection=connectionManager.makeConnection("192.168.1",8080,"HTTP");
        String expected="HTTP";
        String actual=connection.getProtocol();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getIPTestClosed(){
        ConnectionManager connectionManager = new ConnectionManager(1);
        Connection connection=connectionManager.makeConnection("192.168.1",8080,"HTTP");
        connection.close();
        String expected="This connection is closed!";
        String actual=connection.getIP();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getPortTestClosed(){
        ConnectionManager connectionManager = new ConnectionManager(1);
        Connection connection=connectionManager.makeConnection("192.168.1",8080,"HTTP");
        connection.close();
        int expected=0;
        int actual=connection.getPort();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getProtocolTestClosed(){
        ConnectionManager connectionManager = new ConnectionManager(1);
        Connection connection=connectionManager.makeConnection("192.168.1",8080,"HTTP");
        connection.close();
        String expected="This connection is closed!";
        String actual=connection.getProtocol();
        Assert.assertEquals(expected,actual);
    }

}
