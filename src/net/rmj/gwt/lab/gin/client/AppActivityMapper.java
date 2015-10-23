package net.rmj.gwt.lab.gin.client;


import javax.inject.Inject;
import javax.inject.Provider;

import net.rmj.gwt.lab.gin.client.home.HomeActivity;
import net.rmj.gwt.lab.gin.client.home.HomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {
	
	Provider homeActivityProvider;
	
	// not gonna work for now 
	// private Map<Class<? extends Place>, Activity> activityMap; 
	
	@Inject
	public AppActivityMapper(Provider<HomeActivity> homeActivityProvider) {
		super();
		this.homeActivityProvider = homeActivityProvider;
		
		//activityMap = new HashMap<Class<? extends Place>, Activity>();
		// activityMap.put(HomePlace.class, new HomeActivity());
		// more activities
		
	}
	

	@Override
	public Activity getActivity(Place place) {
		/* Class<? extends Place> placeClass = place.getClass();
		if (!activityMap.containsKey(placeClass)) {
			throw new RuntimeException("There is no activity mapped for place " + placeClass.getName());
		}
		return activityMap.get(place);
		*/
		Provider<? extends Activity> act = null;
		if (place instanceof HomePlace) {
			act = homeActivityProvider;
			return act.get();
			
		} /* else if (place instanceof LeaguePlace){
			return new LeagueActivity(place, clientFactory);
		} else if(place instanceof TeamPlace) {
			return null; //new TeamActivity(place, clientFactory);
		}*/
		else 
			return null;
	}

}
