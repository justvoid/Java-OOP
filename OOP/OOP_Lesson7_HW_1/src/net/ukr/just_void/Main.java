package net.ukr.just_void;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		int docksNumber = 2;
		Ship ship1 = new Ship("Отважный", 10);
		Ship ship2 = new Ship("Суворый", 10);
		Ship ship3 = new Ship("Современный", 10);
		
		ExecutorService exc = Executors.newFixedThreadPool(docksNumber);
		Future<?> f1 = exc.submit(ship1);
		Future<?> f2 = exc.submit(ship2);
		Future<?> f3 = exc.submit(ship3);
		
		try {
			f1.get();
			f2.get();
			f3.get();
		}catch (InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
		
		exc.shutdown();
		try {
		System.out.println(exc.awaitTermination(30, TimeUnit.SECONDS)?"Все корабли успешно разгружены":"Что-то пошло не так...");}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
