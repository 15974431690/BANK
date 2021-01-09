package com.hodo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Date2FileUtil {
	
	public void saveDataToFile(String fileName, String data) {
		
		BufferedWriter writer = null;
		
		File file;
		try {
			File file1 = new File("");
			String filePath1 = file1.getCanonicalPath()+File.separator+"resources"+File.separator+"data\\";
			System.out.println(filePath1);
			
			file = new File(filePath1 + fileName + ".txt");
			
			// 如果文件不存在，则新建一个
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			// 写入
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
				writer.write(data);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("文件写入成功！");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
	}

	public String getDatafromFile(String fileName) {
		
		BufferedReader reader = null;
		String laststr = "";
		
		try {
			
			File file1 = new File("");
			String filePath1 = file1.getCanonicalPath()+File.separator+"resources"+File.separator+"data\\";
			System.out.println(filePath1);
			
			String Path = filePath1 + fileName + ".txt";
			
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return laststr;
	}
}
