package exercise.connections;

import exercise.TcpConnection;

public interface Connection {
    // BEGIN
    String getName();
    String write(String data);
    void connect(TcpConnection context);
    void disconnect(TcpConnection context);
    // END
}
