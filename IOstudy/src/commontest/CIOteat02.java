package commontest;

import java.util.List;
import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;

public class CIOteat02 {
public static void main(String[] srgs) throws IOException {
	String msg=FileUtils.readFileToString(new File("emp.txt"));
	System.out.println(msg);
	byte[] datas=FileUtils.readFileToByteArray(new File("emp.txt"));
	System.out.println(datas.length);
	
	
	List<String> msgs=FileUtils.readLines(new File("emp.txt"));
	for(String string:msgs) {
		System.out.println(string);
	}
    

}
}
