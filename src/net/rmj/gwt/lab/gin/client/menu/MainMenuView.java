/**
 * 
 */
package net.rmj.gwt.lab.gin.client.menu;

import org.gwtbootstrap3.client.ui.AnchorListItem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author ronaldo
 *
 */
public class MainMenuView extends Composite {

	MainMenuPresenter presenter;
	
	@UiField
	AnchorListItem homeLink;
	
	@UiField
	AnchorListItem teamLink;
	
	@UiField
	AnchorListItem leagueLink;
	
	@UiField
	AnchorListItem scheduleLink;
	
	
	private static MainMenuViewUiBinder uiBinder = GWT
			.create(MainMenuViewUiBinder.class);

	interface MainMenuViewUiBinder extends UiBinder<Widget, MainMenuView> {
	}

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
	public MainMenuView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
	public MainMenuView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		
	}

	@UiHandler("teamLink")
	void handleTeamLinkClick(ClickEvent e) {
		Window.alert("To Teams section");
		
	}
	
	@UiHandler("leagueLink")
	void handleLeagueLinkClick(ClickEvent e) {
		Window.alert("To League section");
		presenter.goLeague();
	}
	
	@UiHandler("scheduleLink")
	void handleScheduleLinkClick(ClickEvent e) {
		Window.alert("To Schedule section");
		// @TODO goToSchedule
	}
	
	@UiHandler("homeLink")
	void handleHomeLinkClick(ClickEvent e) {
		Window.alert("To Home section");
		presenter.goHome();
	}
	
	public void setPresenter(MainMenuPresenter presenter) {
		this.presenter = presenter;
	}

	/* public void setText(String text) {
		//button.setText(text);
	}

	
	public String getText() {
		//return button.getText();
	}
	*/

}
