package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private final String NAME = "disconnected";

    public String getName() {
        return NAME;
    }

    @Override
    public String write(String data) {
        return "error";
    }

    @Override
    public void connect(TcpConnection context) {
        context.setCurrentState(new Connected());
    }

    @Override
    public void disconnect(TcpConnection context) {
        System.out.println("Error! Connection already connected");
    }
}
// END
