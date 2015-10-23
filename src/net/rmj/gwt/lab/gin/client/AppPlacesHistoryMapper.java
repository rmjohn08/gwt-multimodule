package net.rmj.gwt.lab.gin.client;

import net.rmj.gwt.lab.gin.client.home.HomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({HomePlace.Tokenizer.class})
public interface AppPlacesHistoryMapper extends PlaceHistoryMapper {
}
