package Heritage;

import Heritage.Dossier_Vehicule.Vehicule;

public class Voiture extends Vehicule {
    public Voiture(String marque, String couleur) {
        super(marque, couleur, 4);
    }

    @Override
    public void checkUp() {
        System.out.println("Vérification jauge carburant");
    }
}
