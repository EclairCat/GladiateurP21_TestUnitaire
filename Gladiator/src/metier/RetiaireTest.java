package metier;

import metier.Ethnie;
import metier.Gladiateur;
import metier.Retiaire;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import packglad.GEthnie;

public class RetiaireTest
{
    private Retiaire r;
    private Ethnie e;
    private Retiaire r2;
    
    @Before
    public void setUp()
    {
        e = new Ethnie(1, "Gaulois");
        r = new Retiaire(1, "Younix", 50);   
        r2 = new Retiaire(2,"Tueur",50);
        e.ajouterGladiateur(r);
        
    }
            
    /**
     * @see Gladiateur#getIdg()
     */
    @Test
    public void testGetIdg()
    {
        assertThat("Gladiateur.getIdg : Idg mal initialisé", r.getIdg(), is(1));
    }
    
    /**
     * @see Gladiateur#getNom()
     */
    @Test
    public void testGetNom()
    {
        assertThat("Gladiateur.getNom : Nom mal initialisé", r.getNom(), is("Younix"));
    }
    
    /**
     * @see Retiaire#getAgilite()
     */
    @Test
    public void testGetAgilite()
    {
        assertThat("Retiaire.getAgilite : Agilite mal initialisée", 
                   r.getAgilite(), is(50));
    }

    
    /**
     * @see Gladiateur#getMonEthnie()
     */
    //Nous n'avons pas de getMonEthnie() il est geré par le gestionaire d'Ethnie
  
    
    /**
     * @see Gladiateur#getVie()
     */
    @Test
    public void testGetVie()
    {
        assertThat("Gladiateur.getVie : Vie mal initialisée", 
                   r.getVie(), is(Gladiateur.c_getVieInitiale()));
    }

    /**
     * @see Retiaire#getForce()
     */
    @Test
    public void testGetForce()
    {
        assertThat("Retiaire.getForce : Force mal initialisée", 
                   r.getForce(), is(Retiaire.c_getForceRet()));
    }


    /**
     * @see Retiaire#getTypeGlad()
     */
    @Test
    public void testGetTypeGlad()
    {
        assertThat("Retiaire.getTypeGlad : Type du retiaire mal initialisé", 
                   r.getType(), is(Retiaire.c_getType()));    
    }


    /**
     * @see Retiaire#c_getForceRet()
     */
    @Test
    public void testC_getForceRet()
    {
        assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal initialisée", 
                   Retiaire.c_getForceRet(), is(30));    
    }

    /**
     * @see Retiaire#c_setForceRet(Integer)
     */
    @Test
    public void testC_setForceRet()
    {
        Retiaire.c_setForceInitiale(50);
        assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal modifiée", 
                   Retiaire.c_getForceRet(), is(50));
        assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal modifiée pour Younix", 
                   r.getForce(), is(50));
        Retiaire.c_setForceInitiale(30);
    }

    /**
     * @see Retiaire#c_getAgiliteMax()
     */
    @Test
    public void testC_getAgiliteMax()
    {
        assertThat("Retiaire.c_getAgiliteMax : Agilité max des retiaires mal initialisée", 
                   Retiaire.c_getAgiliteMax(), is(50)); 
    }

    /**
     * @see Retiaire#c_setAgiliteMax(Integer)
     */
    @Test
    public void testC_setAgiliteMax()
    {
        Retiaire.c_setAgiliteMax(60);
        assertThat("Retiaire.c_setAgiliteMax : Agilité max des retiaires mal modifiée", 
                   Retiaire.c_getAgiliteMax(), is(60)); 
        Retiaire.c_setAgiliteMax(50);
    }

    /**
     * @see Retiaire#c_getTypeGlad()
     */
    @Test
    public void testC_getTypeGlad()
    {
        assertThat("Retiaire.c_getTypeGlad() : Type des retiaires mal initialisé", 
                   Retiaire.c_getType().toLowerCase(), is("retiaire"));
    }

    /**
     * @see Retiaire#c_setTypeGlad(String)
     */
    @Test
    public void testC_setTypeGlad()
    {
        String s = "NouveauNOM";
        String t = Retiaire.c_getType();
        Retiaire.c_setType(s);
        assertThat("Retiaire.c_getTypeGlad() : Type des retiaires mal modifié", 
                   Retiaire.c_getType(), is(s));
        Retiaire.c_setType(t);
    }

    /**
     * @see Retiaire#rapport()
     */
    @Test
    @Ignore
    public void testRapport()
    {
        fail("Ce test est délicat à réaliser car le format exact n'a pas été fixé");
    }


    /**
     * @see Retiaire#armeAutorisee(Arme)
     */
    @Test(expected = IllegalArgumentException.class)
    //    "Retiaire.armeAutorisee : Arme null ne lance pas l'exception IllegalArgumentException"
    public void testArmeAutorisee()
    {
        Retiaire.c_autoriserArme(null);
    }

    /**
     * @see Retiaire#listerArmesAutorisees()
     */
    @Test
    public void testListerArmesAutorisees()
    {
        assertTrue("Retiaire.listerArmesAutorisees : liste des armes autorisées non vide initialement", 
                   Retiaire.c_listeArmeDispo().isEmpty());
    }
    
 
    

    /**
     * @see Gladiateur#getEtat()
     */
    @Test
    public void testGetEtat()
    {
        assertThat("Gladiateur.GetEtat : younix devrait être bien portant", 
                   r.getEtat(),is("en forme"));
        r.prendreCoup(151, r2);
        assertThat("Gladiateur.GetEtat : younix devrait être bien portant", 
                   r.getEtat(),is("blesse"));
        r.prendreCoup(49,r2);
        assertThat("Gladiateur.GetEtat : younix devrait être bien portant", 
                   r.getEtat(),is("moribond"));
    }

    /**
     * @see Gladiateur#getMesArmes()
     */
    @Test
    public void testGetMesArmes()
    {
        assertTrue("Gladiateur.getMesArmes : younix ne devrait pas avoir d'arme", 
                   r.declarerArme().isEmpty());    }


    /**
     * @see Gladiateur#frapper(Gladiateur,Arme)
     */
    @Test(expected = IllegalArgumentException.class)
    //    "Gladiateur.frapper : Gladiateur ou Arme null ne lance pas l'exception IllegalArgumentException"
    public void testFrapper()
    {
        r.frapper(null, null);
    }

    /**
     * @see Gladiateur#recevoirCoup(Gladiateur,Integer)
     */
    @Test(expected = IllegalArgumentException.class)
    //    "Gladiateur.recevoirCoup : Gladiateur null ne lance pas l'exception IllegalArgumentException"
    //    "Gladiateur.recevoirCoup : force négative ne lance pas l'exception IllegalArgumentException"
    public void testRecevoirCoup()
    {
        r.prendreCoup( -1, null);
    }

    /**
     * @see Gladiateur#saluer()
     */
    @Test
    @Ignore
    public void testSaluer()
    {
        fail("Ce test est délicat à réaliser car le format exact n'a pas été fixé");
    }
    

    /**
     * @see Gladiateur#recevoirArme(Arme)
     */
    @Test(expected = IllegalArgumentException.class)
    //    "Gladiateur.recevoirArme : Arme null ne lance pas l'exception IllegalArgumentException"
    public void testRecevoirArme()
    {
        r.receveoirArme(null);
    }

    /**
     * @see Gladiateur#perdreArme(Arme)
     */
    @Test(expected = IllegalArgumentException.class)
    //    "Gladiateur.perdreArme : Arme null ne lance pas l'exception IllegalArgumentException"
    public void testPerdreArme()
    {
        r.perdreArme(null);
    }  

    @Test(expected = IllegalArgumentException.class)
    //    "Retiaire.init : Identificateur négatif ne lance pas l'exception IllegalArgumentException"
    public void testRetiaire1()
    {
        new Retiaire(-1, "Negativix", 30);
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Retiaire.init : Nom null ne lance pas l'exception IllegalArgumentException"
    public void testRetiaire2()
    {
        new Retiaire(1, null, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Retiaire.init : Nom vide ne lance pas l'exception IllegalArgumentException"
    public void testRetiaire3()
    {
        new Retiaire(1, "", 30);
    }

    @Test
    //    "Retiaire.init : agilité négative ne lance pas l'exception IllegalArgumentException"
    public void testRetiaire4()
    {
        Retiaire r2 = new Retiaire(1, "Agilix", -100);
        assertThat("Retiaire  si agilité negatif alors on met 0", r2.getAgilite(), is(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Retiaire.init : agilité > max ne lance pas l'exception IllegalArgumentException"
    public void testRetiaire5()
    {
        new Retiaire(1, "Agilix", Retiaire.c_getAgiliteMax() + 10);
    }
    
    
    
}
