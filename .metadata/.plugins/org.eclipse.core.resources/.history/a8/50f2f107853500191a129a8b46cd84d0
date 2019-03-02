package chat01;

import java.io.Closeable;
import java.io.IOException;

public class SxtUtils {
	public static void close(Closeable...targets) {
		for(Closeable target:targets) {
			
				try {
					if(null!=target) {
					target.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
