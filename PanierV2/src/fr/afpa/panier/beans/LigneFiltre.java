package fr.afpa.panier.beans;

public class LigneFiltre {
	
	private int id;
	
	private String intitule;
	
	private boolean checked;

	public LigneFiltre(int id, String intitule, boolean checked) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.checked = checked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
	public String getValueChecked() {
		
		if (checked==false) {
			return "";
		} else {
			return "checked";
			
		}
	}

	@Override
	public String toString() {
		return this.id + " - "  +this.intitule + " - " + this.checked;
	}
	
}
