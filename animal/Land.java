package animal;

public class Land extends Animal {

	private int paws;

	public Land(String name, String specie, String song, int paws) {
		super(name, specie, song);
		this.paws = paws;
	}

	public void setPaws(int paws) {
		this.paws = paws;
	}

	public int getPaws() {
		return paws;
	}

	@Override
	public String getNeeds() {
		return (super.getNeeds() + "Number of paws " + String.valueOf(paws));
	}
}