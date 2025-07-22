package bowling;

import org.junit.jupiter.api.Test;

public class BowlingTest {

    @Test
    void canCreateGame() {
        Game game = new Game();
    }

    @Test
    void canRoll() {
        Game game = new Game();
        game.roll(0);
    }
}
