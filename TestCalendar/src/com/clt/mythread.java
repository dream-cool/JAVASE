package com.clt;

import java.io.IOException;
public class mythread implements Runnable {
	public void run() {
		while(true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
			if(MainMenu.up){
				try {
					new file().write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("文件写入失败！");
				}
				System.out.println("文件写入成功");
				MainMenu.up=false;
		}
		}
	}
}