import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class Main extends Application<Configuration> {

    @Override
    public String getName() { return "hello-world"; }

    @Override
    public void run(Configuration o, Environment environment) {
        BookResource resource = new BookResource();
        environment.jersey().register(resource);
    }

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

}
