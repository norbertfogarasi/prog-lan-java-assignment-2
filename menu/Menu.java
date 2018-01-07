package menu;

import java.util.*;
import exception.*;

public class Menu {

	private ChoosableOptions choose;

	public Menu() {
		choose = new Action();
	}

	public void mainMenu() {
		System.out.println("1.) Register a Guest");
		System.out.println("2.) Remove a Guest");
		System.out.println("3.) Pick a song");
		System.out.println("4.) List played songs");
		System.out.println("5.) Check if one animal is on the Guest list");
		System.out.println("6.) List animal needs by animal name");
		System.out.println("7.) List animal needs by specie name");
		System.out.println("0.) Exit");
		int option = -1;
		do {
			try { 
				option = getOption();
				handleOption(option);
			} catch (InputMismatchException e) {
				System.out.println("Wrong option. Please try again!");
			}
		} while(option != 0);
	}

	private int getOption() throws InputMismatchException {
		System.out.print("\nYour option: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private void handleOption(int option) {
		Scanner sc = new Scanner(System.in);
		switch(option) {
			case 0:
				System.exit(1);
			case 1:
				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Specie: ");
				String specie = sc.nextLine();

				System.out.print("Song: ");
				String song = sc.nextLine();
				choose.registerGuest(name, specie, song);
				break;
			case 2:
				System.out.print("Name: ");
				String toRemove = sc.nextLine();
				choose.removeGuest(toRemove);
				break;
			case 3:
				try {
					String pickedSong;
					while((pickedSong = choose.pickASong()) == null) { }
					System.out.println("Picked song: " + pickedSong);
				} catch (NoSongException e) {
					System.out.println("There are no song in the list!");
				}
				break;
			case 4:
				choose.listPlayedSongs();
				break;
			case 5:
				System.out.print("Name: ");
				String toCheck = sc.nextLine();
				choose.isOnGuestList(toCheck);
				break;
			case 6:
				System.out.print("Name: ");
				choose.listAnimalNeedsByName(sc.nextLine());
				break;
			case 7:
				System.out.print("Specie: ");
				choose.listAnimalNeedsBySpecie(sc.nextLine());
				break;
			default:
				System.out.println("Wrong option. Please try again!");
		}
	}

}