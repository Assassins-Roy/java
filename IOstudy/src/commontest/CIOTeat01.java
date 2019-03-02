package commontest;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class CIOTeat01 {
public static void main(String[] args) {
	long len=FileUtils.sizeOf(new File("src\\commontest\\CIOTeat01.java"));
      System.out.println(len);   
	len=FileUtils.sizeOf(new File("D:\\workplace\\IOstudy"));
    System.out.println(len);

}
}
