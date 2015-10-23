package net.rmj.gwt.lab.gin.client.menu;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MainMenuActivity { /* 
//extends AbstractActivity
	implements MainMenuPresenter {
	
	PlaceController placeController;
	MainMenuView view;
	
	final Logger logger = Logger.getLogger("MenuActivity");
	
	@Inject
	public MainMenuActivity(Provider<ClientFactory> clientFactoryProvider) {
		this.placeController = clientFactory.getPlaceController();
		view = clientFactory.getMainMenuView();
		logger.info("instantiated menuactivity....");
		
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		panel.setWidget(view);
		view.setPresenter(this);
		logger.info("started menuactivity....");
		
	}

	@Override
	public void goHome() {
		// TODO Auto-generated method stub
		placeController.goTo(new HomePlace());
		
	}

	@Override
	public void goTeam() {
		placeController.goTo(new TeamPlace());
		
	}

	@Override
	public void goLeague() {
		placeController.goTo(new LeaguePlace());
	}
*/
}
