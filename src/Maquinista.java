public class Maquinista implements Runnable {

	int delayMaquinista = Config.delayMaquinista;
	Fila fila;
	Carro carro;
	MontanhaRussa montanha;

	public Maquinista(Fila fila, Carro carro, MontanhaRussa montanha) {
		this.fila = fila;
		this.carro = carro;
		this.montanha = montanha;
	}
	
	//to do esvaziar carro so quando acabar volta da montanha russa
	
	public void run() {
		System.out.println("Thread Maquinista inciado!");
		while (true) {
			try {  
				while(!fila.filaVazia() || carro.carroCheio() ) {
					boolean entrouNoCarro = carro.entraNaCarro();
					if (entrouNoCarro) {
						System.out.println("Entrou no carro");
						System.out.println("Qtd de pessoas no carro: " + carro.getNumPassageiros());
						fila.saiDaFila();
					} else { // o carro ja esta cheio, temos que rodar a montanha
						montanha.run();
						carro.esvaziarCarro();
					}
				}
				Thread.sleep(this.delayMaquinista * 1000);  //tempo em que o maquinista verifica a fila
				System.out.println("Maquinista verifica fila...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public void init() {
		new Thread(this, "Maquinista").start();
	}
}
