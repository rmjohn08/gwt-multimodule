package net.rmj.gwt.lab.gin.client;

import javax.inject.Inject;

import net.rmj.gwt.lab.gin.client.home.HomePlace;
import net.rmj.gwt.lab.shared.service.GreetingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class AppStarter {

	
	private GreetingServiceAsync greetingService;
	private PlaceController placeController;
	private EventBus eventBus;
	
	//Logger logger = Logger.getLogger(AppStarter.class);
	
	HomePlace defaultPlace = new HomePlace();
	SiteLayout shell;
	@Inject
	public AppStarter(GreetingServiceAsync service, 
			EventBus eventBus, PlaceController controller,
			SiteLayout shell) {
		this.greetingService = service;
		this.placeController = controller;
		this.eventBus = eventBus;
		this.shell = shell;
		
	}
	
	public void start() {
		
		/*EventBus eb = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		SiteLayout shell = new SiteLayout(clientFactory);
		*/
		
		AppPlacesHistoryMapper historyMapper= GWT.create(AppPlacesHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);
        //(placeController, eb, defaultPlace);
		
		RootLayoutPanel.get().add(shell);
		
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();
        
       // logger.info("started app...");

		
	}
	
	
}
