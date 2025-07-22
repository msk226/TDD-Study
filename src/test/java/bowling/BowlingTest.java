package bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingTest {

    private Game game;
    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void canRoll() {
        game.roll(0);
    }

    @Test
    void gutterGame() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        Assertions.assertEquals(0, game.getScore());
    }
}
