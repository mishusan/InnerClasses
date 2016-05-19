/**
 * Created by manjushadas on 5/19/16.
 */
public class ConnectionManager {
        int maxConnections;
        int currentConnections=0;

        public ConnectionManager(int maxConnections){
            this.maxConnections=maxConnections;
        }
    public ManagedConnection makeConnection(String ip, int port, String protocol){
        if (currentConnections<maxConnections && protocol.equals("HTTP")&& protocol.equals("HTTPS")&& protocol.equals("SSH")){
            currentConnections++;
            return new ManagedConnection(ip, port, protocol);
        }
        return null;
    }
    public ManagedConnection makeConnection(String ip, int port){
        if (currentConnections<maxConnections) {
            currentConnections++;
            return new ManagedConnection(ip, port, "HTTP");
        }
        return null;
    }
    public ManagedConnection makeConnection(String ip, String protocol){
        if (currentConnections<maxConnections && protocol.equals("HTTP")&& protocol.equals("HTTPS")&& protocol.equals("SSH")) {
            currentConnections++;
            return new ManagedConnection(ip, 8080, protocol);
        }
        return null;
    }

    private class ManagedConnection implements Connection {
        public ManagedConnection(String IP, int port, String protocol){
            this.iP=IP;
            this.port=port;
            this.protocol=protocol;

        }
        private String iP;
        private int port;
        private String protocol;
        boolean closeConnection=false;

        public String getIP() {
            if (closeConnection){
                return "This connection is closed!";
            }


            return iP;
        }

        public int getPort() {
            if (closeConnection){
                return 0;}
            return port;
        }

        public String getProtocol() {
            if (closeConnection){
                return "This connection is closed!";}
            return protocol;
        }

        public String connect() {
            return "Connection Made!";
        }
        public String close(){
            currentConnections--;
            closeConnection=true;
            return "Connection Closed!";
        }
    }
}
