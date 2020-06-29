package dp.factorials;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    long [] factorials;

    public TestClass() {
        factorials = new long[10000];
        Arrays.fill(factorials, 0);
    }

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */

        //Scanner
        Scanner s = new Scanner(System.in);
        /* String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        TestClass test = new TestClass();
        int t = Integer.parseInt(s.nextLine());
        int[] num = new int[t];
        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(s.nextLine());
        }

        for (int i = 0; i < t; i++) {
            System.out.println(test.factorial(num[i]));
        }
    }

    public long factorial(int n) {
        if (factorials[n] != 0) {
            return factorials[n];
        }
        if (n <= 1) {
            factorials[n] = 1;
            return factorials[n];
        }
        for (int i = 2; i <= n; i++) {
            if (factorials[i] == 0) {
                factorials[i] = factorials[i - 1] * i;
            }
        }
        return factorials[n];
    }
}
