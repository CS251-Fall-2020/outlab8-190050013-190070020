import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{

  public static void main(String[] args) throws IOException
  {
    String fileName = "MD5sums";

    BufferedReader br = new BufferedReader(new FileReader(fileName));

    String line;
    while((line = br.readLine()) != null)
    {
      int lastIndexOfHash = line.lastIndexOf("-");
      String contents[] = new String[2];
      contents[0] = line.substring(0,lastIndexOfHash);
      contents[0] = contents[0].substring(0,contents[0].length() - 1);
      contents[1] = line.substring(lastIndexOfHash + 1).trim();
      try
      {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(contents[0].getBytes());
        BigInteger calculatedMD5 = new BigInteger(1, messageDigest);
        String givenMD5 = contents[1].trim();
        String calculatedMD5_string = calculatedMD5.toString(16);


        while( calculatedMD5_string.length() < 32)
        {
          calculatedMD5_string = "0" + calculatedMD5_string;
        }

        if( calculatedMD5_string.equals(givenMD5) )
        {
          System.out.println("verified");
        }
        else
        {
          System.out.println("not verified");
        }


        /*System.out.println(contents[0] + " " + contents[0].length() + " " + contents[0].trim().length());
        System.out.println(givenMD5 + " " + givenMD5.length());
        System.out.println(calculatedMD5_string + " " + calculatedMD5_string.length());
        System.out.println();*/


      }
      catch(NoSuchAlgorithmException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
