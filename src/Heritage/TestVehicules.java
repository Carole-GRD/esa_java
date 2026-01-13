package Heritage;

import Heritage.Dossier_Vehicule.Vehicule;

public class TestVehicules {
    public static void main(String[] args) {
        Velo velo = new Velo("Bosch", "Bleu");

        System.out.println(velo.getStatut());
        velo.avance();
        System.out.println(velo.getStatut());
        velo.arrete();
        System.out.println(velo.getStatut());

        velo.changerMultiplicateur(2);
        velo.changerVitesse(2);
        System.out.println(velo.getKMS());

//        Vehicule vehicule = new Vehicule("VW", "Verte", 4);
//        System.out.println(vehicule.getStatut());
//        vehicule.avance();
//        System.out.println(vehicule.getStatut());
//        vehicule.arrete();
//        System.out.println(vehicule.getStatut());
//        System.out.println(vehicule.getKMS());

        Trotinette trotinette = new Trotinette("Grise");
        trotinette.avance();

        Voiture voiture = new Voiture("Renault", "Bleu");

        Vehicule[] maCollection = new Vehicule[3];
        maCollection[0] = velo;
        maCollection[1] = voiture;
        maCollection[2] = trotinette;

        for(var vehicule : maCollection) {
            vehicule.avance();
        }
    }
}

