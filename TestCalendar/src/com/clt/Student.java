package com.clt;

import java.io.Serializable;
import java.util.*;
class Student implements Serializable{
	     /**
		 * 
		 */
	    String stuNo;//定义学号
	    String stuName;//姓名
	    String Sex;//性别
	    String age;//年龄
		public static int S=0;//学生总数
	    static Student[] s=new Student[100];//学生信息数组
		public void inputStu(){//添加学生信息
			System.out.println("请输入你要添加的学生信息？");
			s[S]=new Student();
			Scanner in=new Scanner(System.in);
			Scanner in1=new Scanner(System.in);
			System.out.print("学号:");
			String x=in.nextLine();
			for(int i=0;i<S;i++) {
				if(x.equals(s[i].stuNo)) {
					System.out.println("已有该学生的学生信息");
					return;
				}
			}
			s[S].stuNo=x;
			System.out.print("姓名:");
			s[S].stuName=in.nextLine();
			System.out.print("性别:");
			String xb=in.nextLine();
			while(!xb.equals("男")&&!xb.equals("女")) {
				System.out.print("请输入正确的性别：");
				xb=in.nextLine();
			}
			s[S].Sex=xb;
			System.out.print("年龄:");
			String nl=in.nextLine();
			s[S].age=nl;
			System.out.print("学生信息添加成功!");
			S++;
		}
		public void showStu(int j){//显示学生信息
			System.out.println("学号："+s[j].stuNo+"\t"+"姓名："+s[j].stuName+"\t"+"性别:"+s[j].Sex+"\t"+"年龄:"+s[j].age);
		}
		public void czxs() {//查找学生信息
			System.out.print("请输入你要查找的学生学号:");
			Scanner in=new Scanner(System.in);
			String x=in.nextLine();
			for(int i=0;i<S;i++)
			{
				if(x.equals(s[i].stuNo)){
					System.out.print("查找成功");
					showStu(i);
					return;
				}
			}
			System.out.print("没有找到你要查找的学生信息");
		}
		public void scxs(Course cou,Grade gra){//删除学生信息
			int j=0,k=0;
			System.out.print("请输入你要删除的学生学号:");
			Scanner in=new Scanner(System.in);
			String x; x=in.nextLine();
			for(j=0;j<S;j++)
			{
				if(x.equals(s[j].stuNo)){
					k=1;
					break;
				}
			}
			if(k==1){
				for(;j<=S;j++){
				s[j]=s[j+1];//覆盖删除
				for(int i=0;i<cou.C;i++)
				{
				gra.grade[i][j]=gra.grade[i][j+1];//成绩进行交换
					}
			}
			System.out.print("删除成功");
			S--;
			}
			else{
				System.out.print("没有找到你要删除的学生信息");
			}
				
		}
		public void xgxs() {//修改学生信息
			int i=0,k=0;
			String xh;
			System.out.print("请输入你要修改的学生学号:");
			Scanner in=new Scanner(System.in);
			Scanner in1=new Scanner(System.in);
			xh=in.nextLine();
			for(i=0;i<S;i++)
			{
				if(xh.equals(s[i].stuNo)){
					k=1;
					break;
				}
			}
			if(k==1){
				System.out.println("请选择你要修改的学生的信息");
				System.out.println("0：全部修改"+"\t"+"1:学号："+s[i].stuNo+"\t"+"2:姓名："+s[i].stuName+"\t"+"3:性别:"+s[i].Sex+"\t"+"4:年龄:"+s[i].age);
				int choice=in1.nextInt();
				while(choice<0||choice>6){
					System.out.println("编号选择错误，请输入正确的编号：");
					choice=in1.nextInt();
				}	
				switch(choice){
				case 0:{System.out.println("请输入新的学生信息");
				        System.out.print("学号:");
				        String x=in.nextLine();
				        for(int j=0;j<S;j++) {
							if(x.equals(s[j].stuNo)) {
								System.out.println("已有该学生的学生信息");
								return;
							}
						}
				        s[i].stuNo=x;
				        System.out.print("姓名:");
				        s[i].stuName=in.nextLine();
				        System.out.print("性别:");
				        String xb=in.nextLine();
						while(!xb.equals("男")&&!xb.equals("女")) {
							System.out.print("请输入正确的性别：");
							xb=in.nextLine();
						}
						s[i].Sex=xb;
				        System.out.print("年龄:");
				        String nl=in.nextLine();
						s[i].age=nl;
				        System.out.print("学生信息修改成功");break;}
				case 1:{
				        System.out.print("学号:");
				        String xh1=in.nextLine();
				        for(int m=0;m<S;m++) {
							if(xh1.equals(s[m].stuNo)) {
								System.out.println("已有该学生的学生信息");
								return;
							}
						}
				        s[i].stuNo=xh1;
		                System.out.print("学生信息修改成功");break;}
				case 2:{
				        System.out.print("姓名:");
		                s[i].stuName=in.nextLine();
		                System.out.print("学生信息修改成功");break;}
				case 3:{
				        System.out.print("性别:");
				        String xb=in.nextLine();
						while(!xb.equals("男")&&!xb.equals("女")) {
							System.out.print("请输入正确的性别：");
							xb=in.nextLine();
						}
						s[i].Sex=xb;
		                System.out.print("学生信息修改成功");break;}
				case 4:{
				        System.out.print("年龄:");
				        String nl=in.nextLine();
						s[i].age=nl;
		                System.out.print("学生信息修改成功");break;}
				
			}}
			else{
				System.out.print("没有找到你要修改的学生信息");
			}		
		}
		public void showallStu(Course  cou,Grade gra) {//浏览学生信息
			if(S==0){
				System.out.println("没有学生信息");
			}
			for(int j=0;j<S;j++) {
			System.out.println("学号："+s[j].stuNo+"\t"+"姓名："+s[j].stuName+"\t"+"性别:"+s[j].Sex+"\t"+"年龄:"+s[j].age);
				for(int i=0;i<cou.C;i++) {
					System.out.println("课程:"+cou.c[i].couName+"\t"+"成绩："+gra.grade[i][j]);
				}
			}
		}
}