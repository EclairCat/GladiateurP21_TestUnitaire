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
            assertThat("Gladiateur.getIdg : Idg mal initialis�", m.getIdg(), is(1));
        }
        
        /**
         * @see Gladiateur#getNom()
         */
        @Test
        public void testGetNom()
        {
            assertThat("Gladiateur.getNom : Nom mal initialis�", r.getNom(), is("Younix"));
        }
        
        /**
         * @see Retiaire#getAgilite()
         */
        @Test
        public void testGetAgilite()
        {
            assertThat("Retiaire.getAgilite : Agilite mal initialis�e", 
                       r.getAgilite(), is(50));
        }

        
        /**
         * @see Gladiateur#getMonEthnie()
         */
        @Test
        public void testGetMonEthnie()
        {
            assertThat("Gladiateur.getMonEthnie : ethnie mal initialis�e", 
                       r.getMonEthnie(), is(e));
        }
        
        
        /**
         * @see Gladiateur#getVie()
         */
        @Test
        public void testGetVie()
        {
            assertThat("Gladiateur.getVie : Vie mal initialis�e", 
                       r.getVie(), is(Gladiateur.c_getVieInitiale()));
        }

        /**
         * @see Retiaire#getForce()
         */
        @Test
        public void testGetForce()
        {
            assertThat("Retiaire.getForce : Force mal initialis�e", 
                       r.getForce(), is(Retiaire.c_getForceRet()));
        }


        /**
         * @see Retiaire#getTypeGlad()
         */
        @Test
        public void testGetTypeGlad()
        {
            assertThat("Retiaire.getTypeGlad : Type du retiaire mal initialis�", 
                       r.getTypeGlad(), is(Retiaire.c_getTypeGlad()));    
        }


        /**
         * @see Retiaire#c_getForceRet()
         */
        @Test
        public void testC_getForceRet()
        {
            assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal initialis�e", 
                       Retiaire.c_getForceRet(), is(30));    
        }

        /**
         * @see Retiaire#c_setForceRet(Integer)
         */
        @Test
        public void testC_setForceRet()
        {
            Retiaire.c_setForceRet(50);
            assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal modifi�e", 
                       Retiaire.c_getForceRet(), is(50));
            assertThat("Retiaire.c_getForceRet : Force commune des retiaires mal modifi�e pour Younix", 
                       r.getForce(), is(50));
            Retiaire.c_setForceRet(30);
        }

        /**
         * @see Retiaire#c_getAgiliteMax()
         */
        @Test
        public void testC_getAgiliteMax()
        {
            assertThat("Retiaire.c_getAgiliteMax : Agilit� max des retiaires mal initialis�e", 
                       Retiaire.c_getAgiliteMax(), is(50)); 
        }

        /**
         * @see Retiaire#c_setAgiliteMax(Integer)
         */
        @Test
        public void testC_setAgiliteMax()
        {
            Retiaire.c_setAgiliteMax(60);
            assertThat("Retiaire.c_setAgiliteMax : Agilit� max des retiaires mal modifi�e", 
                       Retiaire.c_getAgiliteMax(), is(60)); 
            Retiaire.c_setAgiliteMax(50);
        }

        /**
         * @see Retiaire#c_getTypeGlad()
         */
        @Test
        public void testC_getTypeGlad()
        {
            assertThat("Retiaire.c_getTypeGlad() : Type des retiaires mal initialis�", 
                       Retiaire.c_getTypeGlad().toLowerCase(), is("retiaire"));
        }

        /**
         * @see Retiaire#c_setTypeGlad(String)
         */
        @Test
        public void testC_setTypeGlad()
        {
            String s = "NouveauNOM";
            String t = Retiaire.c_getTypeGlad();
            Retiaire.c_setTypeGlad(s);
            assertThat("Retiaire.c_getTypeGlad() : Type des retiaires mal modifi�", 
                       Retiaire.c_getTypeGlad(), is(s));
            Retiaire.c_setTypeGlad(t);
        }

        /**
         * @see Retiaire#rapport()
         */
        @Test
        //        @Ignore
        public void testRapport()
        {
            fail("Ce test est d�licat � r�aliser car le format exact n'a pas �t� fix�");
        }


        /**
         * @see Retiaire#armeAutorisee(Arme)
         */
        @Test(expected = IllegalArgumentException.class)
        //    "Retiaire.armeAutorisee : Arme null ne lance pas l'exception IllegalArgumentException"
        public void testArmeAutorisee()
        {
            r.armeAutorisee(null);
        }

        /**
         * @see Retiaire#autoriserArme(Arme)
         */
        @Test(expected = IllegalArgumentException.class)
        //    "Retiaire.autoriserArme : Arme null ne lance pas l'exception IllegalArgumentException"
        public void testAutoriserArme()
        {
            Retiaire.autoriserArme(null);
        }

        /**
         * @see Retiaire#listerArmesAutorisees()
         */
        @Test
        public void testListerArmesAutorisees()
        {
            assertTrue("Retiaire.listerArmesAutorisees : liste des armes autoris�es non vide initialement", 
                       Retiaire.listerArmesAutorisees().isEmpty());
        }
        
     
        

        /**
         * @see Gladiateur#estBienPortant()
         */
        @Test
        public void testEstBienPortant()
        {
            assertTrue("Gladiateur.estBienPortant : younix devrait �tre bien portant", 
                       r.estBienPortant());
        }

        /**
         * @see Gladiateur#estBlesse()
         */
        @Test
        public void testEstBlesse()
        {
            assertFalse("Gladiateur.estBlesse : younix ne devrait pas �tre bless�", 
                       r.estBlesse());
        }

        /**
         * @see Gladiateur#estMortOuMoribond()
         */
        @Test
        public void testEstMortOuMoribond()
        {
            assertFalse("Gladiateur.estMortOuMoribond : younix ne devrait pas �tre mort", 
                       r.estMortOuMoribond());
        }

        /**
         * @see Gladiateur#getMesArmes()
         */
        @Test
        public void testGetMesArmes()
        {
            assertTrue("Gladiateur.getMesArmes : younix ne devrait pas avoir d'arme", 
                       r.getMesArmes().isEmpty());    }


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
        //    "Gladiateur.recevoirCoup : force n�gative ne lance pas l'exception IllegalArgumentException"
        public void testRecevoirCoup()
        {
            r.recevoirCoup(null, -1);
        }

        /**
         * @see Gladiateur#saluer()
         */
        @Test
        @Ignore
        public void testSaluer()
        {
            fail("Ce test est d�licat � r�aliser car le format exact n'a pas �t� fix�");
        }
        

        /**
         * @see Gladiateur#recevoirArme(Arme)
         */
        @Test(expected = IllegalArgumentException.class)
        //    "Gladiateur.recevoirArme : Arme null ne lance pas l'exception IllegalArgumentException"
        public void testRecevoirArme()
        {
            r.recevoirArme(null);
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
        //    "Retiaire.init : Identificateur n�gatif ne lance pas l'exception IllegalArgumentException"
        public void testRetiaire1()
        {
            new Retiaire(-1, "Negativix", 30, e);
        }

        @Test(expected = IllegalArgumentException.class)
        //    "Retiaire.init : Nom null ne lance pas l'exception IllegalArgumentException"
        public void testRetiaire2()
        {
            new Retiaire(1, null, 30, e);
        }

        @Test(expected = IllegalArgumentException.class)
        //    "Retiaire.init : Nom vide ne lance pas l'exception IllegalArgumentException"
        public void testRetiaire3()
        {
            new Retiaire(1, "", 30, e);
        }

        @Test(expected = IllegalArgumentException.class)
        //    "Retiaire.init : agilit� n�gative ne lance pas l'exception IllegalArgumentException"
        public void testRetiaire4()
        {
            new Retiaire(1, "Agilix", -100, e);
        }
        
        @Test(expected = IllegalArgumentException.class)
        //    "Retiaire.init : agilit� > max ne lance pas l'exception IllegalArgumentException"
        public void testRetiaire5()
        {
            new Retiaire(1, "Agilix", Retiaire.c_getAgiliteMax() + 10, e);
        }
}
