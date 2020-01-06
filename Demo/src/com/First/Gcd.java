package com.First;

import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        int m,n;
        System.out.println("请输入m!");
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        System.out.println("请输入n!");
        n=sc.nextInt();
        Gcd g=new Gcd();
        System.out.println("最大公约数结果:"+g.gcd(m, n));
    }
    public int gcd(int m,int n){
        int temp=1;
        while(temp>0){
            temp=m%n;
            m=n;
            n=temp;
        }
        return m;
    }
}
