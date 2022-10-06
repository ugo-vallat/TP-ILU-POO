package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois villageois[];
	
	
	public Village(String nom, int nbVillageoisMaximum) {
		super();
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		
	}
	
	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
		System.out.println("Bienvenue " + chef.getNom());
	}

	public String getNom() {
		return nom;
	}

	public int getNbVillageois() {
		return nbVillageois;
	}
	
	public boolean ajouterHabitant(Gaulois habitant) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = habitant;
			nbVillageois++;
			System.out.println("Heureux de t'acceuillir "+ habitant.getNom());
			return true;
		} else {
			System.out.println("Impossible d'ajouter un villageois, toutes les maisons sont prises");
			return false;
		}
	}
	
	public Gaulois trouverHabitant(int numGaulois) {
		return(villageois[numGaulois-1]);
	}
	

	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//Valeur non d�finie
		Chef chef = new Chef ("Abraracourcix", 8, village);
		village.setChef(chef);
		Gaulois Asterix = new Gaulois ("Asterix", 8);
		village.ajouterHabitant(Asterix);
		
		Gaulois gaulois = village.trouverHabitant(1);
		System.out.println("Tu cherchais " + gaulois.getNom() + " ?");
		
	}

}
