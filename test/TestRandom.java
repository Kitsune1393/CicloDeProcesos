/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author william
 */
public class TestRandom {

    public TestRandom() {

    }

    @Test
    public void testRandom() {
        double inicio = 10;
        double fin = 100;
        for (int i = 0; i < 100; i++) {
            System.out.println((Math.random() * (fin - inicio)) + inicio);
        }
    }

}
