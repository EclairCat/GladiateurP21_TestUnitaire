package packglad;

import java.util.ArrayList;

import java.util.NoSuchElementException;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import packglad.GEthnie;


public class FacadeTest {   
    
    @Before
    public void setUp(){
        Facade.lancerJeu();
    }
    
    
    
    /**
     * @see Facade#creerRetiaire(String,Integer,Integer)
     */
    @Test
    public void testCreerRetiaire() {   
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
               
        assertThat("Le nom est faux", Facade.nomDuGladiateur(1), is("bob"));
        assertThat("L'agilité est faux", Facade.agiliteRetiaire(1), is(30));
        
        
    }

    /**
     * @see Facade#creerMirmillon(String,Integer,Integer)
     */
    @Test
    public void testCreerMirmillon() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("pedro", 50, 1);
        assertThat("Le nom est faux", Facade.nomDuGladiateur(1), is("pedro"));
        assertThat("Le poids est faux", Facade.poidsMirmillon(1), is(50));
    }
    

    /**
     * @see Facade#listerGladiateursDEthnie(Integer)
     */
    @Test
    public void testListerGladiateursDEthnie() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("pedro", 50, 1);
        assertFalse("le Gladiateur n'est pas dans la bonne ethnie", Facade.listerGladiateursDEthnie(1).isEmpty());
    }
    
    
    @Test
    public void test_identifiant(){   
        
        Facade.creerEthnie("Test");
        for(int i=0; i<10; i++) {
            Facade.creerRetiaire("nom"+i, 30, 1);
        }
        
        for(int i=1; i<=10; i++){
            assertThat("Identifiant mal mis",((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(i-1), is(i));
        }
        
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerGladiateur(){
        Facade.creerRetiaire("math", null, 1);        
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerGladiateur2(){
        Facade.creerRetiaire("math", 50, null);        
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerGladiateur3(){
        Facade.creerRetiaire(null, 50, 1);        
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerGladiateur4(){
        Facade.creerMirmillon(null, 20, 1);        
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerGladiateur5(){
        Facade.creerMirmillon("math", null, 1);        
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerGladiateur6(){
        Facade.creerMirmillon("math", 20, null);        
    }
    
    @Test
    public void test_identifiant2() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        int bob = ((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(0);        
        assertThat("Mauvais Identifiant", Facade.nomDuGladiateur(bob), is("bob"));
    }
    
    /**
     * @see Facade#listerTousGladiateurs()
     */
    @Test
    public void testListerTousGladiateurs() {
        assertTrue("Lister Glad n'est pas vide", Facade.listerTousGladiateurs().isEmpty());
    }
    
    @Test
    public void testListerTousGladiateurs2() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 50, 1);
        
        assertThat("Lister Glad est vide", Facade.listerTousGladiateurs().size(), is(1));
        assertThat("C'est pas le bon gladiateur qui est ajouter",((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(0),is(1));
    }
    
    @Test
    public void testListerTousGladiateurs3() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 50, 1);
        Facade.creerRetiaire("mec", 50, 1);
        
        assertThat("Lister Glad est vide", Facade.listerTousGladiateurs().size(), is(2));
        assertThat("C'est pas les bon gladiateurs qui est ajouter",((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(0),is(1));
        assertThat("C'est pas les bon gladiateurs qui est ajouter",((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(1),is(2));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerArme1(){
        Facade.creerUneArme("", 30, 0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerArme2(){
        Facade.creerUneArme("epee", null, 0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerArme3(){
        Facade.creerUneArme("epee", 0, null);
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerArme4(){
        Facade.creerUneArme("epee", -5, 0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerArme5(){
        Facade.creerUneArme("epee", 0, -60);
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_CreerArme6(){        
        Facade.creerUneArme("epee", 0, 70);
        Facade.creerUneArme("epee", 50, 0);
    }
    
    @Test
    public void test_ListerArmeR() {
        assertTrue("liste non vide", Facade.listerArmesDispoRetiaire().isEmpty());
    }
    
    @Test
    public void test_ListerArmeM() {
        assertTrue("liste non vide", Facade.listerArmesDispoMirmillon().isEmpty());
    }
    
    
    @Test
    public void test_ListerArmeR2() {
        Facade.creerUneArme("epee", 30, 0);
        Facade.autoriserArmeAuxRetiaires(1);
        assertThat("liste  vide", Facade.listerArmesDispoRetiaire().size(), is(1));
    }
    
    @Test
    public void test_ListerArmeMR() {
        Facade.creerUneArme("epee", 30, 0);
        Facade.autoriserArmeAuxMirmillons(1);
        Facade.autoriserArmeAuxRetiaires(1);
        assertThat("liste  vide", Facade.listerArmesDispoRetiaire().size(), is(1));
        assertThat("liste  vide", Facade.listerArmesDispoMirmillon().size(), is(1));
        
    }
    
    /*
     * Test Donner Arme
     */
    
    @Test (expected = NoSuchElementException.class)
    public void test_donnerarme() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.donnerUneArme(1, 1);
    }
    
    @Test 
    public void test_donnerarme2() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("epee", 30, 0);
        Facade.autoriserArmeAuxRetiaires(1);
        
        Facade.donnerUneArme(1, 1);
       
        
        assertFalse("la liste est vide", Facade.listerArmesDispoRetiaire().isEmpty());
        assertFalse("la liste est vide", Facade.declarerArmes(1).isEmpty());
        assertThat("le gladiateur n'a pas d'arme", ((ArrayList<Integer>)Facade.declarerArmes(1)).get(0), is(1));
        assertThat("Le gladiateur a plusieur ou n'a pas d'arme", Facade.declarerArmes(1).size(), is(1));
    }
    
    @Test 
    public void test_donnerarme3() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("epee", 30, 0);        
        Facade.donnerUneArme(1, 1);
               
        assertTrue("la liste est vide", Facade.listerArmesDispoRetiaire().isEmpty());
        assertTrue("la liste est vide", Facade.declarerArmes(1).isEmpty());
    
    }
    
    @Test 
    public void test_donnerarme4() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("epee", 30, 0);
        Facade.autoriserArmeAuxRetiaires(1);
        
        Facade.donnerUneArme(1, 1);
        Facade.donnerUneArme(1, 1);
        
        assertFalse("la liste est vide", Facade.listerArmesDispoRetiaire().isEmpty());
        assertFalse("la liste est vide", Facade.declarerArmes(1).isEmpty());
        assertThat("le gladiateur n'a pas d'arme", ((ArrayList<Integer>)Facade.declarerArmes(1)).get(0), is(1));
        assertThat("Le gladiateur a plusieur ou n'a pas d'arme", Facade.declarerArmes(1).size(), is(1));
    }
    
    @Test 
    public void test_donnerarme5() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("epee", 30, 0);
        Facade.creerUneArme("bouclier", 0, 10);
        Facade.autoriserArmeAuxRetiaires(1);
        Facade.autoriserArmeAuxRetiaires(2);
        
        Facade.donnerUneArme(1, 1);
        Facade.donnerUneArme(2, 1);
        
        assertFalse("la liste est vide", Facade.listerArmesDispoRetiaire().isEmpty());
        assertFalse("la liste est vide", Facade.declarerArmes(1).isEmpty());
        assertThat("le gladiateur n'a pas l'épée", ((ArrayList<Integer>)Facade.declarerArmes(1)).get(0), is(1));
        assertThat("le gladiateur n'a pas le bouclier", ((ArrayList<Integer>)Facade.declarerArmes(1)).get(1), is(2));
        assertThat("Le gladiateur a plusieur ou n'a pas d'arme", Facade.declarerArmes(1).size(), is(2));
    }
    
    /*
     * Test Desarmer
     */
    
    @Test (expected = NoSuchElementException.class)
    public void test_desarmer1() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.desarmer(1, 5);         
        
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_desarmer2() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("pique", 20, 0);
        
        Facade.desarmer(1, 1);         
        
    }
    
    @Test 
    public void test_desarmer3() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("pique", 20, 0);
        Facade.autoriserArmeAuxRetiaires(1);
        Facade.donnerUneArme(1, 1);
        
        Facade.desarmer(1, 1);   
        
        assertTrue("Le glad a toujours l'arme sur lui!",Facade.declarerArmes(1).isEmpty());
        
    }
    
    /*
     * Test Frappper
     * 
     */
    
    @Test 
    public void test_frapper1() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("pique", 20, 0);
        Facade.autoriserArmeAuxRetiaires(1);
        Facade.donnerUneArme(1, 1);
        
        Facade.creerMirmillon("victime",50,1);
        Facade.frapper(1, 2, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(2), is(150));
        
    }
    
    @Test 
    public void test_frapper2() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("pique", 20, 0);
        Facade.autoriserArmeAuxMirmillons(1);
               
        Facade.creerMirmillon("victime",60,1);
        Facade.donnerUneArme(1, 2);
        Facade.frapper(2, 1, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(1), is(150));
        
    }
    
    @Test 
    public void test_frapper3() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("pique", 20, 0);
        Facade.creerUneArme("boubou", 0, 20);
        Facade.autoriserArmeAuxRetiaires(1);
        Facade.autoriserArmeAuxMirmillons(2);
        Facade.donnerUneArme(1, 1);
        
        Facade.creerMirmillon("victime",50,1);
        Facade.donnerUneArme(2, 2);
        Facade.frapper(1, 2, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(2), is(170));
        
    }
    
    @Test 
    public void test_frapper4() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("pique", 20, 0);
        Facade.creerUneArme("Filet", 0, 30);
        Facade.autoriserArmeAuxMirmillons(1);
        Facade.autoriserArmeAuxRetiaires(2);
        
        Facade.donnerUneArme(2,1);
               
        Facade.creerMirmillon("victime",60,1);
        Facade.donnerUneArme(1, 2);
        Facade.frapper(2, 1, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(1), is(180));
        
    }
    
    @Test 
    public void test_frapper6() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 50, 1);
        Facade.creerMirmillon("victime", 20,1);
        
        Facade.creerUneArme("pique", 20, 0);
        Facade.autoriserArmeAuxMirmillons(1);     
        
        Facade.donnerUneArme(1,2);
        Facade.frapper(2, 1, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(1), is(170));
        
    }
    
    @Test 
    public void test_frapper7() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("megabouclier", 0, 100);
        Facade.autoriserArmeAuxMirmillons(1);
               
        Facade.creerMirmillon("victime",60,1);
        Facade.donnerUneArme(1, 1);
        Facade.frapper(2, 1, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(1), is(200));
        
    }
    
    @Test 
    public void test_frapper8() {
        Facade.creerEthnie("test");
        Facade.creerUneArme("punch", 50, 0);
        Facade.autoriserArmeAuxMirmillons(1);               
        Facade.creerMirmillon("victime",60,1);
        Facade.donnerUneArme(1, 1);
        Facade.frapper(1, 1, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(1), is(120));
        
    }
    
    @Test 
    public void test_frapper9() {
        Facade.creerEthnie("test");
        Facade.creerUneArme("falconpunch", 200, 0);
        Facade.autoriserArmeAuxMirmillons(1);               
        Facade.creerMirmillon("victime",10,1);
        Facade.donnerUneArme(1, 1);
        Facade.frapper(1, 1, 1);
        //he's dead
        
        Facade.creerMirmillon("yay",50,1);
        Facade.frapper(1, 2, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(1), is(0));
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(2), is(200));
        
    }
    
    /*
     * Liste Agresseur
     */
    
    @Test
    public void test_listeAgresseur1() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerMirmillon("pad", 60, 1);
        Facade.creerUneArme("bof", 10, 0);
        Facade.autoriserArmeAuxRetiaires(1);
        Facade.donnerUneArme(1, 2);
        Facade.frapper(2, 1, 1);
        assertTrue("Retiaire renvoie ses aggresseurs", Facade.listerAgresseurs(1).isEmpty());
    }
    
    @Test
    public void test_listeAgresseur2() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 30, 1);
        Facade.creerMirmillon("pad", 60, 1);
        Facade.creerUneArme("bof", 10, 0);
        Facade.autoriserArmeAuxMirmillons(1);
        Facade.donnerUneArme(1, 2);
        Facade.frapper(2, 1, 1);
        assertFalse("le mirmillon victime n'a pas d'agresseur", Facade.listerAgresseurs(1).isEmpty());
        assertThat("le mirmillon agresseur a d'agresseur", Facade.listerAgresseurs(2).size(), is(0));
    }
    
    @Test
    public void test_listeAgresseur3() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 30, 1);
        Facade.creerMirmillon("pad", 60, 1);
        Facade.creerUneArme("bof", 10, 0);
        Facade.autoriserArmeAuxMirmillons(1);
        Facade.donnerUneArme(1, 2);
        Facade.frapper(2, 1, 1);
        Facade.frapper(2, 1, 1);
        assertThat("le mirmillon victime a plusieur fois le même agresseur", Facade.listerAgresseurs(1).size(), is(1));
        
    }
    
    @Test
    public void test_listeAgresseur4() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 30, 1);
        Facade.creerUneArme("bof", 10, 0);
        Facade.autoriserArmeAuxMirmillons(1);
        Facade.donnerUneArme(1, 1);
        Facade.frapper(1, 1, 1);
        assertThat("le mirmillon victime ne se compte pas comme agresseur", Facade.listerAgresseurs(1).size(), is(1));
        
    }
    
    /*
     * Test Suppriemr Glad
     */
    
    @Test
    public void test_suprimerGlad1() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 30, 1);
        Facade.creerMirmillon("toby", 30, 1);
        
        Facade.supprimerGlad(1);
        assertThat("il y a toujours 2 gladiateur", Facade.listerTousGladiateurs().size(), is(1));
        Facade.supprimerGlad(2);
        assertThat("il y a toujours 1 gladiateur", Facade.listerTousGladiateurs().size(), is(0));
        
    }
    
    @Test
    public void supprimerGlad2() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 30, 1);
        Facade.creerMirmillon("pad", 60, 1);
        Facade.creerUneArme("bof", 10, 0);
        Facade.autoriserArmeAuxMirmillons(1);
        Facade.donnerUneArme(1, 2);
        Facade.frapper(2, 1, 1);
        
        Facade.supprimerGlad(2);
        assertThat("il y a toujours 2 gladiateur", Facade.listerTousGladiateurs().size(), is(1));
        assertThat("L'agresseur existe toujours", Facade.listerAgresseurs(1).size(), is(0));
        
        
    }
    
    
    /*
     * Test Jeu d'essai
     */
    
    @Test
    public void test_jeudessai() {
        Facade.lancerJeuDEssai();
        assertThat("Nombe de Ethnie faux", Facade.listerEthnies().size(), is(3));
        assertThat("Nombe de gladiateur faux", Facade.listerTousGladiateurs().size(), is(6));
        assertThat("Nombe de arme faux", Facade.listerArmes().size(), is(6));
        
        
    }
    
}
