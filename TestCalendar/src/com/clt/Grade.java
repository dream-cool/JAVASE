package com.clt;


import java.io.Serializable;
import java.util.Scanner;
public class Grade implements Serializable {
	public static double grade[][]=new double[100][100];//i代表课程信息，j代表学生信息
	public void kclr(Student stu,Course  cou){//按课程录入学生成绩
		int m=0,n=0;
		Scanner in=new Scanner(System.in);
		Scanner in1=new Scanner(System.in);
		Scanner in2=new Scanner(System.in);
	    System.out.print("请输入课程名：");
		String t=in.nextLine();
	    for(int i=0;i<cou.C;i++){//寻找课程
	    	if(t.equals(cou.c[i].couName)){m=1;
	    		for(int j=0;j<stu.S;j++){//对所有学生进行成绩录入
	    			n=1;
	    			if(grade[i][j]>0){
	    				System.out.println("该课程学号为"+stu.s[j].stuNo+"的学生已有成绩"+grade[i][j]+"，是否重新录入，1：重新录入          0：录入下一一学生成绩");
	    				int xz=in1.nextInt();
	    				if(xz==1){
	    					System.out.print("请输入学号为"+stu.s[j].stuNo+"的学生新的成绩");
	    	    			double c=in2.nextDouble();
	    	    			while(c<0) {
	    	    				System.out.println("录入的成绩不能为负数，请重新录入");
	    	    				c=in2.nextDouble();
	    	    			}
	    					grade[i][j]=c;//将成绩到二维数组的对应位置
	    			 System.out.println("录入成功，学号:"+stu.s[j].stuNo+"   成绩："+grade[i][j]);
	    				}
	    			}
	    			else{
	    			System.out.print("请输入学号为"+stu.s[j].stuNo+"的学生成绩");
	    			double c=in2.nextDouble();
	    			while(c<0) {
	    				System.out.println("录入的成绩不能为负数，请重新录入");
	    				c=in2.nextDouble();
	    			}
	    			grade[i][j]=c;//将成绩到二维数组的对应位置
	    			System.out.println("录入成功，学号:"+stu.s[j].stuNo+"   成绩："+grade[i][j]);}
	    		}
	    	}
	    }if(m==0) {System.out.println("没有找到对应课程信息");{//判断课程是否为空
	    	for(int j=0;j<stu.S;j++){//课程信息为空时无法进入循环所以无法判断学生信息是否为空需要额外判断
    			n=1;}
	    if(n==0){System.out.print("没有找到学生信息");return;	}//判断学生是否为空
	    }{for(int j=0;j<stu.S;j++){
			n=1;}
         if(n==0) System.out.print("没有找到学生信息");	   	
	    }
	    }
		}
	public void xslr(Student stu,Course  cou){//按学生录入课程成绩
		int m=0,n=0,pd=0;
		Scanner in=new Scanner(System.in);
		Scanner in1=new Scanner(System.in);
		Scanner in2=new Scanner(System.in);
	    System.out.print("请输入学生学号：");
		String t=in.nextLine();
	    for(int j=0;j<stu.S;j++){//寻找学生
	    	if(t.equals(stu.s[j].stuNo)){
	    		m=1;
	    		System.out.print("请选择对全部课程录入或是选择某一课程录入");
	    		System.out.print("1:全部课程录入             2：选择课程录入");
	    		int lr=in1.nextInt();
	    		if(lr==2){
	    			System.out.print("请输入你要选择录入的课程");
	    			String kc=in.nextLine();
	    			for(int i=0;i<cou.C;i++){
		    			if(kc.equals(cou.c[i].couName)){
		    				    pd=1;
		    					if(grade[i][j]>0){
				    				System.out.println("该学生该课程已有成绩"+grade[i][j]+"，是否重新录入，1：重新录入          0：退出");
				    				int xz=in1.nextInt();
				    				if(xz==1){
				    					System.out.print("请输入学号为"+stu.s[j].stuNo+"课程为"+cou.c[i].couName+"新的成绩");
					    			    double c=in2.nextDouble();
					    				while(c<0) {
				    	    				System.out.println("录入的成绩不能为负数，请重新录入");
				    	    				c=in2.nextDouble();
				    	    			}
				    					grade[i][j]=c;//将成绩到二维数组的对应位置
				    			      System.out.println("录入成功，学号:"+stu.s[j].stuNo+"   成绩："+grade[i][j]);
				    				}
				    			}
							 else{
							 System.out.print("请输入学号为"+stu.s[j].stuNo+"课程为"+cou.c[i].couName+"的成绩");
							 double c=in2.nextDouble();
								while(c<0) {
		    	    				System.out.println("录入的成绩不能为负数，请重新录入");
		    	    				c=in2.nextDouble();
		    	    			}
							 grade[i][j]=c;
							 System.out.println("录入成功，学号:"+stu.s[j].stuNo+"   课程:"+cou.c[i].couName+"   成绩："+grade[i][j]);
							 }
		    			}
		        }if(pd==0)System.out.print("没有找到你要录入的课程");
	    			}
	    		else{
	    		for(int i=0;i<cou.C;i++){//对找到的学生将所有课程成绩进行录入
	    			n=1;
	    			if(grade[i][j]>0){
	    				System.out.println("该学生的"+cou.c[i].couName+"课程已有成绩"+grade[i][j]+"，是否重新录入，1：重新录入          0：录入下一门成绩");
	    				int xz=in1.nextInt();
	    				if(xz==1){
	    					System.out.print("请输入"+cou.c[i].couName+"课程新的成绩");
		    			    double c=in2.nextDouble();
		    				while(c<0) {
	    	    				System.out.println("录入的成绩不能为负数，请重新录入");
	    	    				c=in2.nextDouble();
	    	    			}
	    					grade[i][j]=c;//将成绩到二维数组的对应位置
	    			      System.out.println("录入成功，学号:"+stu.s[j].stuNo+"   成绩："+grade[i][j]);
	    				}
	    			}
	    			else{
	    			System.out.print("请输入"+cou.c[i].couName+"课程成绩");
	    			double c=in2.nextDouble();
	    			while(c<0) {
	    				System.out.println("录入的成绩不能为负数，请重新录入");
	    				c=in2.nextDouble();
	    			}
	    			grade[i][j]=c;                    
	    			System.out.println("录入成功，课程:"+cou.c[i].couName+"   成绩："+grade[i][j]);}
	    		}
	    	}}
	    }if(m==0) {System.out.println("没有找到对应学生信息");
	    for(int i=0;i<cou.C;i++){n=1;}
	   if(n==0) {System.out.print("没有找到课程信息");return;}	
	    }{for(int i=0;i<cou.C;i++){n=1;}
		   if(n==0) {System.out.print("没有找到课程信息");}	
	    }
		}
	public void drlr(Student stu,Course  cou){//录入某个学生的某门课程成绩
		Scanner in=new Scanner(System.in);
		Scanner in1=new Scanner(System.in);
		Scanner in2=new Scanner(System.in);
		System.out.print("请分别输入你要录入学生的学号和课程名称:");
		String xh=in.nextLine();
		String kc=in.nextLine();
		int m=0,n=0;
		 for(int i=0;i<cou.C;i++){
			 if(kc.equals(cou.c[i].couName)){//寻找课程
				 m=1;
				 for(int j=0;j<stu.S;j++){
					 if(xh.equals(stu.s[j].stuNo)){//寻找学生
						 n=1;
						 if(grade[i][j]>0){
			    				System.out.println("该学生该课程已有成绩，是否重新录入"+grade[i][j]+"，1：重新录入          0：退出");
			    				int xz=in1.nextInt();
			    				if(xz==1){
			    					System.out.print("请输入学号为"+stu.s[j].stuNo+"课程为"+cou.c[i].couName+"新的成绩");
				    			    double c=in2.nextDouble();
				    			    while(c<0) {
			    	    				System.out.println("录入的成绩不能为负数，请重新录入");
			    	    				c=in2.nextDouble();
			    	    			}
			    					grade[i][j]=c;//将成绩到二维数组的对应位置
			    			      System.out.print("录入成功，学号:"+stu.s[j].stuNo+"   成绩："+grade[i][j]);
			    				}
			    			}
						 else{
						 System.out.print("请输入学号为"+stu.s[j].stuNo+"课程为"+cou.c[i].couName+"的成绩");
						 double c=in2.nextDouble();
						 while(c<0) {
	    	    				System.out.println("录入的成绩不能为负数，请重新录入");
	    	    				c=in2.nextDouble();
	    	    			}
						 grade[i][j]=c;
						 System.out.println("录入成功，学号:"+stu.s[j].stuNo+"   课程:"+cou.c[i].couName+"   成绩："+grade[i][j]);
						 } }
					 }
				 }
			 }
			 if(m==0){ System.out.println("没有找到对应课程信息");
			 for(int j=0;j<stu.S;j++){
				 if(xh.equals(stu.s[j].stuNo)){n=1;}
			 }if(n==0) {System.out.print("没有找到对应学生信息");}return;
			 }{for(int j=0;j<stu.S;j++){
				 if(xh.equals(stu.s[j].stuNo)){n=1;}}
			 if(n==0) {System.out.print("没有找到对应学生信息");}}
	}
	public void xgcj(Student stu,Course  cou){
		Scanner in=new Scanner(System.in);
		Scanner in2=new Scanner(System.in);
		System.out.print("请分别输入你要修改的学生的学号和课程名称:");
		String xh=in.nextLine();
		String kc=in.nextLine();
		int m=0,n=0;
		 for(int i=0;i<cou.C;i++){
			 if(kc.equals(cou.c[i].couName)){//寻找课程
				 m=1;
				 for(int j=0;j<stu.S;j++){
					 if(xh.equals(stu.s[j].stuNo)){//寻找学生
						 n=1;
						 System.out.print("请输入学号为"+stu.s[j].stuNo+"课程为"+cou.c[i].couName+"的新的成绩");
						 double c=in2.nextDouble();
						 while(c<0) {
	    	    				System.out.println("录入的成绩不能为负数，请重新录入");
	    	    				c=in2.nextDouble();
	    	    			}
						 grade[i][j]=c;
						 System.out.println("修改成功，学号:"+stu.s[j].stuNo+"   课程:"+cou.c[i].couName+"   成绩："+grade[i][j]);
						 } }
					 }
				 }
			 if(m==0){ System.out.println("没有找到对应课程信息");
			 for(int j=0;j<stu.S;j++){
				 if(xh.equals(stu.s[j].stuNo)){n=1;}
			 }if(n==0) {System.out.print("没有找到对应学生信息");}return;
			 }{for(int j=0;j<stu.S;j++){
				 if(xh.equals(stu.s[j].stuNo)){n=1;}}
			 if(n==0) {System.out.print("没有找到对应学生信息");}}
	}
	public void xscjcz(Student stu,Course  cou) {//按学生查找每门课程成绩
		 int t=-1,m=0,n=0,x=0;
		 System.out.print("请输入你要查找成绩的学生学号：");
		 Scanner in=new Scanner(System.in);
		 String xh=in.nextLine();
		 for(int j=0;j<stu.S;j++) {
			 if(xh.equals(stu.s[j].stuNo)) {//学找学生并对找到后的学生记录下学号位置
	             m=1;
				 t=j;//记下找到的学生学号的位置
				 break;
			 }
		 }
		 for(int i=0;i<cou.C&&t!=-1;i++) {//找到学生学号位置后对该学生的所有课程成绩进行输出显示
			 n=1;
			 if(grade[i][t]==0){
				 System.out.println("该学生"+cou.c[i].couName+"课程无成绩");
			 }
			 else
			 {System.out.println("课程："+cou.c[i].couName+"\t"+"成绩："+grade[i][t]);}
		 }
		 if(m==0) {System.out.println("没有找到学生信息");{
			 for(int i=0;i<cou.C;i++) {
				 n=1;}
		    if(n==0){System.out.print("没有找到课程信息");return;	}
		    }}
		 {
			 for(int i=0;i<cou.C;i++) {
				 n=1;}
			 if(n==0){System.out.print("没有找到课程信息");
		 }
	 }
	}
	public void kccjcz(Student stu,Course  cou) {//按课程查找每个学生成绩
		 int t=-1,m=0,n=0,x=0,y=0;
		 System.out.print("请输入你要查找成绩的课程名称：");
		 Scanner in=new Scanner(System.in);
		 String kc=in.nextLine();
		 for(int i=0;i<cou.C;i++){
			 if(kc.equals(cou.c[i].couName)) {
				 m=1;
				 t=i;
				 break;
			 }
		 }
		 for(int j=0;j<stu.S&&t!=-1;j++){
			 n=1;
			 if(grade[t][j]==0){
				 System.out.println(""+stu.s[j].stuName+"学生该课程无成绩");
			 }
			 else
		 {System.out.println("姓名："+stu.s[j].stuName+"\t"+"成绩："+grade[t][j]);}
		 }
		 if(m==0) {System.out.println("没有找到课程信息");{
			 for(int j=0;j<stu.S;j++){
				 n=1;}
			    if(n==0){System.out.print("没有学生信息");return;}
			    }}
		 {
		 for(int j=0;j<stu.S;j++){
				 n=1;}
		 if(n==0){System.out.print("没有学生信息");
		 }
		 }	
	}
	public void drcjcz(Student stu,Course  cou){//查找某个学生某门课程成绩
		Scanner in=new Scanner(System.in);
		System.out.print("请分别输入你要查找学生的学号和课程名称:");
		String xh=in.nextLine();
		String kc=in.nextLine();
		int m=0,n=0;
		 for(int i=0;i<cou.C;i++){
			 if(kc.equals(cou.c[i].couName)){//寻找课程
				 m=1;
				 for(int j=0;j<stu.S;j++){
					 if(xh.equals(stu.s[j].stuNo)){//寻找学生
						 n=1;
						 if(grade[i][j]==0)
							 {System.out.println("该学生该门课程没有成绩");return;}
						 System.out.println("查找成功，学号:"+stu.s[j].stuNo+"   课程:"+cou.c[i].couName+"   成绩："+grade[i][j]);
					 }
					 }
				 }
			 }
			 if(m==0){ {System.out.println("没有找到对应课程信息");}
			 for(int j=0;j<stu.S;j++){
				 if(xh.equals(stu.s[j].stuNo)){n=1;}}
				 if(n==0) {System.out.print("没有找到对应学生信息");return;}
			 }{for(int j=0;j<stu.S;j++){
				 if(xh.equals(stu.s[j].stuNo)){
					 n=1;}}
				 if(n==0) {System.out.print("没有找到对应学生信息");}
			 }
	}
	public void highestcj(Student stu,Course  cou){//统计每门课程的最高成绩
		double pd=0;int t = 0;
		int j,k=0;
		for(int x=0;x<cou.C;x++) {
			for(int y=0;y<stu.S;y++) {
				if(grade[x][y]>0) pd=1;
			}
		}
		if(pd==0) {System.out.print("没有成绩");return;}
		for(int i=0;i<cou.C;i++) {
			double max=0;
			for(j=0;j<stu.S;j++) {
				if(grade[i][j]>max) {
					max=grade[i][j];
					k=j;}
			}
			System.out.println(""+cou.c[i].couName+"课程的最高分是:"+max+"\t"+"学号:"+stu.s[k].stuNo);
		}
	}
	public void kcpjcj(Student stu,Course  cou) {//统计每门课程的平均成绩
		int i,j;
		double pd=0;
		for(int x=0;x<cou.C;x++) {
			for(int y=0;y<stu.S;y++) {
				if(grade[x][y]>0) pd=1;
			}
		}
		if(pd==0) {System.out.print("没有成绩");return;}
		for(i=0;i<cou.C;i++) {
			double t=0;
			int r=0;
			for( j=0;j<stu.S;j++) 
				t=t+grade[i][j];
			System.out.println(""+cou.c[i].couName+"课程的平均分是:"+t/stu.S);
			for(j=0;j<stu.S;j++) {
				if(grade[i][j]>t/stu.S)
					r++;
			}
		}
	}
	public void cgpjrs(Student stu,Course  cou) {//统计超过平均成绩的人数
		int i,j;
		double pd=0;
		for(int x=0;x<cou.C;x++) {
			for(int y=0;y<stu.S;y++) {
				if(grade[x][y]>0) pd=1;
			}
		}
		if(pd==0) {System.out.print("没有成绩");return;}
		for(i=0;i<cou.C;i++) {
			double t=0;
			int r=0;
			for( j=0;j<stu.S;j++) {
				if(grade[i][j]>0){
				t=t+grade[i][j];}
			}
			for(j=0;j<stu.S;j++){
				if(grade[i][j]>t/stu.S)
					r++;
			}
			System.out.println(""+cou.c[i].couName+"课程超过平均分的人数是："+r+"人");		}}
}
