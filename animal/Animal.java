package animal;

public abstract class Animal implements Need {

	private String name;
	private String specie;
	private String song;

	public Animal(String name, String specie, String song) {
		this.name = name;
		this.specie = specie;
		this.song = song;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getNeeds() {
		return getName() + "'s needs - ";
	} 
}