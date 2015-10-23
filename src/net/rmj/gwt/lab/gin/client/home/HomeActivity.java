package net.rmj.gwt.lab.gin.client.home;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HomeActivity extends AbstractActivity {

	HomeView view;
	
	@Inject 
	public HomeActivity(HomeView homeView) {
		view = homeView;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		panel.setWidget(view);
		

	}

}
