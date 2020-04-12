import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {

   @Key(value="influxdb.url")
    String url();

    @Key(value="influxdb.port")
    int port();

    @Key(value="influxdb.username")
    String username();

    @Key(value="influxdb.password")
    String password();

    @Key(value = "tested-resource-url")
    String testedResourceUrl();



}
