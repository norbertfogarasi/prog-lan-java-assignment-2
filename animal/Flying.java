package animal;

public class Flying extends Animal {

	private int extOfWings;

	public Flying(String name, String specie, String song, int extOfWings) {
		super(name, specie, song);
		this.extOfWings = extOfWings;
	}

	public void setExtOfWings(int setExtOfWings) {
		this.extOfWings = extOfWings;
	}

	public int getExtOfWings() {
		return extOfWings;
	}

	@Override
	public String getNeeds() {
		return (super.getNeeds() + "Extension of my wings: " + String.valueOf(extOfWings));
	}

}