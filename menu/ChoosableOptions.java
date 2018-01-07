package menu;

import animal.*;
import exception.*;

public interface ChoosableOptions {

	void registerGuest(String name, String specie, String song);
	void removeGuest(String name);
	String pickASong() throws NoSongException;
	void listPlayedSongs();
	void isOnGuestList(String name);
	void listAnimalNeedsByName(String name);
	void listAnimalNeedsBySpecie(String specie);
}