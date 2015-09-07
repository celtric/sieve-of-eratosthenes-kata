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

    @Test
    public void it_discards_composites_of_2() {
        finder.findPrimes(10);

        assertEquals(PrimeFinder.PRIME, finder.primeCandidates[2]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[4]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[6]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[8]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[10]);
    }

    @Test
    public void it_discards_all_composites() {
        finder.findPrimes(10);

        assertEquals(PrimeFinder.PRIME, finder.primeCandidates[2]);
        assertEquals(PrimeFinder.PRIME, finder.primeCandidates[3]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[4]);
        assertEquals(PrimeFinder.PRIME, finder.primeCandidates[5]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[6]);
        assertEquals(PrimeFinder.PRIME, finder.primeCandidates[7]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[8]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[9]);
        assertEquals(PrimeFinder.NOT_PRIME, finder.primeCandidates[10]);
    }

    @Test
    public void it_finds_prime_numbers_up_to_5() {
        assertArrayEquals(new int[]{2, 3, 5}, finder.findPrimes(5));
    }

    @Test
    public void it_finds_prime_numbers_up_to_10() {
        assertArrayEquals(new int[]{2, 3, 5, 7}, finder.findPrimes(10));
    }

    @Test
    public void it_finds_prime_numbers_up_to_100() {
        int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        assertArrayEquals(expected, finder.findPrimes(100));
    }
}
