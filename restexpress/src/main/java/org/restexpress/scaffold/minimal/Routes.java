package org.restexpress.scaffold.minimal;

import org.jboss.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;
import org.restexpress.scaffold.minimal.config.Configuration;

public abstract class Routes
{
	public static void define(Configuration config, RestExpress server)
    {
		//TODO: Your routes here...
		server.uri("/json", config.getSampleController())
            .action("json", HttpMethod.GET)
			.method(HttpMethod.GET)
			.name("sample.json.route")
            .defaultFormat("application/json");

		server.uri("/text", config.getSampleController())
			.action("text", HttpMethod.GET)
			.method(HttpMethod.GET)
			.name("sample.text.route")
            .noSerialization();
// or...
//		server.regex("/some.regex", config.getRouteController());
    }
}
