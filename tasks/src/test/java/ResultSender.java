import org.aeonbits.owner.ConfigFactory;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class ResultSender {

    private static ServerConfig config = ConfigFactory.create(ServerConfig.class);
    private static final InfluxDB INFLXUDB;
    private static final String DATABASE = "selenium";

    static {
        INFLXUDB = InfluxDBFactory.connect(config.url() + ":" + config.port(),
                config.username(), config.password());
        INFLXUDB.setDatabase(DATABASE);
    }

    static void send(final Point point) {
        INFLXUDB.write(point);
    }

}