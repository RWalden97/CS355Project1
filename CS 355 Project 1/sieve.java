import java.lang.Math;
public class sieve {

    public static int sieve(int J){

        if(J <= 2){
            return 0;
        }
        if(J == 3){
            return 1;
        }
        int count = 0;
        boolean[] P = new boolean[J+1];
        P[J] = true;
        for (int i = 2; i*i <= J; i++) {
            if(!P[i]){
                for (int j = i*i; j <= J; j+=i) {
                    P[j] = true;
                }
            }
        }
        int firstFive = 5;
        int lastFive = 5;
        System.out.print("First five primes: ");
        for (int i = 2; i <= J; i++) {
            if(!P[i]){
                count++;
                if (firstFive > 0) {
                  System.out.print(i + ", ");
                  firstFive--;
                }
            }
        }
        System.out.print("\nLast five primes: ");
        for (int i = J; i >= 0; i--) {
          if(!P[i]){
              if (lastFive > 0) {
                System.out.print(i + ", ");
                lastFive--;
              }
          }
        }
        return count;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("\nNumber of primes less than or equal to 10^6: " + sieve(1000000) + "\n");
        System.out.println("\nNumber of primes less than or equal to 7^2: " + sieve(49) + ". Approximation for 7^2 primes: " + (49) / (Math.log(49)) + "\n");
        System.out.println("\nNumber of primes less than or equal to 7^3: " + sieve(343) + ". Approximation for 7^3 primes: " + (343) / (Math.log(343)) + "\n");
        System.out.println("\nNumber of primes less than or equal to 7^4: " + sieve(2401) + ". Approximation for 7^4 primes: " + (2401) / (Math.log(2401)) + "\n");
        System.out.println("\nNumber of primes less than or equal to 7^5: " + sieve(16807) + ". Approximation for 7^5 primes: " + (16807) / (Math.log(16807)) + "\n");
        System.out.println("\nNumber of primes less than or equal to 7^6: " + sieve(117649) + ". Approximation for 7^6 primes: " + (117649) / (Math.log(117649)) + "\n");
        System.out.println("\nNumber of primes less than or equal to 7^7: " + sieve(823543) + ". Approximation for 7^7 primes: " + (823543) / (Math.log(823543)) + "\n");
        long endTime   = System.nanoTime();
        System.out.println((endTime - startTime)/1000000000.0 + " seconds runtime");
    }
}
