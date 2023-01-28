package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A test that will create a player and test that it is alive.
 *
 * @author Eric Martinez
 */
public class PlayerTest
{
    private Player player;

    @BeforeEach
    void setUp() {
        // Create a new pacman before each test.
        PacManSprites sprites = new PacManSprites();
        PlayerFactory factory = new PlayerFactory(sprites);
        player = factory.createPacMan();
    }

    @Test
    void testAlive() {
        assertThat(player.isAlive()).isTrue();
    }

    @Test
    void testSetAlive() {
        // Try killing the player and see if the .alive function gets set.
        player.setAlive(false);

        assertThat(player.isAlive()).isFalse();

        // Now we test to see if it will give us the same result if we pass true.

        player.setAlive(true);

        assertThat(player.isAlive()).isTrue();
        // Since this gets set in the setAlive function when we pass true, we want to test this.
        assertThat(player.getKiller()).isNull();

    }

    @Test
    void testAddPoints() {
        // Test the add points method in Player.
        player.addPoints(130);

        assertThat(player.getScore()).isEqualTo(130);

        // Test passing a negative int as well.
        player.addPoints(-10);

        assertThat(player.getScore()).isEqualTo(120);
    }

}
