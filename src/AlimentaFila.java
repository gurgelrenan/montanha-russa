import java.util.Random;

public class AlimentaFila implements Runnable {
	
	int tempoEntradaFilaMinimo = Config.tempoEntradaFilaMinimo;
	int tempoEntradaFilaMaximo = Config.tempoEntradaFilaMaximo;
	int numeroPassageiros = Config.numeroPassageiros;
	Fila fila;
	
	public AlimentaFila(Fila fila) {
		this.fila = fila;
	}
	
	public void run() {
		System.out.println("Thread AlimentaFila Iniciada!");
		while(numeroPassageiros > 0) {
			int tempoAleatorio = (int) (Math.random() * (tempoEntradaFilaMaximo - tempoEntradaFilaMinimo) + tempoEntradaFilaMinimo);
			System.out.println("Tempo para o proximo entra na fila: " + tempoAleatorio);
			try {
				Thread.sleep(tempoAleatorio * 1000);
				fila.entraNaFila();
				this.numeroPassageiros--;
				
				System.out.println("Entrou na fila");
				System.out.println("Fila com: " + fila.getNumeroPassageirosNaFila());
				System.out.println("Numero de passageiros: " + this.numeroPassageiros);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread Finalizada!");
		System.out.println("Numero de pessoas na fila: " + fila.getNumeroPassageirosNaFila());
	}
	
	public void init() {
		new Thread(this, "AlimentaFila").start();
		
	}
}
