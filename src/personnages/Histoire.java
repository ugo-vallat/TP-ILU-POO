package personnages;

public class Histoire {
	
	public static void main(String[] args) {

        Druide panoramix = new Druide("Panoramix", 5, 10);
        Gaulois asterix = new Gaulois("Astérix", 8);
        Gaulois obelix = new Gaulois("Obélix", 16);
        Romain minus = new Romain("Minus", 50);
        panoramix.parler("Je vais aller préparer une petite potion...");
        panoramix.booster(obelix);
        obelix.parler("Par Bélénos, ce n'est pas juste !");
        panoramix.booster(asterix);
        asterix.parler("Bonjour");
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        asterix.frapper(minus);
        asterix.frapper(minus);
        asterix.frapper(minus);

    }

}
