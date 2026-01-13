package Heritage;

import Heritage.Dossier_Vehicule.Vehicule;

public class Velo extends Vehicule {
    private int plateauAvant = 1;
    private int plateauArriere = 1;

    public Velo(String marque, String couleur) {
        super(marque, couleur, 2);
    }

    public void changerMultiplicateur(int multiplicateur) {
        this.plateauAvant = multiplicateur;
    }

    public void changerVitesse(int vitesse) {
        this.plateauArriere = vitesse;
    }

    @Override
    public void checkUp() {
        System.out.println("Vérification pneus");
    }

    public void avance() {
        var tempkms = kms;
        super.avance();
        kms = tempkms + 1;
    }

}
