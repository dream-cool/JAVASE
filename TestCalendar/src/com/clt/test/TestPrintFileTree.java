package com.clt.test;

import java.io.File;

/**
 * 使用递归算法打印目录树
 * @author Mrchen
 *
 */
public class TestPrintFileTree {
	public static void main(String[] args) {
	File f=new File("");
	printFile(f,0);
	}
	static void printFile(File file,int level)
	{
		for(int i=0;i<level;i++) {
			System.out.println("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files=file.listFiles();
			for(File temp:files) {
				printFile(temp, level+1);
			}
		}
	}

}
