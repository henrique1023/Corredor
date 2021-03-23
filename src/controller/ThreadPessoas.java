package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoas extends Thread{
	private int idPessoa;
	private Semaphore semaforo;
	public ThreadPessoas(int idPessoa, Semaphore semaforo) {
		this.semaforo = semaforo;
		this.idPessoa = idPessoa;
	}
	@Override
	public void run() {
		andando();
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}
	private void porta() {
		int tempo = (int) ((Math.random() * 2001) + 1000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A pessoa " + idPessoa + " esta abrindo a porta.");
		
		System.out.println("A pessoa " + idPessoa + " passou a porta.");
	}
	private void andando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 6) + 4);
		int tempo = 500;
		while(distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A pessoa de nº " + idPessoa + " andou "+ distanciaPercorrida + "Metros.");
		}
	}
}
