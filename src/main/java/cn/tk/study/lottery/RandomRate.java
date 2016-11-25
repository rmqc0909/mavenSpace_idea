package cn.tk.study.lottery;

import java.util.Random;


public class RandomRate {
	private Random random;

	public RandomRate() {
		this.random = null;
		this.random = new Random();
	}
	/** 
	 *返回概率，中奖返回true，否则返回false,中奖率80%
	 */
	public boolean randomLucky(int min, int max) {
		int randomNum = (int) Math.floor(this.random.nextFloat()
				* (max - min + 1))
				+ min;
		System.out.println("randomNum:" + randomNum);
		return (randomNum > 0 && randomNum <= 80);
	}
	public static void main(String[] args) {
		RandomRate gameMath = new RandomRate();
		boolean flag = gameMath.randomLucky(0, 100);
		System.out.println("中奖？" + flag);
	}

}
