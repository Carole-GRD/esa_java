package Heritage.Dossier_Vehicule;

public abstract class Vehicule {
    private String marque;
    private String couleur;
    private String statut;
    private int roues;
    protected int kms;

    public Vehicule(String marque, String couleur, int roues) {
        this.marque = marque;
        this.couleur = couleur;
        this.roues = roues;
        this.kms = 0;
        this.statut = "A l'arrêt";
    }

    public abstract void checkUp();

    public void avance() {
        checkUp();
        System.out.println("Avance");
        kms+=10;
        statut = "En marche";
    }

    public void arrete() {
        System.out.println("Arreter");
        statut = "A l'arrêt";
    }

    public String getStatut() {
        return statut;
    }

    public int getKMS () {
        return kms;
    }

}
