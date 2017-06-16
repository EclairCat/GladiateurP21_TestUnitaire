package metier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EthnieTest {
    
    private Ethnie e;
    private Retiaire r;
    private Mirmillon m;
    
    @Before
    public void setUp() {
        e = new Ethnie(1,"Nom");
        r = new Retiaire(1,"bob",50);
        m = new Mirmillon(2,"pit",60);
    }
    

    /**
     * @see Ethnie#getIde()
     */
    @Test
    public void testGetIde() {
        assertThat("Ethnie.GetIde() : ide mal initialisÃ©", e.getIde(), is(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIde() {
        e = new Ethnie(0, "Nom");
    }

    /**
     * @see Ethnie#getNom()
     */
    @Test
    public void testGetNom() {
        assertThat("Ethnie.GetNom() : Nom mal initialisÃ©", e.getNom(), is("Nom"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNom() {
        e = new Ethnie(1, "");
    }


    /**
     * @see Ethnie#getListeGladiateur()
     */
    @Test
    public void testGetListeGladiateur() {
        assertTrue("Ethnie.getListeGladiateur : liste des gladiateur non vide",e.getListeGladiateur().isEmpty());
    }
    
    @Test
    public void testGetListeGladiateur2() {
        e.ajouterGladiateur(m);
        assertTrue("Ethnie.getListeGladiateur : liste des gladiateur ne contient pas le mirmillon", e.getListeGladiateur().contains(m));
    }

    /**
     * @see Ethnie#getScore()
     */
    @Test
    public void testGetScore() {
        assertThat("Ethnie.GetScore() : Score mal CalculÃ©", e.getScore(), is(0));
    }
    
    @Test
    public void testGetScore2() {
        e.ajouterGladiateur(m);
        assertThat("Ethnie.GetScore() : Score mal CalculÃ©", e.getScore(), is(10));
    }

    /**
     * @see Ethnie#ajouterGladiateur(Gladiateur)
     */
    @Test
    public void testAjouterGladiateur() {
        e.ajouterGladiateur(r);
        assertThat("Ethnie.AjouterGladiateur() : Gladiateur non ajouter", e.getListeGladiateur().size(), is(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Ethnie.init : id null ne lance pas l'exception IllegalArgumentException"
    public void testEthnie() {
        e = new Ethnie(null, "Nom");
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Ethnie.init : nom null ne lance pas l'exception IllegalArgumentException"
    public void testEthnie2() {
        e = new Ethnie(1, null);
    }
}