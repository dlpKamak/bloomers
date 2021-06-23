import java.io.*;

class PrimeNum implements Runnable
{
   public Thread t1;
   //private int countt;
   private int countt;
   private int[] primeSet;
   public PrimeNum()
   {
      t1       = new Thread(this,"Prime Thread");
      primeSet = new int[15000];
      countt = 0;
      t1.start();
      
   }
   public void run()
   {
      int i=2,j;
      int k=0;
      
      try
      {
        for(i=2;i<100000;i++)
	{
            boolean isPrime = true;
            //int limit = i / 2 ; 
            for (j = 2;j < i;j ++)
            {
               if (i % j == 0)
               {
                  isPrime = false;
                  break;
               }
            }
            if (isPrime)
            {
               primeSet[countt ++] = i;
               //countt ++;
               //System.out.println(i);
               Thread.sleep(2);
               //System.out.println(i);
            }
            
         }
         
         /*for(int y=0;y<countt;y++)
	 {
		System.out.print(primeSet[y]+"\t");
         }*/
        
     }
      catch(InterruptedException ie)
      {
         System.out.println("Interrupted Exception being thrown" + ie);
      }
   }
   public int[] getPrimeSet()
   {
      int[] pr = new int[countt-1];
      System.arraycopy(primeSet,0,pr,0,countt-1);
      return pr;
   }
}

class FibonacciNum implements Runnable
{
   public Thread t2;
   private int count;
   //public int count;
   private int[] fibonacciSet;
   public FibonacciNum()
   {
      t2       = new Thread(this,"Fibonacci Thread");
      fibonacciSet = new int[50];
      count = 2;
      t2.start();
      
   }
   public void run()
   {
      fibonacciSet[0] = 0;
      fibonacciSet[1] = 1;
      //
      //try
      //{
         int i =2;
         while (true)
         {
            fibonacciSet[i] = fibonacciSet[i-1] +  fibonacciSet[i-2];
            if (fibonacciSet[i] > 100000)
               break;
            //System.out.println(fibonacciSet[i]);
            i ++;
            count ++;
         } 
         /*
         for(int y=0;y<count;y++)
	 {
		System.out.print(fibonacciSet[y]+"\t");
         } */   
      //}
      /*catch(InterruptedException ie)
      {
         System.out.println("Interrupted Exception being thrown" + ie);
      }*/
   }
   public int[] getFibonacciSet()
   {
      int[] fi = new int[count-1];
      System.arraycopy(fibonacciSet,0,fi,0,count-1);
      
      //System.out.println(fibonacciSet[count-1]);
      return fi;
   }
}


public class MyThreadPgm
{
   public static void main(String[] args)
   {
      int[] prime ;
      int[] fibo  ;
      //PrimeNum p     = new PrimeNum();
      //FibonacciNum f = new FibonacciNum();
      try
      {
         PrimeNum p     = new PrimeNum();
         p.t1.join();
         FibonacciNum f = new FibonacciNum();
         f.t2.join();
         prime = p.getPrimeSet();
         fibo  = f.getFibonacciSet();
         System.out.println("\nPrime numbers between 1 and 1,00,000 are :");
         for(int g :prime)
         {
            System.out.print("\t"+g);
         }         
         System.out.println("\nFibonacci numbers between 1 and 1,00,000 are :");
         for(int j :fibo)
         {
            System.out.print("\t"+j);
         }

         System.out.println("Element in Common are:");        
	 for ( int i=0;i<fibo.length;i++)
         {
           // System.out.println(i);
            for (int j=0;prime[j]<=fibo[i];j ++)
            {
               //System.out.println(prime[j]);
               if ( prime[j]==fibo[i])
               {
                  System.out.print(fibo[i]+"\t");
               }
               //i++;
            }
        }
      }
        catch(InterruptedException ie)
      {
         System.out.println("Interrupted Exception being thrown" + ie);
      }
   }
}




