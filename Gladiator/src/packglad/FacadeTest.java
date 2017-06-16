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
    
    
        /*
         * Retiaire vérifier ue ses 
         * attributs correspondent aux valeurs passées en paramètre.
         */
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
    /*
     * Mirmillon vérifier que ses 
     * attributs correspondent aux valeurs passées en paramètre.
     */

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
    
//vérifier qu'un GLadiateur figure dans la liste de gladiateurs de son ethnie. 
    /**
     * @see Facade#listerGladiateursDEthnie(Integer)
     */
    @Test
    public void testListerGladiateursDEthnie() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("pedro", 50, 1);
        assertFalse("le Gladiateur n'est pas dans la bonne ethnie", Facade.listerGladiateursDEthnie(1).isEmpty());
    }
    
    //Les identifiants de gladiateurs sont créés par incrémentation automatique à partir de 1
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
    
    //ajouter un gladiateur avec un argument en erreur. Intercepter l'exception qui en résulte. 
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
    
    
    //Ajouter un gladiateur avec des arguments corrects. Vérifier qu'il obtient l'identifiant 1.
    @Test
    public void test_identifiant2() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        int bob = ((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(0);        
        assertThat("Mauvais Identifiant", bob, is(1));
    }
    
    /**
     * @see Facade#listerTousGladiateurs()
     */
    //Vérifier que la liste des gladiateurs est vide initialement.
    @Test
    public void testListerTousGladiateurs() {
        assertTrue("Lister Glad n'est pas vide", Facade.listerTousGladiateurs().isEmpty());
    }
    
    //Ajouter un gladiateur, puis vérifier que la liste des gladiateurs a une taille de 1 et contient le gladiateur rajouté.
    @Test
    public void testListerTousGladiateurs2() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 50, 1);
        
        assertThat("Lister Glad est vide", Facade.listerTousGladiateurs().size(), is(1));
        assertThat("Bob n'est pas dans la liste", ((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(0), is(1));
        assertThat("C'est pas le bon gladiateur qui est ajouter",((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(0),is(1));
    }
    
    
    //Ajouter 2 gladiateurs, puis vérifier que la liste des gladiateurs a une taille de 2 et contient les 2 gladiateurs rajoutés.
    @Test
    public void testListerTousGladiateurs3() {
        Facade.creerEthnie("test");
        Facade.creerMirmillon("bob", 50, 1);
        Facade.creerRetiaire("mec", 50, 1);
        
        assertThat("Lister Glad est vide", Facade.listerTousGladiateurs().size(), is(2));
        assertThat("C'est pas les bon gladiateurs qui est ajouter",((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(0),is(1));
        assertThat("C'est pas les bon gladiateurs qui est ajouter",((ArrayList<Integer>)Facade.listerTousGladiateurs()).get(1),is(2));
    }
    
    /*
     * Test_CreerArme Different Parametre
     * 
     */
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
    
    /*
     * Test Liste Arme!
     */
    
    //la liste est vide initialement
    @Test
    public void test_ListerArmeR() {
        assertTrue("liste non vide", Facade.listerArmesDispoRetiaire().isEmpty());
    }
    
    //la liste est vide initialement
    @Test
    public void test_ListerArmeM() {
        assertTrue("liste non vide", Facade.listerArmesDispoMirmillon().isEmpty());
    }
    
    //une arme est bien dans la liste des Retiaire
    @Test
    public void test_ListerArmeR2() {
        Facade.creerUneArme("epee", 30, 0);
        Facade.autoriserArmeAuxRetiaires(1);
        assertThat("liste  vide", Facade.listerArmesDispoRetiaire().size(), is(1));
    }
    
    //une arme est bien dans la liste des Retiaire et Mirmillon
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
    
    //ID inexistant
    @Test (expected = NoSuchElementException.class)
    public void test_donnerarme() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.donnerUneArme(1, 1);
    }
    
    //Verifie que une arme non autorisé à un retiaire n'est pas donné
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
    
    //Verifie que une arme autorisé est bien donné
    @Test 
    public void test_donnerarme3() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("epee", 30, 0);        
        Facade.donnerUneArme(1, 1);
               
        assertTrue("la liste est vide", Facade.listerArmesDispoRetiaire().isEmpty());
        assertTrue("la liste est vide", Facade.declarerArmes(1).isEmpty());
    
    }
    
    //Vérifier que lorsqu'on donne une deuxième fois la même arme autorisée à un gladiateur, sa liste d'armes reste inchangée.
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
    
    //Vérifier que lorsqu'on donne 2 armes autorisées différentes à un gladiateur, les 2 armes sont bien en sa possession.
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
    
    //Verifie quand le porteur n'a pas d'arme
    @Test (expected = NoSuchElementException.class)
    public void test_desarmer1() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.desarmer(1, 5);         
        
    }
    
    //l'arme à enlever n'est pas une arme autorisée à ce gladiateur.
    @Test (expected = IllegalArgumentException.class)
    public void test_desarmer2() {
        Facade.creerEthnie("test");
        Facade.creerRetiaire("bob", 30, 1);
        Facade.creerUneArme("pique", 20, 0);
        
        Facade.desarmer(1, 1);         
        
    }
    
    //Donner une arme autorisée à un gladiateur, puis enlever lui cette arme. Vérifier que la liste des armes de ce gladiateur est à nouveau vide.
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
     *
     *
     * Vérifier que lorsqu'un gladiateur frappe un mirmillon 
     * désarmé, la note de vie du mirmillon est diminuée de la 
     * somme entre la force du coup de l'agresseur et la puissance offensive 
     * de l'arme choisie.
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
    
    //Vérifier que lorsqu'un gladiateur frappe un retiaire désarmé, l'agilité de la victime est prise en compte.
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
    
    //Vérifier que lorsqu'un gladiateur frappe un mirmillon armé, la puissance défensive de l'arme - ou des armes - de la victime est prise en compte.
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
    
    
    //Vérifier que lorsqu'un gladiateur frappe un rétiaire armé, la puissance défensive de l'arme - ou des armes - de la victime ainsi que son agilité sont pris en compte.
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
    
    //Vérifier que la vie d'un retiaire désarmé n'augmente pas lorsque son agilité est supérieure à la force du coup de l'agresseur.
    
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
    
    
    //Vérifier que la vie d'un gladiateur armé n'augmente pas lorsque la puissance défensive de son arme - ou des armes - est supérieure à la force du coup de l'agresseur.
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
    
    //Vérifier qu'un gladiateur peut se frapper lui-même et que dans ce cas sa note de vie est diminuée correctement.
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
    
    //Vérifier qu'un gladiateur sans vie ne peut plus frapper.
    @Test 
    public void test_frapper9() {
        Facade.creerEthnie("test");
        Facade.creerUneArme("falconpunch", 200, 0);
        Facade.autoriserArmeAuxMirmillons(1);               
        Facade.creerMirmillon("victime",10,1);
        Facade.donnerUneArme(1, 1);
        Facade.frapper(1, 1, 1); // -205 vie!
        //he's dead
        
        Facade.creerMirmillon("yay",50,1);
        Facade.frapper(1, 2, 1);
        
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(1), is(0));
        assertThat("le calcul de la vie est faux",Facade.vieGladiateur(2), is(200));
        
    }
    
    /*
     * Liste Agresseur
     */
    //Vérifier qu'un rétiaire ne renvoie "rien" (à définir) pour cette fonction 
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
    
    //Vérifier que lorsqu'un mirmillon frappe un autre mirmillon, l'agresseur est ajouté à la liste des agresseurs de la victime et la liste des agresseurs de l'agresseur reste inchangée.
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
    
    
    //Vérifier que lorsqu'un gladiateur frappe un mirmillon plusieurs fois, l'agresseur n'est pas ajouté plusieurs fois à la liste des agresseurs de la victime.
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
    
    
    //érifier qu'un mirmillon peut se frapper lui-même et que dans ce cas il est rajouté dans sa propre liste d'agresseurs.
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
     *
     *Ajouter 2 gladiateurs, puis vérifier 
     * qu'après la suppression du premier la liste des gladiateurs 
     * ne contient plus que le second ; supprimer le second et vérifier 
     * que la liste des gladiateurs est devenue vide.
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
    
    
    /*
     * 
     * Ajouter 2 mirmillons ; le premier frappe le second. Vérifier 
     * qu'après la suppression du premier mirmillon, la liste des agresseurs 
     * du second est vide.
     */
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
    //Vérifier que le jeu d'essai est correctement créé.
    @Test
    public void test_jeudessai() {
        Facade.lancerJeuDEssai();
        assertThat("Nombe de Ethnie faux", Facade.listerEthnies().size(), is(3));
        assertThat("Nombe de gladiateur faux", Facade.listerTousGladiateurs().size(), is(6));
        assertThat("Nombe de arme faux", Facade.listerArmes().size(), is(6));
        
        
    }
    
}
