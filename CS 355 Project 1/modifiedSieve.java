import java.lang.Math;

public class modifiedSieve {

    public static int modifiedSieve(int I, int J){

        int L = (int)Math.sqrt(J); //for Part B
        //int L = 1000; for Part C
        int count = 0;
        boolean[] P = new boolean[L+1];
        P[1] = true;
        for (int i = 2; i*i <= L; i++) {
            if(!P[i]){
                for (int j = i*i; j <= L; j+=i) {

                    P[j] = true;
                }
            }
        }
        int[] A = new int[1000000 + 1];
        for(int i = 0; i < 1000000; i++) {
          A[i]=1;
        }
        A[0] = 0;
        int p;
        for (p=1; p <= L; p++) {
          if (!P[p]) {
            int i = I/p;
             i = (i + 1) * p;
        //  System.out.println(p);
          //System.out.println(J);
            if (p == 1)
              System.out.println(i);
            while (i < J) {
            //System.out.println("stuck there");
            //System.out.println(i);
              A[i - I] = 0;
              i = i + p;
            }
          }
        }
        int firstFive = 5;
        int lastFive = 5;
        System.out.print("First five primes: ");
        for (int i = I; i < J; i++) {
          if(A[i - I] == 1){
              count++;
              if (firstFive > 0) {
                System.out.print(i + ", ");
                firstFive--;
              }
          }
        }
        System.out.print("\nLast five primes: ");
        for (int i = J; i >= I; i--) {
          if(A[i - I] == 1){
              if (lastFive > 0) {
                System.out.print(i + ", ");
                lastFive--;
              }
          }
        }

        return count;
      }

    public static void main(String[] args) {
        //System.out.println(((int)Math.pow(10, 6) + (int)Math.pow(10, 8)));
        long startTime = System.nanoTime();
        System.out.println("\nNumber of primes between 10^9 and 10^9 + 10^6: " + modifiedSieve(1000000000, 1001000000 ) + "\n");
        System.out.println("Approximation for number of primes between 10^9 and 10^9 + 10^6: " + (1001000000/(Math.log(1001000000)) - (1000000000)/(Math.log(1000000000))) + "\n");
        long endTime   = System.nanoTime();
        System.out.println((endTime - startTime)/1000000000.0 + " seconds runtime");
    }
}
