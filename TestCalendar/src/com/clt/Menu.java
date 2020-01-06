package com.clt;


import java.util.*;
import java.io.*;
class MainMenu {
	static Course cou=new Course();
	static Grade gra=new Grade();
	static Student stu=new Student(); 
	static boolean up=false;
	public int mainMemu(){
		System.out.println("\n\t\t班级学生管理系统");
		System.out.println("\n");
		System.out.println("\t******************");
		System.out.println("\t*1:学生信息管理*******");
		System.out.println("\t*2:课程信息管理*******");
		System.out.println("\t*3:学生成绩管理*******");
		System.out.println("\t*4:成绩统计结果*******");
		System.out.println("\t*5:初始化信息   *******");
		System.out.println("\t*0:退出系统**********");
		System.out.println("\t******************");
		System.out.println("请选择操作编号：");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		while(choice<0||choice>5){
			System.out.println("编号选择错误，请输入正确的编号：");
			choice=in.nextInt();
		}
		return choice;
		}
	public int xuesgl() throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println("\n\t\t学生信息管理系统");
		System.out.println("\n");
		System.out.println("\t*******************");
		System.out.println("\t*1:增加学生信息");
		System.out.println("\t*2:修改学生信息");
		System.out.println("\t*3:删除学生信息");
		System.out.println("\t*4:查询学生信息");
		System.out.println("\t*5:浏览学生信息");
		System.out.println("\t*0:返回上一级");
		System.out.println("\t********************");
		System.out.println("请选择操作编号：");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		while(choice<0||choice>5){
			System.out.println("编号选择错误，请输入正确的编号：");
			choice=in.nextInt();
		}
		switch(choice){
		case 1:{{stu.inputStu();up=true;}xuesgl();break;}
		case 2:{{stu.xgxs();up=true;}xuesgl();break;}
		case 3:{{stu.scxs(cou,gra);up=true;}xuesgl();break;}
		case 4:{{stu.czxs();}xuesgl();break;}
		case 5:{{stu.showallStu(cou,gra);}xuesgl();break;}
		}
		selectOperat();
		return choice;
	}
	public int kecgl() throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println("\n\t\t课程信息管理系统");
		System.out.println("\n");
		System.out.println("\t*******************");
		System.out.println("\t*1:增加课程信息");
		System.out.println("\t*2:查询课程信息");
		System.out.println("\t*3:修改课程信息");
		System.out.println("\t*4:删除课程信息");
		System.out.println("\t*5:浏览课程信息");
		System.out.println("\t*0:返回上一级");
		System.out.println("\t********************");
		System.out.println("请选择操作编号：");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		while(choice<0||choice>5){
			System.out.println("编号选择错误，请输入正确的编号：");
			choice=in.nextInt();
		}
			switch(choice){
			case 1:{{cou.inputcou();up=true;}kecgl();break;}
			case 2:{cou.czkc();kecgl();break;}
			case 3:{{cou.xgkc();up=true;}kecgl();break;}
			case 4:{{cou.sckc(stu,gra);up=true;}kecgl();break;}
			case 5:{cou.showallcou(stu,gra);kecgl();break;}
			}
		selectOperat();
		return choice;
	}
	public int chengjgl() throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println("\n\t\t学生成绩管理系统");
		System.out.println("\n");
		System.out.println("\t***********************");
		System.out.println("\t*1:按课程名录入学生成绩");
		System.out.println("\t*2:按学生学号录入成绩");
		System.out.println("\t*3:录入某门课程某个学生的成绩");
		System.out.println("\t*4:按学生学号查找学生成绩");
		System.out.println("\t*5:按课程名称查找学生成绩");
		System.out.println("\t*6:查找某门课程某个学生的成绩");
		System.out.println("\t*7:修改某门课程某个学生的成绩");
		System.out.println("\t*0:返回上一级");
		System.out.println("\t***********************");
		System.out.println("请选择操作编号：");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		while(choice<0||choice>7){
			System.out.println("编号选择错误，请输入正确的编号：");
			choice=in.nextInt();
		}
			switch(choice){
			case 1:{{gra.kclr(stu,cou);up=true;}chengjgl();break;}
			case 2:{{gra.xslr(stu,cou);up=true;}chengjgl();break;}
			case 3:{{gra.drlr(stu,cou);up=true;}chengjgl();break;}
			case 4:{gra.xscjcz(stu,cou);chengjgl();break;}
			case 5:{gra.kccjcz(stu,cou);chengjgl();break;}
			case 6:{gra.drcjcz(stu,cou);chengjgl();break;}
			case 7:{{gra.xgcj(stu,cou);up=true;}chengjgl();break;}
			}
		selectOperat();	
		return choice;
	}
	public int chengjtj() throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println("\n\t\t成绩统计系统");
		System.out.println("\n");
		System.out.println("\t*******************");
		System.out.println("\t*1:单科王信息");
		System.out.println("\t*2:每门课程的平均成绩");
		System.out.println("\t*3:超过某门课程平均成绩的人数");
		System.out.println("\t*0:返回上一级");
		System.out.println("\t********************");
		System.out.println("请选择操作编号：");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		while(choice<0||choice>3){
			System.out.println("编号选择错误，请输入正确的编号：");
			choice=in.nextInt();
		}
			switch(choice){
			case 1:{gra.highestcj(stu,cou);chengjtj();break;}
			case 2:{gra.kcpjcj(stu,cou);chengjtj();break;}
			case 3:{gra.cgpjrs(stu,cou);chengjtj();break;}
			}
		selectOperat();	
		return choice;
	}
	public void selectOperat() throws FileNotFoundException, IOException, ClassNotFoundException {
		int choice;
		choice=mainMemu();
		switch(choice){
		case 1:{xuesgl();break;}
		case 2:{kecgl();break;}
		case 3:{chengjgl();break;}
		case 4:{chengjtj();break;}
		case 5:{new file().clear();break;}
		case 0:{System.out.println("谢谢使用本系统，再见！");
		System.exit(0);}
		}
	}
}
    public class Menu{
	 public static void main(String[]args) throws FileNotFoundException, IOException, ClassNotFoundException{
		File a=new File("e:/student.txt");
		File b=new File("e:/course.txt");
		File c=new File("e:/grade.txt");
		File d=new File("e:/studentnum.txt");
		File e=new File("e:/coursenum.txt");
		MainMenu m=new MainMenu();
		new Thread(new mythread()).start();
		if(a.length()==0||b.length()==0||c.length()==0||d.length()==0||e.length()==0) {
			m.selectOperat();
		}
		else {
			new file().read();
			m.selectOperat();
		}
	}
}
