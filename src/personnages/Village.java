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
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les l�gendaires gaulois :");
		for (int i = 0; i<nbVillageois; i++)
			System.out.println("- " + villageois[i].getNom());
	}
	

	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
//		System.out.println(village.trouverHabitant(30));
//		on obtient ArrayIndexOutOfBoundsException parce que l'on cherche un �l�ment hors du tableau (31�me �l�ment d'un taleau � 30 �l�ments)
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		on obtient gaulois = null car on cherche dans le tableau des villageois une case qui n'est pas encore occup�e
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}

}
