package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;

	public Romain(String nom, int force) {
		if (force >= 0) {
			throw new IllegalArgumentException("Invalid force: " + force);
		}
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//    public void recevoirCoup(int forceCoup) {
//        assert force > 0;
//        int var = force;
//        force -= forceCoup;
//        if (force > 0) {
//            parler("Aïe");
//        } else {
//            parler("J'abandonne...");
//        }
//        assert var > force;
//    }
//
	public void sEquiper(Equipement equipement) {
        switch (nbEquipements) {
        case 0:
            ajouterEquipement(equipement, 0);
            break;

        case 1:
            if (this.equipements[0] == equipement) {
                System.out.println("Le soldat " + nom + " possède déjà " + equipement + "!");
            } 
            else {
                ajouterEquipement(equipement, 1);
            }
            break;

        case 2:
            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
            break;
         default:
        	 System.out.println("Nombre équipement invalid : " + nbEquipements);;
        	 break;
        }
	}

	private void ajouterEquipement(Equipement equipement, int indice) {
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement + " !");
		this.equipements[indice] = equipement;
		nbEquipements++;
	}

	public Equipement[] recevoirCoup (int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aïe");
		}
			else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;

	}

	private int CalculResistanceEquipement(int forceCoup) {
        	String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
        	int resistanceEquipement = 0;
        	if (!(nbEquipement == 0)) {
        	texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
        	for (int i = 0; i < nbEquipement;) {
        	if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
        	resistanceEquipement += 8;
        	} else {
        	System.out.println("Equipement casque");
        	resistanceEquipement += 5;
        	}
        	i++;
        	}
        	texte =+ resistanceEquipement + "!";
        	}
        	parler(texte);
        	forceCoup -= resistanceEquipement;
        	return forceCoup;
        	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
}
