package com.OrangeHRM;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class LogFile {
	static File f;
	static FileWriter fw;
	static BufferedWriter bw;
	
	public static void openLogFile(String filePath) throws Throwable{
		f=new File(filePath);
		fw=new FileWriter(f);
		bw=new BufferedWriter(fw);		
		
	}
	
	public static void writeIntoLogFile(String data) throws Throwable{
		bw.write(new Date()+"  :  "+data+"\r\n");
	
		
	}
	
	public static void writeBlankLines() throws Throwable{
		bw.write("\r\n");

	
	}
	
	public static void closeLogfile() throws Throwable{
		bw.close();
		fw.close();
	}

}
