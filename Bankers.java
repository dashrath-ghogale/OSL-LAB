import java.util.*;
import java.lang.*;
class Main {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter no of resources");
    int nr=sc.nextInt();//nr =no of resources
    int R[]=new int[nr];
    int V[]=new int[nr];

    System.out.println("enter resources");
    for(int i=0;i<nr;i++)
    R[i]=sc.nextInt();
    System.out.println("enter no of processes");
    int np=sc.nextInt();
    
    int C[][]=new int[np][nr];
    int A[][]=new int[np][nr];
    int need[][]=new int[np][nr];

  
    
    System.out.println("enter claim matrix");
    for(int i=0;i<np;i++)
    for(int j=0;j<nr;j++)
    C[i][j]=sc.nextInt();

    System.out.println("enter alloc matrix");
    for(int i=0;i<np;i++)
    {for(int j=0;j<nr;j++)
    {A[i][j]=sc.nextInt();
    System.out.println(A[i][j]);
    System.out.println(i+" "+j);}}
  

    for(int i=0;i<np;i++)
    for(int j=0;j<nr;j++)
    need[i][j]=C[i][j]-A[i][j];

    int sumA[]= new int[nr];
    for(int j=0;j<nr;j++)
    for(int i=0;i<np;i++)
    sumA[j]=sumA[j]+A[i][j];//sum of Aij

    for(int j=0;j<nr;j++)
    V[j]=R[j]-sumA[j];

    int processok=0;
    int processdone[]=new int[np];
    int alldone=0;
    int deadlock=0;
    while(alldone!=1&&deadlock==0)
    {
      deadlock=1;
      for(int i=0;i<np;i++)
      {
        if(processdone[i]==0)
        {
          deadlock=0;
          processok=1;
          for(int j=0;j<nr;j++)
          {
            if(need[i][j]>=V[j])
            processok=0;
          }
          if(processok==1)
          {
            System.out.println("process "+i+" done");
            for(int k=0;k<nr;k++)
            V[k]=V[k]+A[i][k];
            for(int k=0;k<nr;k++)
            {C[i][k]=0;
             A[i][k]=0;
            }
             processdone[i]=1;
          alldone--;
          }
         


        }
      }
      if(deadlock==1&&alldone!=0)
      {
        System.out.println(" fuck there is deadlock");
      }
    }

    

     


  }
}