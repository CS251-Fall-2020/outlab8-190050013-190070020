import java.util.Scanner;
import java. util. *;
import java.util.stream. *;
import java.lang.Math; 

// public class Sieve {
// 	public static void main(String args[]) {
// 		Scanner in = new Scanner(System.in); 
//     int n = in.nextInt();
//     Integer[] values = new Integer[n-1];
// 		IntStream.range(1,n).forEach(val -> values[val-1] = val+1);
// 		Integer[] newValues = values;
// 		int k=2;
// 		for(int i=2; i<=Math.sqrt(n); i++) {
// 			newValues = Arrays.stream(newValues).filter(x -> x<k*k || x>=k*k && x%k!=0).toArray(Integer[]::new);
// 			for(int a: newValues) {
// 				System.out.println(a);
// 			}
// 			break;
// 		}
// 	}
// }

class Sieve {
	private static void setFalse(int x, boolean[] prime, int n) {
		IntStream.iterate(x * x, factor -> factor + x).limit(n/x - x + 1).forEach(factor -> prime[factor] = false);
	}
	public static List<Integer> sieve(int n) {
    if (n <= 1) return Arrays.asList();
    boolean[] isPrime = new boolean[n + 1];

    IntStream.range(0, n + 1).forEach(i -> isPrime[i] = true);
    IntStream.range(2, (int) Math.sqrt(n) + 1).filter(x -> prime[x]).forEach(x -> setFalse(x, prime, n));
    List<Integer> primeList = new ArrayList<>();
    IntStream.rangeClosed(2, n).filter(x -> prime[x]).forEach(primeList::add);
    return primeList;
	}

  public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
    List<Integer> l = sieveOfEratosthenes(n);
    
    IntStream.range(0, l.size()).forEach(x -> System.out.print(l.get(x)+" "));
    System.out.println();
	}
}