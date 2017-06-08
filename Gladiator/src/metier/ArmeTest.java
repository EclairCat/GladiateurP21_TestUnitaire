package metier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ArmeTest {
    
    private Arme a;
    
    @Before
    public void setUp(){
        a = new Arme(1,"eepe", 50, 10);
    }
    
    /**
     * @see Arme#getNom()
     */
    @Test
    public void testGetNom() {
        assertThat("Arme.GetNom() : Nom mal initialisé", a.getNom(), is("eepe"));
    }

    /**
     * @see Arme#getIda()
     */
    @Test
    public void testGetIda() {
        assertThat("Arme.GetIda() : ida mal initialisé", a.getIda(), is(1));
    }

    /**
     * @see Arme#getPuissOff()
     */
    @Test
    public void testGetPuissOff() {
        assertThat("Arme.GetPuissOff() : PuissOff mal initialisé", a.getPuissOff(), is(50));
    }

    /**
     * @see Arme#getPuissDef()
     */
    @Test
    public void testGetPuissDef() {
        assertThat("Arme.GetPuissDef() : Pu_issDef mal initialisé", a.getPuissDef(), is(10));
    }

    /**
     * @see Arme#description()
     */
    @Test
    public void testDescription() {
        assertThat("Arme.description() : description mal initialisé", a.description(), is(a.description()));
    }
}
