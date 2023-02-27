package core.ics.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@Getter
@SuperBuilder
public class ConnectionTest implements Serializable {

    private InetAddress netAddress;
    private String createAt;

    public static ConnectionTest test() throws UnknownHostException {
        return ConnectionTest
                .builder()
                .netAddress(InetAddress.getLocalHost())
                .createAt(new Date().toString())
                .build();
    }
}
