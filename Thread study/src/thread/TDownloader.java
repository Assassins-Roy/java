package thread;

public class TDownloader extends Thread {
	private String url;
	private String name;
	public TDownloader(String url, String string) {
		this.url=url;
		this.name=name;
	}
	
	
	public void run() {
		WebDownloader wd=new WebDownloader();
		wd.download(url,name);
		
	}
	
	public static void main(String[] args) {
		TDownloader td1=new TDownloader("http://images.17173.com/2010/www/roll/201003/0301sohu01.jpg","a.jpg");
		//TDownloader td2=new TDownloader("","2.jpg");
		
		td1.start();
		//td2.start();
		
		
	}
}
