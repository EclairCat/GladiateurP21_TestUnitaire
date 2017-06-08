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
        assertThat("Ethnie.GetIde() : ide mal initialisé", e.getIde(), is(1));
    }

    /**
     * @see Ethnie#getNom()
     */
    @Test
    public void testGetNom() {
        assertThat("Ethnie.GetNom() : Nom mal initialisé", e.getNom(), is("Nom"));
    }

    /**
     * @see Ethnie#getListeGladiateur()
     */
    @Test
    public void testGetListeGladiateur() {
        assertTrue("Ethnie.getListeGladiateur : liste des gladiateur non vide",e.getListeGladiateur().isEmpty());
    }

    /**
     * @see Ethnie#getScore()
     */
    @Test
    public void testGetScore() {
        assertThat("Ethnie.GetScore() : Score mal Calculé", e.getScore(), is(0));
    }

    /**
     * @see Ethnie#ajouterGladiateur(Gladiateur)
     */
    @Test
    public void testAjouterGladiateur() {
        e.ajouterGladiateur(r);
        assertThat("Ethnie.AjouterGladiateur() : Gladiateur non ajouter", e.getListeGladiateur().size(), is(1));
    }
    
}
