import java.util.*;
import java.lang.*;
class Main {
  static ArrayList<String> V=new ArrayList<String>();
  static ArrayList<String> T=new ArrayList<String>();
  static String S;
  static int ecount=0;
  static ArrayList<String> grammer=new ArrayList<String>();
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        String thisline;


     System.out.println("Enter start symbol");
    S=sc.next();

    System.out.println("Enter variables");
    while(true)
    {
      thisline=sc.next();
      if(thisline.equals("."))
      {
        break;
      }
      
        V.add(thisline);
      
    }
    System.out.println("Enter terminals");
     while(true)
    {
      thisline=sc.next();
      if(thisline.equals("."))
      {
        break;
      }
      
        T.add(thisline);
      
    }
    getp();



  System.out.println("S:"+S);
  System.out.print("\nV:{");
  for(int k=0;k<V.size();k++)
  {
    System.out.print(V.get(k)+",");
  }
  System.out.print("}\n");

 System.out.print("\nT:{");
  for(int k=0;k<T.size();k++)
  {
    System.out.print(T.get(k)+",");
  }
  System.out.print("}\n");


  System.out.println("\n P after removing left recursion(direct)");
  for(int i=0;i<grammer.size();i++)
  System.out.println(grammer.get(i));

  indirectr();

  }

static void getp()
{
  String thisline;
  Scanner sc=new Scanner(System.in);
    System.out.println("Enter productions");
    
    while(true)
  {
    thisline=sc.nextLine();
    if(thisline.equals(""))
    {break;}
    directr(thisline);
  }
}


static void indirectr()
{
  for(int i=0;i<V.size();i++)
    {
      int reaplace=0;
      for(int k=0;k<grammer.size();k++)
        {
          String words[]=grammer.get(k).split("-->");
          if((V.get(i)).equals(words[0])
          {
            String Aiproductions[]=words[1].split(|);
            replace=k;
            break;
          }
        }    
    for(int j=0;j<V.size();j++)
    {
        for(int k=0;k<grammer.size();k++)
        {
          String words[]=grammer.get(k).split("-->");
          if((V.get(j)).equals(words[0])
          {
            String gammap[]=words[1].split(|);
            break;
          }
        }    
        
      //finding Ai=AjRHO;
        for(int p=0;p<Aiproductions.length();p++)
        {
            for(int q=0;q<Aiproductions[p].length;q++)
            {
              
            }

        }



    }}



}






  static void directr(String thisline)
  {
    String words[]=thisline.split("-->");
    String vars[]=words[1].split("\\|");
    int alphacount=0;
    int betacount=0;
    String[] alpha=new String[20];
    String[] beta=new String[20];

        for(int k=0;k<vars.length&&vars[k]!=null;k++)
    {
    if(words[0].equals(Character.toString(vars[k].charAt(0))))
    {
        alpha[alphacount]=vars[k].substring(1,vars[k].length());
             // System.out.print("added alpha "+alpha[alphacount]);

        alphacount++;
    }
    else
    {
      //System.out.print("added beta "+vars[k]);
      beta[betacount]=vars[k];
      betacount++;
    }
    }
    if(alphacount==0)//no recursibve grammer
    {
      //System.out.println("no recursion");
      grammer.add(thisline);
    }

    else{ // there is left recursion
     // System.out.println("recursion alphacount="+alphacount+" betacount="+betacount+"vars count="+vars.length);
        String newv=words[0]+"'";
        V.add(newv);
        String Aline=words[0]+"-->";
        for(int j=0;j<beta.length&&beta[j]!=null;j++)
        {
          if(j!=0)
          {
            Aline=Aline+"|";
          }
          Aline=Aline+beta[j]+newv;
        }
         grammer.add(Aline);



        String Adashline=newv+"-->";
        for(int j=0;j<alpha.length&&alpha[j]!=null;j++)
        {
           if(j!=0)
          {
            Adashline=Adashline+"|";
          }
          Adashline=Adashline+alpha[j]+newv;
        }
        Adashline=Adashline+"|epsilon";
          grammer.add(Adashline);


    }


  }
}
