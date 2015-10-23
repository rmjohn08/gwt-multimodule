package net.rmj.gwt.lab.gin.client;

import net.rmj.gwt.lab.shared.service.GreetingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

@GinModules({MvpModule.class})
public interface MvpGinjector extends Ginjector {

	MvpGinjector INSTANCE = GWT.create(MvpGinjector.class);
	
	AppStarter getAppStarter();
	
	public EventBus getEventBus();
	
	public PlaceController getPlaceController();
	
	public GreetingServiceAsync getGreetingService();
	
	

}
