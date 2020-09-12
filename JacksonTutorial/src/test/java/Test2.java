import java.util.Date;

public class Test2 {

	public static void main(String[] args) {
		
		Runtime r= Runtime.getRuntime();
		System.out.println("total heap:"+r.totalMemory());
		System.out.println("free heap:"+r.freeMemory());
		for (int i = 0; i < 10000; i++) {
			Date date= new Date();
			date=null;
		}
		System.out.println("heap size:"+r.freeMemory());
		r.gc();
		System.out.println("heap size after gc:"+r.freeMemory());
		System.gc();
		System.out.println("heap size after System gc:"+r.freeMemory());

	}

}
