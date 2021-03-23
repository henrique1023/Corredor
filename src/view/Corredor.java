package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoas;

public class Corredor {

	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPessoa = 0; idPessoa < 4 ; idPessoa++) {
			Thread tPessoa = new ThreadPessoas(idPessoa, semaforo);
			tPessoa.start();
		}
	}

}
