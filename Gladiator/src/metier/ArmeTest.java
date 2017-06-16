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
        a = new Arme(1,"epee", 50, 10);
    }
    
    /**
     * @see Arme#getNom()
     */
    @Test
    public void testGetNom() {
        assertThat("Arme.GetNom() : Nom mal initialisÃ©", a.getNom(), is("epee"));
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : Nom vide ne lance pas l'exception IllegalArgumentException"
    public void testNom() {
        a = new Arme(1, "", 50, 10);
    }
    
    /**
     * @see Arme#getIda()
     */
    @Test
    public void testGetIda() {
        assertThat("Arme.GetIda() : ida mal initialisÃ©", a.getIda(), is(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : Id < 1 ne lance pas l'exception IllegalArgumentException"
    public void testIda() {
        a = new Arme(0, "epee", 50, 10);
    }

    /**
     * @see Arme#getPuissOff()
     */
    @Test
    public void testGetPuissOff() {
        assertThat("Arme.GetPuissOff() : PuissOff mal initialisÃ©", a.getPuissOff(), is(50));
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : PuisOff < 0 ne lance pas l'exception IllegalArgumentException"
    public void testPuissOff() {
        a = new Arme(1, "epee", -1, 10);
    }

    /**
     * @see Arme#getPuissDef()
     */
    @Test
    public void testGetPuissDef() {
        assertThat("Arme.GetPuissDef() : Pu_issDef mal initialisÃ©", a.getPuissDef(), is(10));
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : PuisDef vide ne lance pas l'exception IllegalArgumentException"
    public void testPuissDef() {
        a = new Arme(1, "epee", 50, -1);
    }

    /**
     * @see Arme#description()
     */
    @Test
    public void testDescription() {
        String desc = String.format("id : %-2d | nom : %-10s | Puissance Offensive : %-3d | Puissance Defensive : %-3d",
                                    1,
                                    "epee",
                                    50,
                                    10);
        assertThat("Arme.description() : description mal initialisÃ©", a.description(), is(desc));
    }
    
    @Test
    public void testDescription2() {
        Mirmillon.c_autoriserArme(a);
        String desc = String.format("id : %-2d | nom : %-10s | Puissance Offensive : %-3d | Puissance Defensive : %-3d | dispoMir",
                                    1,
                                    "epee",
                                    50,
                                    10);
        assertThat("Arme.description() : description mal initialisÃ©", a.description(), is(desc));
    }
    
    @Test
    public void testDescription3() {
        Retiaire.c_autoriserArme(a);
        String desc = String.format("id : %-2d | nom : %-10s | Puissance Offensive : %-3d | Puissance Defensive : %-3d | dispoRet",
                                    1,
                                    "epee",
                                    50,
                                    10);
        assertThat("Arme.description() : description mal initialisÃ©", a.description(), is(desc));
    }
    
    @Test
    public void testDescription4() {
        Mirmillon.c_autoriserArme(a);
        Retiaire.c_autoriserArme(a);
        String desc = String.format("id : %-2d | nom : %-10s | Puissance Offensive : %-3d | Puissance Defensive : %-3d | dispoMir | dispoRet",
                                    1,
                                    "epee",
                                    50,
                                    10);
        assertThat("Arme.description() : description mal initialisÃ©", a.description(), is(desc));
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : id null ne lance pas l'exception IllegalArgumentException"
    public void testArme() {
        a = new Arme(null, "epee", 50, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : nom null ne lance pas l'exception IllegalArgumentException"
    public void testArme2() {
        a = new Arme(1,null, 50, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : puisOff null ne lance pas l'exception IllegalArgumentException"
    public void testArme3() {
        a = new Arme(1,"eepe", null, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : puisDef null ne lance pas l'exception IllegalArgumentException"
    public void testArme4() {
        a = new Arme(1,"eepe", 50, null);
    }
}