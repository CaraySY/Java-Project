package com.wsy.step_one.chapter5;

/**
 * 	使用守护线程强制关闭线程
 * @author Administrator
 *
 */
public class ThreadCloseForce2 {
	
	public static void main(String[] args) {
		
		ThreadService threadService=new ThreadService();
		long start=System.currentTimeMillis();
		threadService.execute(()->{
			// load a heavy task....
			//while(true) {
				
			//}
			try {
				Thread.sleep(5_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		threadService.shutdown(10_000);
		long end=System.currentTimeMillis();
		System.out.println("finished time:"+(end-start)+"ms");
	}
}
