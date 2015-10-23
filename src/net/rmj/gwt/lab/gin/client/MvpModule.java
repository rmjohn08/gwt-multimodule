package net.rmj.gwt.lab.gin.client;

import net.rmj.gwt.lab.gin.client.home.HomeView;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class MvpModule extends AbstractGinModule {

	@Override
	protected void configure() {
		// application bus
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		
		bind(PlaceController.class).toProvider(PlaceProvider.class).in(Singleton.class);
		//bind(ClientFactory.class).toProvider(ClientFactoryImpl.class).in(Singleton.class);
		
		//  something else 
		// ....
		bind(SiteShell.class).to(SiteLayout.class).in(Singleton.class);
		
		
	}
	
	static class PlaceProvider implements Provider<PlaceController> {
		@Inject 
		EventBus bus;
		
		@Override
		public PlaceController get() {
			return new PlaceController(this.bus);
			
		}
	}

}
