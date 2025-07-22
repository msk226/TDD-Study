package bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        rollMany(20, 0);
        assertEquals(0, game.getScore());
    }

    @Test
    void allOnes() {
        rollMany(20, 1);
        assertEquals(20, game.getScore());
    }

    @Test
    void oneSpare() {
        game.roll(5);
        game.roll(5); // spare
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.getScore());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}
