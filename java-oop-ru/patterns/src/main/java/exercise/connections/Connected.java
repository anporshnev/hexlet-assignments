package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private final String NAME = "connected";

    public String getName() {
        return NAME;
    }

    @Override
    public String write(String data) {
        return data;
    }

    @Override
    public void connect(TcpConnection context) {
        System.out.println("Error! Connection already connected");
    }

    @Override
    public void disconnect(TcpConnection context) {
        context.setCurrentState(new Disconnected());
    }
}
// END
