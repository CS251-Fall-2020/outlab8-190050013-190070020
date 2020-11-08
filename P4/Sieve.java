import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.function.*;
import java.util.stream.Collectors;

class Sieve
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    if(N <= 1)
    {
      return;
    }
    else if(N == 2)
    {
      System.out.println("2");
      return;
    }

    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime,true);
    isPrime[0] = false;
    isPrime[1] = false;

    IntStream s = IntStream.range(2,N + 1);
    StringBuilder ans = new StringBuilder("");

    Function<Integer,Integer> setFalse = n -> {
      if(n <= N)
      {
        isPrime[n] = false;
      }
      return n;
    };

    IntPredicate process = p -> {
      if(isPrime[p])
      {
        String str = p + " ";
        ans.append(str);
        if((p * p) <= N)
        {
          isPrime[p * p] = false;
          IntStream val = IntStream.range(p, (N/p) + 1);
          val.map(x -> p * x).reduce(
          (a,b) -> setFalse.apply(b));
        }
        return true;
      }
      return false;
    };


    int[] p = s.filter(process).toArray();
    //System.out.println(Arrays.toString(p));
    System.out.println(ans);
    //.collect(Collectors.toList());

    //System.out.println(p);
    //ArrayList<Integer> primes =  new ArrayList<Integer>(0);

    /*boolean[] isComposite = new boolean[N + 1];
    primes.add(2);
    isComposite[0] = true;
    isComposite[1] = true;
    isComposite[2] = false;


    final BiConsumer<Integer,Integer> processIfPrime = (n,m) -> {
        if(m <= N)
      {
        isComposite[m] = true;
        processIfPrime.accept(n, n + m);
      }
    };

    final Consumer<Integer> processTillN = (n) -> {
      if((n <= N) && (! isComposite[n]))
      {
        isComposite[n] = false;
        System.out.print(n + " " );
        processIfPrime.accept(n, n * n);
      }
      processTillN.accept(n + 1);
    };

    processTillN.accept(2);*/
  }
}
