package CS_Object;

import java.io.Serializable;

public class Voiture implements Serializable {
    public int matricule;
    public String marque;

    private static final long serialVersionUID = 1L;
    public Voiture (int matricule,String marque){
        this.matricule=matricule;
        this.marque=marque;
    }
}