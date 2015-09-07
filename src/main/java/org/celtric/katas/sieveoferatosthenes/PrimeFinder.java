package org.celtric.katas.sieveoferatosthenes;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {

    static final int UNCHECKED = 0;
    static final int NOT_PRIME = 1;

    public int[] findPrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        int[] primeCandidates = new int[limit + 1];

        for (int i = 2; i <= limit; i++) {
            if (primeCandidates[i] != UNCHECKED) {
                continue;
            }

            primes.add(i);
            disableMultiples(primeCandidates, i);
        }

        return toArray(primes);
    }

    private static int[] toArray(List<Integer> anArray) {
        return anArray.stream().mapToInt(i -> i).toArray();
    }

    private void disableMultiples(int[] candidates, int i) {
        for (int n = i * 2; n < candidates.length; n += i) {
            candidates[n] = NOT_PRIME;
        }
    }
}
