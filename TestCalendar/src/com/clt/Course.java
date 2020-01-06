package com.clt;

import java.io.Serializable;
import java.util.Scanner;

class Course implements Serializable{
	String couNo;//定义课程编号
	String couName;//课程名称
	String counumber;//课节数
	String couxz;//课程性质
	String couxf;//课程学分
	String couteacher;//授课老师
	public static int C;//课程总数
    static Course[] c=new Course[100];//课程信息数组
public void inputcou(){//添加课程信息
	System.out.println("请输入你要添加的课程信息");
	c[C]=new Course(); 
	Scanner in=new Scanner(System.in);	
	System.out.print("课程编号:");
	String x=in.nextLine();
	for(int i=0;i<C;i++) {
		if(x.equals(c[i].couNo)) {
			System.out.println("已有该课程的课程信息");
			return;
		}
	}
	c[C].couNo=x;
	System.out.print("课程名称:");
	c[C].couName=in.nextLine();
	System.out.print("课时数:");
	c[C].counumber=in.nextLine();
	System.out.print("课程性质:");
	String xz=in.nextLine();
	while(!xz.equals("选修")&&!xz.equals("必修")) {
		System.out.print("请输入正确的课程性质：");
		xz=in.nextLine();
	}
	c[C].couxz=xz;
	System.out.print("课程学分:");
	c[C].couxf=in.nextLine();
	System.out.print("授课老师:");
	c[C].couteacher=in.nextLine();
	System.out.print("课程信息添加成功");
	C++;
}
public void showcou(int i){//显示课程信息
	System.out.println("课程编号："+c[i].couNo+"\t"+"课程名称："+c[i].couName+"\t"+"课时数:"+c[i].counumber+"\t"+"课程性质:"+c[i].couxz+"\t"+"课程学分："+c[i].couxf+"\t"+"授课老师："+c[i].couteacher);
}
public void czkc(){
	int i=0;
	String x;
	System.out.print("请输入你要查找的课程编号;");
	Scanner in=new Scanner(System.in);
	x=in.nextLine();
	for(i=0;i<C;i++)
	{
		if(x.equals(c[i].couNo)){
			System.out.print("查找成功");
			c[i].showcou(i);
			return;
		}
	}
	System.out.print("没有找到你要查找的课程信息");
}
public void sckc(Student stu,Grade gra){//删除课程信息
	int i=0,k=0;
	String x;
	System.out.print("请输入你要删除的课程编号;");
	Scanner in=new Scanner(System.in);
	x=in.nextLine();
	for(i=0;i<C;i++)
	{
		if(x.equals(c[i].couNo)){
			k=1;
			break;
		}
	}
	if(k==1){
		for(;i<=C;i++){
			c[i]=c[i+1];
			for(int j=0;j<stu.S;j++)
			{
			gra.grade[i][j]=gra.grade[i+1][j];
				}
			}
	System.out.print("删除成功");
	C--;
	}
	else{
		System.out.print("没有找到你要删除在课程信息");
	}	
}
public void xgkc() {//修改课程信息
	int i=0,k=0;
	String x;
	System.out.print("请输入你要修改的课程编号");
	Scanner in=new Scanner(System.in);
	Scanner in1=new Scanner(System.in);
	x=in.nextLine();
	for(i=0;i<C;i++)
	{
		if(x.equals(c[i].couNo)){
			k=1;
			break;
		}
	}
	if(k==1){
		System.out.println("请选择你要修改的课程信息");
		System.out.println("0：全部修改"+"\t"+"1：课程编号："+c[i].couNo+"\t"+"2：课程名称："+c[i].couName+"\t"+"3：课时数:"+c[i].counumber+"\t"+"4：课程性质:"+c[i].couxz+"\t"+"5：课程学分："+c[i].couxf+"\t"+"6：授课老师："+c[i].couteacher);
		int choice=in1.nextInt();
		while(choice<0||choice>6){
			System.out.println("编号选择错误，请输入正确的编号：");
			choice=in1.nextInt();
		}	
		switch(choice){
		case 0:{System.out.println("请输入新的课程信息");
		       System.out.print("课程编号:");
		       c[i].couNo=in.nextLine();
		       System.out.print("课程名称:");
		       String mc=in.nextLine();
		       for(int j=0;j<C;j++) {
		   		if(x.equals(c[j].couName)) {
		   			System.out.println("已有该课程的课程信息");
		   			return;
		   		}
		    	}
		       c[i].couName=mc;
		       System.out.print("课时数:");
		       c[i].counumber=in.nextLine();
		       System.out.print("课程性质:");
		       String xz=in.nextLine();
		     	while(!xz.equals("选修")&&!xz.equals("必修")) {
		   		System.out.print("请输入正确的课程性质：");
		   		xz=in.nextLine();
		   	 }
		       c[i].couxz=xz;
		       System.out.print("课程学分:");
		       c[i].couxf=in.nextLine();
		       System.out.print("授课老师:");
		       c[i].couteacher=in.nextLine();
		       System.out.print("课程信息修改成功");break;}
		case 1:{
			    System.out.print("课程编号:");
			    c[i].couNo=in.nextLine();
			    System.out.print("课程信息修改成功");break;}
		case 2:{
			    System.out.print("课程名称:");
			    String mc1=in.nextLine();
			    for(int m=0;m<C;m++) {
					if(x.equals(c[m].couName)) {
						System.out.println("已有该课程的课程信息");
						return;
					}
				}
	            c[i].couName=mc1;
	            System.out.print("课程信息修改成功");break;}
		case 3:{
		        System.out.print("课时数:");
		        c[i].counumber=in.nextLine();
		        System.out.print("课程信息修改成功");break;}
		case 4:{
		        System.out.print("课程性质:");
		        String xz=in.nextLine();
		    	while(!xz.equals("选修")&&!xz.equals("必修")) {
		    		System.out.print("请输入正确的课程性质：");
		    		xz=in.nextLine();
		    	}
		    	c[i].couxz=xz;
		        System.out.print("课程信息修改成功");break;}
		case 5:{
		        System.out.print("课程学分:");
		        c[i].couxf=in.nextLine();
		        System.out.print("课程信息修改成功");break;}
		case 6:{
		        System.out.print("授课老师:");
		        c[i].couteacher=in.nextLine();
		        System.out.print("课程信息修改成功");break;}
		}
	}
	else{
		System.out.print("没有找到你要修改的课程信息");
	}		
}
public void showallcou(Student stu,Grade gra) {//浏览课程信息
	if(C==0){
		System.out.println("没有课程信息");
	}
	for(int i=0;i<C;i++) {
		System.out.println("课程编号："+c[i].couNo+"\t"+"课程名称："+c[i].couName+"\t"+"课时数:"+c[i].counumber+"\t"+"课程性质:"+c[i].couxz+"\t"+"课程学分："+c[i].couxf+"\t"+"授课老师："+c[i].couteacher);
		for(int j=0;j<stu.S;j++) {
			System.out.println("学生:"+stu.s[j].stuNo+"成绩："+gra.grade[i][j]);
		}
	}
}
}