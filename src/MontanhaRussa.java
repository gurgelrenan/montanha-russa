public class MontanhaRussa implements Runnable {
	int tempoVoltaMontanha = Config.tempoVoltaMontanha;
	int tempoEmbarqueDesembarque = Config.tempoEmbarqueDesembarque;
	int numeroLugaresCarro = Config.numeroLugaresCarro;
	Carro carro;
	
	public MontanhaRussa(Carro carro) {
		this.carro = carro;
	}

	public void run() {
		System.out.println("Thread Montanha russa iniciada!");
		synchronized (this) {
			try {
				Thread.sleep(tempoVoltaMontanha * 1000);  //volta da montanha
				Thread.sleep(tempoEmbarqueDesembarque * 1000 * numeroLugaresCarro); // tempo de embarque e desembarque
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		System.out.println("Finalizada thread montanha russa");
	}
	
	public void init() {
		new Thread(this, "MontanhaRussa").start();
	}

}
