package practice;

import static java.lang.Math.sqrt;

public class SieveOfEratosthenes {
    public static void main(String[] args) {

        //An algorithm to find the subset of all primes < a max bound
        int max = 120;
        boolean[] isPrime = new boolean[max]; //'isPrime[i]' will be true where 'i' is prime

        //Set all but {0,1} true by default
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2; i < max; i++) {
            isPrime[i]=true;
        }


        for(int i=2; i < sqrt(max); i++) {
            if(isPrime[i]) {
                //'isPrime[i]' is now only true if 'i' is not a multiple of any primes before it
                for(int j=i*2; j < max; j+=i) {
                    //'i' is prime, so make false all multiples of 'i'
                    isPrime[j]=false;
                }
            }
        }

        //Print our subset of primes
        for(int i=0; i < isPrime.length; i++) {
            if(isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
