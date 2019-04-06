import java.util.*;
import java.lang.*;
class Process{
    int pid;
    int wait;
    int arrival;
    int burst;
    int prio;
    int priority;
	int turnAround;
	int ctime = 0;
  int remtime;
    Process(int id,int sub,int bur,int p){
        pid=id;
        arrival = sub;
        burst = bur;
        remtime=bur;
        prio=p;
        priority=p;
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
  int i;
  //int tslice;
  for(i=0;i<n;i++)
  {
		System.out.println("Enter process id, Arrival time and bursts,priority: ");
		int id=s.nextInt();
    int sub  = s.nextInt();
		int bur = s.nextInt();
    int p=s.nextInt();
    total=total+bur;
		myProcess[i] = new Process(id,sub,bur,p);
	}
  //System.out.print("enter time slice");
  //timeslice=sc.nextInt();
  int flag[]=new int[n];
  for(i=0;i<n;i++)
  {
    myProcess[i].turnAround=0;
    myProcess[i].wait=0;
    flag[i]=0;
  }
  int q=0;
  int minarrival=99;
  for(i=0;i<n;i++)
  {
    if(myProcess[i].arrival<minarrival)
    {
      minarrival=myProcess[i].arrival;
    }
  }
  i=minarrival;
  for(int k=0;k<minarrival;k++)
  System.out.println("process none from "+k+" to "+(k+1));
Process queue[]=new Process[n];
while (i<total+minarrival)
  {int  j=0;
      while(j<n)
      {
          if(myProcess[j].arrival<=i&&flag[j]==0)
        {
          queue[q]=myProcess[j];flag[q]=1;q++;
        }
        j++;
      }
    for(int x=0;x<q;x++)
    { 
    for(int y=0;y<q-1;y++)
      {
        if(queue[y].prio>queue[y+1].prio)
        {
          Process temp=queue[y];
          queue[y]=queue[y+1];
          queue[y+1]=temp;
        }   
      }
    }
    if(queue[0].remtime!=99)
    {
      System.out.println("Process "+queue[0].pid+" from "+i+" to "+(i+1));
      queue[0].remtime=queue[0].remtime-1;
      if(queue[0].remtime==0)
      {
        queue[0].ctime=i;
        queue[0].remtime=99;
        queue[0].prio=99;
      }
    }
  i++;
  }
  for(i=0;i<n;i++)
  {
    queue[i].turnAround=queue[i].ctime-queue[i].arrival+1;
    queue[i].wait=queue[i].turnAround-queue[i].burst;
  } 

 System.out.println("");
  System.out.println("id\tAT\tBT\tpriority\tWT\tTT");
  for(i=0;i<n;i++)
  System.out.println(myProcess[i].pid+"\t"+myProcess[i].arrival+"\t"+myProcess[i].burst+"\t"+myProcess[i].priority+"\t\t"+myProcess[i].wait+"\t"+myProcess[i].turnAround+"\t");

  double avgwait=0;
  double avgturn=0;
  for(i=0;i<n;i++)
  {
    avgwait=avgwait+myProcess[i].wait;
    avgturn=avgturn+myProcess[i].turnAround;
  }
  avgwait=avgwait/n;
  avgturn=avgturn/n;
  System.out.println("average waiting time:"+avgwait+", "+"average turnaround time: "+avgturn);

}
}

