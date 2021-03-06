package org.restexpress.scaffold.minimal;

import org.restexpress.RestExpress;
import org.restexpress.scaffold.minimal.config.Configuration;
import org.restexpress.scaffold.minimal.serialization.SerializationProvider;
import org.restexpress.util.Environment;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main
{
	private static final String SERVICE_NAME = "restexpress benchmark";

	public static void main(String[] args) throws Exception
	{
		RestExpress server = initializeServer(args);
		server.awaitShutdown();
	}

	public static RestExpress initializeServer(String[] args) throws IOException
	{
		RestExpress.setSerializationProvider(new SerializationProvider());

		Configuration config = loadEnvironment(args);
		RestExpress server = new RestExpress()
				.setName(SERVICE_NAME)
				.setBaseUrl(config.getBaseUrl())
				.setExecutorThreadCount(config.getExecutorThreadPoolSize());

		Routes.define(config, server);

		server.bind(config.getPort());
		return server;
    }

    private static Configuration loadEnvironment(String[] args)
    throws FileNotFoundException, IOException
    {
	    if (args.length > 0)
		{
			return Environment.from(args[0], Configuration.class);
		}

	    return Environment.fromDefault(Configuration.class);
    }
}
