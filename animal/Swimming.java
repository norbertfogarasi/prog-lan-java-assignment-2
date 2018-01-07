package animal;

public class Swimming extends Animal {

	private String arrive;

	public Swimming(String name, String specie, String song, String arrive) {
		super(name, specie, song);
		this.arrive = arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public String getArrive() {
		return arrive;
	}

	@Override
	public String getNeeds() {
		return super.getNeeds() + "I come from " + arrive;
	}
}