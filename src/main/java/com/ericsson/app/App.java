package com.ericsson.app;

import java.io.Closeable;
import java.net.URI;
import java.util.Scanner;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.ResourceConfig;
//import org.glassfish.grizzly.http.server.GrizzlyHttpServerFactory;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ServerProperties;
/**
 * Hello world!
 *
 */
public class App 
{        
    public static void main( String[] args ) throws Exception
    {
	final ResourceConfig config = new ResourceConfig();

	URI baseUri = UriBuilder.fromUri("http://localhost/").port(8181).build();
	HttpServer grizzlyServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
	grizzlyServer.start();

        System.out.println( "Press Enter to stop..." );
	new Scanner(System.in).nextLine();

	System.exit(0);
    }
}
