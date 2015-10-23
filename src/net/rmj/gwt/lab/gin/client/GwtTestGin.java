package net.rmj.gwt.lab.gin.client;

import net.rmj.gwt.lab.shared.service.GreetingServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtTestGin implements EntryPoint {
	
	MvpGinjector ginjector = GWT.create(MvpGinjector.class);
	private EventBus eventBus;
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private GreetingServiceAsync greetingService=null;
	//= GWT	.create(GreetingService.class);

	
	/**
	 * This iss the entry point method.
	 */
	public void onModuleLoad() {	
		MvpGinjector injector = MvpGinjector.INSTANCE;
		AppStarter starter = injector.getAppStarter();
		starter.start();
	}	
}
