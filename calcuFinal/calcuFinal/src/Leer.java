
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Leer
{
   public String datoStr()
   {
      String sdato = "";
      try
      {
       BufferedReader bf;
       bf=new BufferedReader(new InputStreamReader(System.in));
       sdato=bf.readLine();
      }
      catch(IOException e)
      {
	    System.err.println("Error:" + e.getMessage());
      }
      return sdato;
   }
   public int datoInt()
   {
	  int idato=0; 
      try
      { BufferedReader bf;
        bf=new BufferedReader(new InputStreamReader(System.in));
        idato=Integer.parseInt(bf.readLine());
      }
      catch(IOException e)
      {
	    System.err.println("Error:" + e.getMessage());
      }
      return idato;
   }
   public float datoFloat()
   {
	   float fdato=0; 
	      try
	      { BufferedReader bf;
	        bf=new BufferedReader(new InputStreamReader(System.in));
	        fdato=Long.parseLong(bf.readLine());
	      }
	      catch(IOException e)
	      {
		    System.err.println("Error:" + e.getMessage());
	      }
	      return fdato;
   }   
}
