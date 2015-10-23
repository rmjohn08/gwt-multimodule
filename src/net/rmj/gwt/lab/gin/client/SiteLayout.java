/**
 * 
 */
package net.rmj.gwt.lab.gin.client;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author ronaldo
 * This is the main site layout. it serves as the skeleton of the site and holds the components
 * that will have contents. 
 */
public class SiteLayout extends Composite implements SiteShell {

	@UiField
	SimplePanel mainPanel;
	
	@UiField
	SimplePanel menuPanel;
	
	//private MainMenuView mainMenu; 
	
	private static SiteLayoutUiBinder uiBinder = GWT
			.create(SiteLayoutUiBinder.class);

	interface SiteLayoutUiBinder extends UiBinder<Widget, SiteLayout> {
	}
	
	private ClientFactory clientFactory;
	private AppActivityMapper activityMapper;
	private EventBus eventBus;

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	@Inject
	public SiteLayout(Provider<ClientFactoryImpl> clientFactoryProvider,
			AppActivityMapper appActivityMapper, EventBus eventBus) {
		this.clientFactory = clientFactoryProvider.get();
		this.activityMapper = appActivityMapper;
		
		initWidget(uiBinder.createAndBindUi(this));
		
		// do activity registration stuff
		/*
		 * this took me a while to understand. some of the 'magic' happens here when registering
		 * creating the menu manager. the eventbus will remember when to trigger a new place change
		 * It is key to pass the section you want to use for the content change.  
		 * */
		//clientFactory.setMenuView(this.mainMenu);
		/*ActivityManager menuActivityManager = new ActivityManager(new MenuActivityMapper(clientFactory), clientFactory.getEventBus());
		menuActivityManager.setDisplay(menuPanel);
		menuPanel.setHeight("50%");
		*/
		ActivityManager mainContentManager = new ActivityManager(activityMapper, eventBus);
		mainContentManager.setDisplay(mainPanel);
		menuPanel.setHeight("50%");
		
	}

	//@UiField
	Button button;

	public SiteLayout(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		//button.setText(firstName);
	}

	//@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		button.setText(text);
	}

	/**
	 * Gets invoked when the default constructor is called
	 * and a string is provided in the ui.xml file.
	 */
	public String getText() {
		return button.getText();
	}

}
