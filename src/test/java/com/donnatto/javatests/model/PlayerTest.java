package com.donnatto.javatests.model;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    // Test cuando el jugador pierda
    @Test
    public void loosesWhenDiceNumberIsTooLow() {

        // Simulamos crear una instancia del dado con mockito
        Dice dice = Mockito.mock(Dice.class);
        // Simulamos el resultado del metodo a llamar
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 5);
        assertFalse(player.play());
    }

    // Test cuando el jugador gane
    @Test
    public void loosesWhenDiceNumberIsBig() {

        // Simulamos crear una instancia del dado con mockito
        Dice dice = Mockito.mock(Dice.class);
        // Simulamos el resultado del metodo a llamar
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
}