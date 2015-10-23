package net.rmj.gwt.lab.gin.client.home;

import javax.inject.Inject;

import net.rmj.gwt.lab.shared.FieldVerifier;
import net.rmj.gwt.lab.shared.service.GreetingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import net.rmj.gwt.lab.shared.Constants;

public class HomeView extends Composite implements HasText {

	private static HomeViewUiBinder uiBinder = GWT
			.create(HomeViewUiBinder.class);
	
	@UiField
	Button sendButton;
	
	@UiField
	TextBox textName;
	
	@UiField
	Label errorLabel;
	
	@UiField
	IntegerBox intBox;
	
	@UiField
	Label errorLabelNumber;
	
	@UiField
	Button checkInteger;
	
	GreetingServiceAsync greetingService;

	interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
	}

	@Inject
	public HomeView(GreetingServiceAsync greetingService) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.greetingService = greetingService;
		initView();
	}
	
	/*@UiHandler("sendButton")
	void onClick(ClickEvent e) {
		
	}
	*/
	
	public void setText(String text) {
		//button.setText(text);
	}

	public String getText() {
		return "";
	}
	
	private void initView() {
		
		//final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Focus the cursor on the name field when the app loads
		textName.setFocus(true);
		textName.selectAll();
		textName.setText("GWT User");

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = textName.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(Constants.SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		textName.addKeyUpHandler(handler);
	}
	
	@UiHandler("checkInteger")
	void checkIntBox(ClickEvent e) {
		
		try {
			Integer value = intBox.getValueOrThrow();
			errorLabelNumber.setText("good "+ value.toString());
			
		} catch(Exception ex) {
			errorLabelNumber.setText("unparsable");
			
		}
	}
		@UiHandler("intBox")
		void checkOnBlur(BlurEvent e) {
			
			try {
				Integer value = intBox.getValueOrThrow();
				errorLabelNumber.setText("good "+ value.toString());
				
			} catch(Exception ex) {
				errorLabelNumber.setText("unparsable");
				
			}
		}
		
	

}
