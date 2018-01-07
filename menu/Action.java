package menu;

import java.util.*;
import animal.*;
import exception.*;

public class Action implements ChoosableOptions {

	private ArrayList<Animal> animals = new ArrayList<>();
	private ArrayList<String> songs = new ArrayList<>();

	@Override
	public void registerGuest(String name, String specie, String song) {
		if(!contains(name)) {
			Scanner sc = new Scanner(System.in);

			System.out.print("Arrival mode (Flying/Swimming/Land): ");
			String arrival = sc.nextLine().toLowerCase();

			switch(arrival) {
				case "flying":
					System.out.print("Extension of wings: ");
					int ext = 0;
					try { 
						ext = sc.nextInt();
						animals.add(new Flying(name, specie, song, ext));
						System.out.println("Registration successful");
					} catch (InputMismatchException e) {
						System.out.println("Registration failed. Please try again!");
					}
					break;
				case "swimming":
					System.out.print("Where do you come from (sea/river): ");
					String from = sc.nextLine().toLowerCase();
					if(from.equals("sea") || from.equals("river")) {
						animals.add(new Swimming(name, specie, song, from));
						System.out.println("Registration successful");
					} else {
						System.out.println("Registration failed. Please try again!");
					}
					break;
				case "land":
					System.out.print("Number of paws: ");
					int paws = 0;
					try { 
						paws = sc.nextInt();
						animals.add(new Land(name, specie, song, paws));
						System.out.println("Registration successful");
					} catch (InputMismatchException e) {
						System.out.println("Registration failed. Please try again!");
					}
					break;
				default:
					System.out.println("Registration failed. Please try again!");
			}
		} else {
			System.out.println("The Guest is already registered!");
		}
	}

	@Override
	public void removeGuest(String name) {
		if(contains(name)) {
			for(int i = 0; i < animals.size(); i++) {
				if(animals.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
					animals.remove(i);
					System.out.println("Remove successful!");
				}
			}
		} else {
			System.out.println("The Guest isn't on the list!");
		}
	}

	@Override
	public String pickASong() throws NoSongException {
		if(!(songs.size() == animals.size())) { 
			Random r = new Random();
			int pickedSongIndex = r.nextInt(animals.size());
			//System.out.print(pickedSongIndex);
			if(!isAlreadyPicked(animals.get(pickedSongIndex).getSong())) {
				String pickedSong = animals.get(pickedSongIndex).getSong();
				songs.add(pickedSong);
				return pickedSong;
			}
		} else {
			throw new NoSongException();
		}
		return null;
	}

	@Override
	public void listPlayedSongs() {
		if(songs.size() == 0) {
			System.out.println("There are no songs!");
		} else {
			for(String song : songs) {
				System.out.println(song);
			}
		}
	}

	@Override
	public void isOnGuestList(String name) {
		if(contains(name)) {
			System.out.println("The Guest is on the list!");
		} else {
			System.out.println("The Guest isn't on the list!");
		}
	}

	@Override
	public void listAnimalNeedsByName(String name) {
		boolean contains = false;
		Animal animal = null;
		name = name.toLowerCase();
		for(Animal a : animals) {
			if(a.getName().toLowerCase().equals(name)) {
				System.out.println(a.getName());
			 	animal = a;
				contains = true;
			}
		}
		if(contains) {
			System.out.println(animal.getNeeds());
		} else {
			System.out.println("This animal isn't on the list!");
		}
	}

	@Override
	public void listAnimalNeedsBySpecie(String specie) {
		for(Animal a : animals) {
			if(a.getSpecie().toLowerCase().equals(specie.toLowerCase())) {
				System.out.println(a.getNeeds());
			}
		}
	}

	private boolean contains(String name) {
		for(Animal a : animals) {
			if(a.getName().toLowerCase().equals(name.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private boolean isAlreadyPicked(String song) {
		for(String s : songs) {
			if(s.toLowerCase().equals(song.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}