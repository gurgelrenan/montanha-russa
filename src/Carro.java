public class Carro {
	private int numeroPassageirosNoCarro = 0;
	private int numeroDeAcentos;
	
	public Carro(int numeroDeAcentos) {
		this.numeroDeAcentos = numeroDeAcentos;
	}
	
	public int getNumPassageiros() {
		return this.numeroPassageirosNoCarro;
	}
	
	public boolean carroCheio() {
		if(this.numeroPassageirosNoCarro == this.numeroDeAcentos) {
			return true;
		} return false;
	}
	
	boolean entraNaCarro() {
		synchronized (this) {
			if(this.numeroPassageirosNoCarro < this.numeroDeAcentos) {
				this.numeroPassageirosNoCarro++;
				return true;
			}
			else {
				// carro cheio codigo -1
				return false;
			}
		}
	}
	
	void esvaziarCarro() {
		synchronized (this) {
			this.numeroPassageirosNoCarro = 0;
		}
		
	}

}
