package org.celtric.katas.sieveoferatosthenes;

public class PrimeFinder {

    static final int UNCHECKED = 0;
    static final int PRIME = 1;
    static final int NOT_PRIME = 2;

    int[] primeCandidates;

    public int[] findPrimes(int limit) {
        primeCandidates = new int[limit + 1];

        for (int i = 2; i <= limit; i++) {
            if (primeCandidates[i] != UNCHECKED) {
                continue;
            }

            primeCandidates[i] = PRIME;
            disableMultiplesOf(i);
        }

        return new int[]{};
    }

    private void disableMultiplesOf(int i) {
        for (int n = i + 1; n < primeCandidates.length; n++) {
            if (n % i == 0) {
                primeCandidates[n] = NOT_PRIME;
            }
        }
    }
}
