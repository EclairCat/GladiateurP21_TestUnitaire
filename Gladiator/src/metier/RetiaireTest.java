package metier;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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
        assertThat("Gladiateur.getIdg : Idg mal initialisÃ©", r.getIdg(), is(1));
    }
    
    /**
     * @see Gladiateur#getNom()
     */
    @Test
    public void testGetNom()
    {
        assertThat("Gladiateur.getNom : Nom mal initialisÃ©", r.getNom(), is("Younix"));
    }
    
    /**
     * @see Retiaire#getAgilite()
     */
    @Test
    public void testGetAgilite()
    {
        assertThat("Retiaire.getAgilite : Agilite mal initialisÃ©e", 
                   r.getAgilite(), is(50));
    }

    
    /**
     * @see Gladiateur#getMonEthnie()
     */
    //Nous n'avons pas de getMonEthnie() il est gerÃ© par le gestionaire d'Ethnie
  
    
    /**
     * @see Gladiateur#getVie()
     */
    @Test
    public void testGetVie()
    {
        assertThat("Gladiateur.getVie : Vie mal initialisÃ©e", 
                   r.getVie(), is(Gladiateur.c_getVieInitiale()));
    }

    /**
     * @see Retiaire#getForce()
     */
    @Test
    public void testGetForce()
    {
        assertThat("Retiaire.getForce : Force mal initialisÃ©e", 
                   r.getForce(), is(Retiaire.c_getForceRet()));
    }


    /**
     * @see Retiaire#getTypeGlad()
     */
    @Test
    public void testGetTypeGlad()
    {
        assertThat("Retiaire.getTypeGlad : Type du retiaire mal initialisÃ©", 
                   r.getType(), is(Retiaire.c_getType()));    
    }


    /**
     * @see Retiaire#c_getForceRet()
     */
    @Test
    public void testC_getForceRet()
    {
        assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal initialisÃ©e", 
                   Retiaire.c_getForceRet(), is(30));    
    }

    /**
     * @see Retiaire#c_setForceRet(Integer)
     */
    @Test
    public void testC_setForceRet()
    {
        Retiaire.c_setForceInitiale(50);
        assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal modifiÃ©e", 
                   Retiaire.c_getForceRet(), is(50));
        assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal modifiÃ©e pour Younix", 
                   r.getForce(), is(50));
        Retiaire.c_setForceInitiale(30);
    }

    /**
     * @see Retiaire#c_getAgiliteMax()
     */
    @Test
    public void testC_getAgiliteMax()
    {
        assertThat("Retiaire.c_getAgiliteMax : AgilitÃ© max des retiaires mal initialisÃ©e", 
                   Retiaire.c_getAgiliteMax(), is(50)); 
    }

    /**
     * @see Retiaire#c_setAgiliteMax(Integer)
     */
    @Test
    public void testC_setAgiliteMax()
    {
        Retiaire.c_setAgiliteMax(60);
        assertThat("Retiaire.c_setAgiliteMax : AgilitÃ© max des retiaires mal modifiÃ©e", 
                   Retiaire.c_getAgiliteMax(), is(60)); 
        Retiaire.c_setAgiliteMax(50);
    }

    /**
     * @see Retiaire#c_getTypeGlad()
     */
    @Test
    public void testC_getTypeGlad()
    {
        assertThat("Retiaire.c_getTypeGlad() : Type des retiaires mal initialisÃ©", 
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
        assertThat("Retiaire.c_getTypeGlad() : Type des retiaires mal modifiÃ©", 
                   Retiaire.c_getType(), is(s));
        Retiaire.c_setType(t);
    }

    /**
     * @see Retiaire#rapport()
     */
    @Test
    // Rapport sans rien
    public void testRapport() {
        String rapport;
        rapport =
            String.format("Ave Caesar, %-9s " +
                          "N°%-2d" +
                          " : %-15s," +
                          " j'appartiens à l'ethnie des %-10s." +
                          " Je suis %-8s " +
                          "(c'est a dire que j'ai %-3d points de vie), " + 
                          "ma force est de %-2d je n'ai pas d'armes." +
                          " Mon agilite est de %d.",
                          "Retiaire",
                          1,
                          "Younix",
                          "null",
                          "en forme",
                          200,
                          30,
                          50);
        
        assertThat("Mirmillon.rapport : n'est pas le bon résultat.",
                   r.rapport("null"), is(rapport));
    }
    
    @Test
    // Rapport avec une arme
    public void testRapport2() {
        String rapport;
        rapport =
            String.format("Ave Caesar, %-9s " +
                          "N°%-2d" +
                          " : %-15s," +
                          " j'appartiens à l'ethnie des %-10s." +
                          " Je suis %-8s " +
                          "(c'est a dire que j'ai %-3d points de vie), " + 
                          "ma force est de %-2d mon arme est : epee." +
                          " Mon agilite est de %d.",
                          "Retiaire",
                          1,
                          "Younix",
                          "null",
                          "en forme",
                          200,
                          30,
                          50);
        Arme a = new Arme(1, "epee", 50, 10);
        Retiaire.c_autoriserArme(a);
        r.receveoirArme(a);
        
        assertThat("Mirmillon.rapport : n'est pas le bon résultat.",
                   r.rapport("null"), is(rapport));
    }
    
    @Test
    // Rapport avec deux armes
    public void testRapport3() {
        String rapport;
        rapport =
            String.format("Ave Caesar, %-9s " +
                          "N°%-2d" +
                          " : %-15s," +
                          " j'appartiens à l'ethnie des %-10s." +
                          " Je suis %-8s " +
                          "(c'est a dire que j'ai %-3d points de vie), " + 
                          "ma force est de %-2d mes armes sont :epee bouclier ." +
                          " Mon agilite est de %d.",
                          "Retiaire",
                          1,
                          "Younix",
                          "null",
                          "en forme",
                          200,
                          30,
                          50);
        Arme a = new Arme(1, "epee", 50, 10);
        Arme b = new Arme(2, "bouclier", 0, 90);
        Retiaire.c_autoriserArme(a);
        Retiaire.c_autoriserArme(b);
        r.receveoirArme(a);
        r.receveoirArme(b);
        
        assertThat("Mirmillon.rapport : n'est pas le bon résultat.",
                   r.rapport("null"), is(rapport));
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
        assertTrue("Retiaire.listerArmesAutorisees : liste des armes autorisés non vide initialement", 
                   Retiaire.c_listeArmeDispo().isEmpty());
    }
    
 
    

    /**
     * @see Gladiateur#getEtat()
     */
    @Test
    public void testGetEtat()
    {
        assertThat("Gladiateur.GetEtat : younix devrait Ãªtre bien portant", 
                   r.getEtat(),is("en forme"));
        r.prendreCoup(151, r2);
        assertThat("Gladiateur.GetEtat : younix devrait être blessé", 
                   r.getEtat(),is("blesse"));
        r.prendreCoup(49,r2);
        assertThat("Gladiateur.GetEtat : younix devrait être moribond", 
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
    //    "Gladiateur.recevoirCoup : force nÃ©gative ne lance pas l'exception IllegalArgumentException"
    public void testRecevoirCoup()
    {
        r.prendreCoup( -1, null);
    }

    /**
     * @see Gladiateur#saluer()
     */
    @Test
    public void testSaluer()
    {
        String salut = String.format("Ave Caesar, %-9s N°%-2d : %-15s, j'appartiens à l'ethnie des %-10s",
                                     "Retiaire",
                                     1,
                                     "Younix",
                                     "null");
        assertThat("Mirmillon.saluer : le salut n'est pas correcte.",
                   r.saluer("null"), is(salut));
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
    //    "Retiaire.init : Identificateur nÃ©gatif ne lance pas l'exception IllegalArgumentException"
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
    //    "Retiaire.init : agilitÃ© nÃ©gative ne lance pas l'exception IllegalArgumentException"
    public void testRetiaire4()
    {
        Retiaire r2 = new Retiaire(1, "Agilix", -100);
        assertThat("Retiaire  si agilité negative alors on met 0", r2.getAgilite(), is(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Retiaire.init : agilitÃ© > max ne lance pas l'exception IllegalArgumentException"
    public void testRetiaire5()
    {
        new Retiaire(1, "Agilix", Retiaire.c_getAgiliteMax() + 10);
    }
}