package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection {
    private Connection state = new Disconnected();
    StringBuffer buffer = new StringBuffer();
    private String ip;
    private int port;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getCurrentState() {
        return state.getName();
    }

    public void setCurrentState(Connection state) {
        this.state = state;
    }

    public void connect() {
        state.connect(this);
    }

    public void disconnect() {
        state.disconnect(this);
    }

    public void write(String data) {
        if (state.write(data).equals("error")) {
            System.out.println("Error! There is no established connection");
            return;
        }
        if (!buffer.isEmpty()) {
            buffer.delete(0, buffer.length());
        }
        buffer.append(data);
    }
}
// END
