package spaveinvaders;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceinvaders.domain.Player;

public class PlayerTest {
    
    private Player p;

    @Before
    public void setUp() {
        p = new Player(1,1,1);
    }

    @Test
    public void should_return_false(){
        assertFalse(p.MoveRight());
        assertFalse(p.MoveLeft());
    }
}
