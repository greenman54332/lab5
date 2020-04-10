package Main;

//package com.company;
import java.util.Random;
import java.util.Scanner;

class SecondaryClass {
    private double    first;
    private double    second;
    private Scanner inp = new Scanner(System.in);
    public void Init(){
        ReadFirst();
        ReadSecond();
    }
    public void Init(double a,double b){
        first=a;second=b;
    }

    public void ReadFirst(){
            System.out.printf("Enter first p ");
            first = inp.nextInt(); 
    }

    public void ReadSecond(){
            System.out.printf("Enter second q ");
            second = inp.nextInt();       
    }
    /*
    public void RoundFirst(){
    if(second>28) first++;
    second=0;
    }*/
    public double GetFirst(){
        return (first);
    }

    public double GetSecond(){
        return (second);
    }

    public void Display(){
        System.out.printf("First p = ");System.out.println(first);
        System.out.printf("Second q= ");System.out.println(second);
    }
}

class MainClass {
    private SecondaryClass a1 = new SecondaryClass();
    private SecondaryClass a2 = new SecondaryClass();
    private Scanner inp = new Scanner(System.in);
    
    private double x,y,k,q1,q2,p1,p2;
    public void Init(){
        a1.Init();
        a2.Init();
        do {
        	System.out.printf("(0 <= K <= 4) K = ");
        	k=inp.nextInt();
           }while(k < 0 && k > 4);
        }
    public int Ratio(){
        p1=a1.GetFirst();
        q1=a1.GetSecond();
        p2=a2.GetFirst();
        q2=a2.GetSecond();
        if(p1*p1 - 4*q1 > 0)
        	x = 2;
        if(p1*p1 - 4*q1 == 0)
        	x = 1;
        if(p1*p1 - 4*q1 < 0)
        	x = 0;
        if(p2*p2 - 4*q2 > 0)
        	y = 2;
        if(p2*p2 - 4*q2 == 0)
        	y = 1;
        if(p2*p2 - 4*q2 < 0)
        	y = 0;
    if(x + y == k) return 1;
    else return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        SecondaryClass a = new SecondaryClass();
        a.Init();
        System.out.println(a.GetFirst());
        System.out.println(a.GetSecond());
        a.Display();
        MainClass m=new MainClass();
        m.Init();
        if(m.Ratio()==1)  System.out.println("1 (истина)");
        else System.out.println("0 (ложь)");

        SecondaryClass m2[]=new SecondaryClass[5];
        Random r = new Random();

        for (int i=0;i<5;i++){
            m2[i]=new SecondaryClass();
            m2[i].Init(r.nextInt(1000),r.nextInt(1000));
        }
        double[] masfirst=new double[5];
        double[] massecond=new double[5];
        double maxfirst=m2[0].GetFirst(),maxsecond=m2[0].GetSecond();
        for (int i=0;i<5;i++){
            masfirst[i]=m2[i].GetFirst();
            massecond[i]=m2[i].GetSecond();
            System.out.println(masfirst[i]);
            System.out.println(massecond[i]);
            if (maxfirst==masfirst[i]){
                if (maxsecond>massecond[i]) maxsecond=massecond[i];
            }
            else if (maxfirst<masfirst[i]){
                maxfirst=masfirst[i];
                maxsecond=massecond[i];
            }
        }
        System.out.println("Максимальные p и q:");
        System.out.printf("First (p)= ");System.out.println(maxfirst);
        System.out.printf("Second (q)= ");System.out.println(maxsecond);
        for (int i=0;i<5;i++){
            System.out.println(i+1);
            m2[i].Display();
        }
    }
}
