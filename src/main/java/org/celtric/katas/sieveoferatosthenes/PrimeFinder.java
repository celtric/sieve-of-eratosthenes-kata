package org.celtric.katas.sieveoferatosthenes;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {

    static final int UNCHECKED = 0;
    static final int PRIME = 1;
    static final int NOT_PRIME = 2;

    int[] primeCandidates;

    public int[] findPrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        primeCandidates = new int[limit + 1];

        for (int i = 2; i <= limit; i++) {
            if (primeCandidates[i] != UNCHECKED) {
                continue;
            }

            primes.add(i);
            primeCandidates[i] = PRIME;
            disableMultiplesOf(i);
        }

        return toArray(primes);
    }

    private static int[] toArray(List<Integer> anArray) {
        return anArray.stream().mapToInt(i -> i).toArray();
    }

    private void disableMultiplesOf(int i) {
        for (int n = i + 1; n < primeCandidates.length; n++) {
            if (n % i == 0) {
                primeCandidates[n] = NOT_PRIME;
            }
        }
    }
}
