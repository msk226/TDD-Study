package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingTest {

    private Game game;
    @BeforeEach
    void setUp() {
        game = new Game();
    }
    @Test
    void canCreateGame() {
    }

    @Test
    void canRoll() {
        game.roll(0);
    }


}
