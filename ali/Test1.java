package others;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author leichao
 * @description:
 */
public class Test1 {

	List<Integer> data = new ArrayList();

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		String path1 = path+"/studyJava/src/main/resources/1.txt";
		String path2 = path+"/studyJava/src/main/resources/2.txt";
		String path3 = path+"/studyJava/src/main/resources/3.txt";
		try {
			Test1 test1 = new Test1();
			test1.readTxt(path1,",",1);
			//问号特殊字符
			test1.readTxt(path2,"[?]",2);
			Collections.sort(test1.data);
			Collections.reverse(test1.data);
			createFile(path3);
			fileChaseFW(path3,test1.data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readTxt(String filePath,String symbol,int cell) {
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				while ((lineTxt = br.readLine()) != null) {
//					System.out.println(lineTxt);
					String temp[] = lineTxt.split(symbol);
//					System.out.println(temp[cell]);
//					fileChaseFW(filePath2,temp[1]);
					data.add(Integer.parseInt(temp[cell]));
				}
				br.close();
			} else {
				System.out.println("文件不存在!");
			}
		} catch (Exception e) {
			System.out.println("文件读取错误!");
		}
	}


	/**
	 * 创建文件
	 * @param fileName
	 * @return
	 */
	public static boolean createFile(String fileName)throws Exception{
		try{
			File file = new File(fileName);
			if(!file.exists()){
				file.createNewFile();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 写入TXT，追加写入
	 * @param filePath
	 * @param content
	 */
	public static void fileChaseFW(String filePath, List<Integer> content) {
		try {
			//构造函数中的第二个参数true表示以追加形式写文件
			FileWriter fos = new FileWriter(filePath,true);
			BufferedWriter bw = new BufferedWriter(fos);
			for (Integer temp : content) {
				bw.write(temp+"");
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("文件写入失败！" + e);
		}
	}


}
