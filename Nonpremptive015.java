import java.util.*;
import java.lang.*;
class Process{
    int pid;
    int wait;
    int arrival;
    int burst;
    int prio;
	int turnAround;
	int ctime = 0;
    Process(int id,int sub,int bur,int p){
        pid=id;
        arrival = sub;
        burst = bur;
        prio=p;
    }
    int getburst()
    {return burst;}
    int priority()
    {return prio;}
}
class Main
{
  public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	System.out.println("Enter the number of processes:");
	int n = s.nextInt();
  Process[] myProcess = new Process[n];
  int total=0;
  for(int i=0;i<n;i++)
  {
		System.out.println("Enter process id, Arrival time and bursts,priority: ");
		int id=s.nextInt();
    int sub  = s.nextInt();
		int bur = s.nextInt();
    int p=s.nextInt();
    total=total+bur;
		myProcess[i] = new Process(id,sub,bur,p);
	}
  System.out.println("FCFS Scheduling");
  for(int i=0;i<n;i++)
  { 
    for(int j=0;j<n-1;j++)
      {
        if(myProcess[j].arrival>myProcess[j+1].arrival)
        {
          Process temp1=myProcess[j];
          myProcess[j]=myProcess[j+1];
          myProcess[j+1]=temp1;

         
              

        }


      }

  }
  int j=0;int i=myProcess[j].arrival;
  System.out.println("sequence of processing is");
  while (i<total)
  {
    System.out.print(myProcess[j].pid);
    myProcess[j].turnAround=i+myProcess[j].burst-myProcess[j].arrival;  
    myProcess[j].wait=myProcess[j].turnAround-myProcess[j].burst;
    i=i+myProcess[j].burst;
    j++;
    
  }  
  System.out.print("");
  System.out.println("id\tAT\tBT\tWT\tTT");
  for(i=0;i<n;i++)
  System.out.println(myProcess[i].pid+"\t"+myProcess[i].arrival+"\t"+myProcess[i].burst+"\t"+myProcess[i].wait+"\t"+myProcess[i].turnAround+"\t");

  double avgwait=0;
  double avgturn=0;
  for(i=0;i<n;i++)
  {
    avgwait=avgwait+myProcess[i].wait;
    avgturn=avgturn+myProcess[i].turnAround;
  }
  avgwait=avgwait/n;
  avgturn=avgturn/n;
  System.out.println("average waiting time:"+avgwait+","+"average turnaround time: "+avgturn);



System.out.println("--------------------------------------------------------------------------------------");
///////
 System.out.println("SJF non preemptive"); 
for(i=0;i<n;i++)
  {
    myProcess[i].turnAround=0;
    myProcess[i].wait=0;
  }

for(i=0;i<n;i++)
  { 
    for(j=0;j<n-1;j++)
      {
        if(myProcess[j].getburst()>myProcess[j+1].getburst())
        {
          Process temp=myProcess[j];
          myProcess[j]=myProcess[j+1];
          myProcess[j+1]=temp;

          
              

        }


      }

  }
  j=0;
  int count=0;
  int flag[]=new int[n];
  for(int k=0;k<n;k++)
  flag[k]=0;
  i=0;
  System.out.println("sequence of processing is");
  outer:while (i<total&&count<n)
  {j=0;
    while(j<n){    
      if(myProcess[j].arrival<=i&&flag[j]==0)
      {
        System.out.print(myProcess[j].pid);
        myProcess[j].turnAround=i+myProcess[j].burst-myProcess[j].arrival;  
        myProcess[j].wait=myProcess[j].turnAround-myProcess[j].burst;
        i=i+myProcess[j].burst;
        count++;
        flag[j]=1;
        continue outer;
      }
    j++;
    }
    i++;
  } 

  System.out.println("");
  System.out.println("id\tAT\tBT\tWT\tTT");
  for(i=0;i<n;i++)
  System.out.println(myProcess[i].pid+"\t"+myProcess[i].arrival+"\t"+myProcess[i].burst+"\t"+myProcess[i].wait+"\t"+myProcess[i].turnAround+"\t");

  avgwait=0;
  avgturn=0;
  for(i=0;i<n;i++)
  {
    avgwait=avgwait+myProcess[i].wait;
    avgturn=avgturn+myProcess[i].turnAround;
  }
  avgwait=avgwait/n;
  avgturn=avgturn/n;
  System.out.println("average waiting time:"+avgwait+","+"averagae turnaround time: "+avgturn);


System.out.println("--------------------------------------------------------------------------------------");
 //
 System.out.println("PRIORITY"); 
for(i=0;i<n;i++)
  {
    myProcess[i].turnAround=0;
    myProcess[i].wait=0;
  }




for(i=0;i<n;i++)
  { 
    for(j=0;j<n-1;j++)
      {
        if(myProcess[j].priority()>myProcess[j+1].priority())
        {
          Process temp=myProcess[j];
          myProcess[j]=myProcess[j+1];
          myProcess[j+1]=temp;

          
              

        }


      }

  }
  j=0;
  count=0;
  for(int k=0;k<n;k++)
  flag[k]=0;
  i=0;
  System.out.println("sequence of processing is");
  outer:while (i<total&&count<n)
  {j=0;
    while(j<n){    
      if(myProcess[j].arrival<=i&&flag[j]==0)
      {
        System.out.print(myProcess[j].pid);
        myProcess[j].turnAround=i+myProcess[j].burst-myProcess[j].arrival;  
        myProcess[j].wait=myProcess[j].turnAround-myProcess[j].burst;
        i=i+myProcess[j].burst;
        count++;
        flag[j]=1;
       continue outer;
      }
    j++;
    }
    i++;
   //// outer:
  } 

  System.out.println("");
  System.out.println("id\tAT\tBT\tWT\tTT");
  for(i=0;i<n;i++)
  System.out.println(myProcess[i].pid+"\t"+myProcess[i].arrival+"\t"+myProcess[i].burst+"\t"+myProcess[i].wait+"\t"+myProcess[i].turnAround+"\t");

  avgwait=0;
  avgturn=0;
  for(i=0;i<n;i++)
  {
    avgwait=avgwait+myProcess[i].wait;
    avgturn=avgturn+myProcess[i].turnAround;
  }
  avgwait=avgwait/n;
  avgturn=avgturn/n;
  System.out.println("average waiting time:"+avgwait+","+"averagae turnaround time: "+avgturn);
}   
}
