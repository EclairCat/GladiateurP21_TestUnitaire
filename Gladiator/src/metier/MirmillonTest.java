package metier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MirmillonTest {
    private Mirmillon m;
       private Ethnie e;
       
       @Before
       public void setUp()
       {
           e = new Ethnie(1, "Gaulois");
           m = new Mirmillon(1, "Younix", 50);        
       }
               
       /**
        * @see Gladiateur#getIdg()
        */
       @Test
       public void testGetIdg()
       {
           assertThat("Gladiateur.getIdg : Idg mal initialisé", m.getIdg(), is(1));
       }
       
       /**
        * @see Gladiateur#getNom()
        */
       @Test
       public void testGetNom()
       {
           assertThat("Gladiateur.getNom : Nom mal initialisé", m.getNom(), is("Younix"));
       }
       
       /**
        * @see Mirmillon#getAgilite()
        */
       @Test
       public void testGetForce()
       {
           assertThat("Mirmillon.getForce : Force mal initialisée", 
                      m.getForce(), is(25));
       }

       
       
       /**
        * @see Gladiateur#getMonEthnie()
        */
       // Nous n'avons pas de getMonEthnie, il est géré par le gestionnaire d'Ethnie
       
       
       /**
        * @see Gladiateur#getVie()
        */
       @Test
       public void testGetVie()
       {
           assertThat("Gladiateur.getVie : Vie mal initialisée", 
                      m.getVie(), is(Gladiateur.c_getVieInitiale()));
       }

       /**
        * @see Mirmillon#getType()
        */
       @Test
       public void testGetType() {
           assertThat("Gladiateur.getType : Type mal initialisé",
                      m.getType(), is(Mirmillon.c_getType()));
       }

       /**
        * @see Mirmillon#getListeAgresseur()
        */
       @Test
       public void testGetListeAgresseur() {
           assertTrue("Mirmillon.getListAgresseur : pas vide",
               m.getListeAgresseur().isEmpty());
       }

       /**
        * @see Mirmillon#c_setPoidMax(Integer)
        */
       @Test
       public void testC_setPoidMax() {
           int poids = 200;
           Mirmillon.c_setPoidMax(poids);
           assertThat("Mirmillon.x_setPoidMax : poids max mal changé",
                     Mirmillon.c_getPoidsMax(), is(poids));
       }

       /**
        * @see Mirmillon#c_listeArmeDispo()
        */
       @Test
       public void testC_listeArmeDispo() {
           assertTrue("Mirmillon.c_listeArmeDispo : mal initialisé",
                      Mirmillon.c_listeArmeDispo().isEmpty());
       }

       /**
        * @see Mirmillon#c_autoriserArme(Arme)
        */
       @Test
       public void testC_autoriserArme() {
           Arme a = new Arme(1, "epee", 10, 10);
           Mirmillon.c_autoriserArme(a);
           assertTrue("Mirmillon.c_autoriserArme : l'arme n'a pas été donnée",
                      Mirmillon.c_listeArmeDispo().contains(a));
       }

       /**
        * @see Mirmillon#prendreCoup(Integer,Gladiateur)
        */
       @Test
       public void testPrendreCoup() {
           Gladiateur gAgresseur = new Mirmillon(1, "Bob", 100);
           m.prendreCoup(50, gAgresseur);
           assertThat("Mirmillon.prendreCoup : le gladiateur n'a pas pris les dégâts",
                      m.getVie(), is(150));
           assertTrue("Mirmillon.prendreCoup : le gladiateur n'a pas été ajouté dans la liste d'agresseurs",
                      m.getListeAgresseur().contains(gAgresseur));
       }

       /**
        * @see Mirmillon#rapport(String)
        */
       @Test
       @Ignore
       public void testRapport() {
           // Le test du rapport est difficile à réaliser
       }

       /**
        * @see Gladiateur#getEtat()
        */
       @Test
       public void testGetEtat() {
           assertThat("Gladiateur.getEtat : n'a pas le bon état de base",
                      m.getEtat(), is("en forme"));
           Gladiateur gAgresseur = new Mirmillon(1, "Bob", 100);
           m.prendreCoup(151, gAgresseur);
           assertThat("Gladiateur.getEtat : n'est pas blessé",
                      m.getEtat(), is("blesse"));
           m.prendreCoup(40, gAgresseur);
           assertThat("Gladiateur.getEtat : n'est pas moribond",
                      m.getEtat(), is("moribond"));
       }

       /**
        * @see Gladiateur#getArmes()
        */
       @Test
       public void testGetArmes() {
           assertTrue("Mirmillon.getArmes : a mal été initialisé",
                      m.getArmes().isEmpty());
       }

       /**
        * @see Gladiateur#receveoirArme(Arme)
        */
       @Test(expected = IllegalArgumentException.class)
       public void testReceveoirArme() {
           m.receveoirArme(null);
       }

       /**
        * @see Gladiateur#perdreArme(Arme)
        */
       @Test(expected = IllegalArgumentException.class)
       public void testPerdreArme() {
           m.perdreArme(null);
       }

       /**
        * @see Gladiateur#frapper(Gladiateur,Arme)
        */
       @Test(expected = IllegalArgumentException.class)
       public void testFrapper() {
           m.frapper(null, null);
       }

       /**
        * @see Gladiateur#saluer(String)
        */
       @Test
       @Ignore
       public void testSaluer() {
           // La même chose que rapport
       }
       
       @Test(expected = IllegalArgumentException.class)
           //    "Retiaire.init : Identificateur négatif ne lance pas l'exception IllegalArgumentException"
           public void testMirmillon1()
           {
               new Mirmillon(-1, "Negativix", 30);
           }

           @Test(expected = IllegalArgumentException.class)
           //    "Retiaire.init : Nom null ne lance pas l'exception IllegalArgumentException"
           public void testMirmillon2()
           {
               new Mirmillon(1, null, 30);
           }

           @Test(expected = IllegalArgumentException.class)
           //    "Retiaire.init : Nom vide ne lance pas l'exception IllegalArgumentException"
           public void testMirmillon3()
           {
               new Mirmillon(1, "", 30);
           }

           @Test
           //    "Retiaire.init : agilité négative ne lance pas l'exception IllegalArgumentException"
           public void testMirmillon4()
           {
               Mirmillon m = new Mirmillon(1, "Poilix", -100);
               assertThat("Poids < 0, le poids doit être à 0",
                          m.getPoids(), is(0));
           }
           
           @Test
           //    "Retiaire.init : agilité > max ne lance pas l'exception IllegalArgumentException"
           public void testMirmillon5()
           {
               Mirmillon m = new Mirmillon(1, "Poilix", Mirmillon.c_getPoidsMax() + 10);
               assertThat("Poids > poidsMax, le poids doit être à poids max",
                          m.getPoids(), is(Mirmillon.c_getPoidsMax()));
           }


        
}
