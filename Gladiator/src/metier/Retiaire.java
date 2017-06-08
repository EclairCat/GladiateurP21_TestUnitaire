package metier;

import java.util.ArrayList;

public class Retiaire extends Gladiateur {
    private static Integer c_forceInitiale = 30;
    private static Integer c_agiliteMax = 50;
    private Integer agilite;
    private static ArrayList<Arme> c_armeUtilisable  = new ArrayList<Arme>();
    private static String c_Type = "Retiaire";

    public Retiaire(Integer idg, String nom, Integer agilite) {
               
        super(idg, nom);
        
        if(idg == null || nom == null || agilite == null || idg <0 || agilite <0 || nom =="" || agilite > c_agiliteMax)
        {
            throw new IllegalArgumentException();
        }
        
        if (agilite > c_agiliteMax) agilite = c_agiliteMax;
        else if (agilite < 0) agilite = 0;
        this.agilite = agilite;
    }

    public Integer getForce() { return c_forceInitiale; }
    
    public String getType() { return "Retiaire"; }
    
    public static void c_setForceInitiale(Integer force) { 
        // On emp�che de mettre une forceInitiale n�gative
        if (force < 0) {
            System.out.println("Force initiale : Initialis�e � 0 aulieu de " + force);
            c_forceInitiale = 0;
        }
        else c_forceInitiale = force;
    }
    
    public static void c_setAgiliteMax(Integer agi) { 
        // On emp�che de mettre une agilit�Max n�gative
        if (agi< 0){ 
            System.out.println("Agilite initiale : Initialis�e � 0 aulieu de " + agi);
            c_agiliteMax = 0;
        }
        else c_agiliteMax = agi;
    }
    
    public static ArrayList<Arme> c_listeArmeDispo() { return new ArrayList<Arme>(c_armeUtilisable); }
    
    public static void c_autoriserArme(Arme a) 
    {
        // On cherche si l'arme n'est pas d�j� autoris�e
        
        if(a == null) {
            throw new IllegalArgumentException();
        }
        
        boolean trouve = false;
        int i = 0;
        while (i < c_armeUtilisable.size() && !trouve) {
            if (a == c_armeUtilisable.get(i)) {
                trouve = true;
            }                
            i++;
        }
        // Et si elle ne l'est pas on l'ajoute
        if (!trouve) c_armeUtilisable.add(a);
    }

    public void prendreCoup(Integer degat, Gladiateur gAgresseur) {
        //verifie que l'agresseur est null
        if(gAgresseur == null) {            
            throw new IllegalArgumentException();
        }
        // On prend la somme de la puissance d�fensive
        // en pour pouvoir la soustraire aux d�g�ts
        int puissDefTotal = 0;
        for (Arme a : this.getArmes()) {
            puissDefTotal += a.getPuissDef();
        }
        
        // On calcul les d�g�ts qui vont �tre inflig� � notre Gladiateur 
        int degatInflige = degat - puissDefTotal;
        if (degatInflige <  0) degatInflige = 0;
        
        // Puis on inflige les d�g�ts
        this.setVie(this.getVie() - degatInflige);
        if (this.getVie() < 0) this.setVie(0);
    }
    
    @Override
    public String rapport(String nomEthnie) {
        // On fait le rapport du Gladiateur de base
        String rapport = super.rapport(nomEthnie);
        
        // On rajoute les particularit�s du Mirmillon (poids et aggresseurs)
        rapport += String.format(" Mon agilite est de %d.",
                                 this.agilite);
        return rapport;
    }    
    
    public Integer getAgilite(){
        return this.agilite;
    }
    
    public static Integer c_getForceRet(){
        return c_forceInitiale;
    }
    
    public static String c_getType(){
        return c_Type;
    }
    
    public static Integer c_getAgiliteMax() {
        return c_agiliteMax;
    }
    
    public static void c_setType(String type) {
        c_Type = type;
    }
}
