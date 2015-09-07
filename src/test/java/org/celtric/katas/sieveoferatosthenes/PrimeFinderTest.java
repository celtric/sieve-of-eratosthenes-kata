package org.celtric.katas.sieveoferatosthenes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeFinderTest {

    private PrimeFinder finder;

    @Before
    public void setUp() {
        finder = new PrimeFinder();
    }

    @Test
    public void it_returns_an_array_of_integers() {
        assertArrayEquals(new int[]{}, finder.findPrimes(0));
    }
}
