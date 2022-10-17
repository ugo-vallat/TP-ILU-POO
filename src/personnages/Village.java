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
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i<nbVillageois; i++)
			System.out.println("- " + villageois[i].getNom());
	}
	

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		System.out.println(village.trouverHabitant(30));
//		on obtient ArrayIndexOutOfBoundsException parce que l'on cherche un élément hors du tableau (31ème élément d'un taleau à 30 éléments)
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		on obtient gaulois = null car on cherche dans le tableau des villageois une case qui n'est pas encore occupée
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}

}
