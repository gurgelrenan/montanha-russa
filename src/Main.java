public class Main {
	
	public static void main(String[] args) {
		
		int numeroPassageiros = Config.numeroPassageiros;
		int numeroLugaresCarro = Config.numeroLugaresCarro;
		int numeroCarros = Config.numeroCarros;
		int tempoVoltaMontanha = Config.tempoVoltaMontanha;
		int tempoEmbarqueDesembarque = Config.tempoEmbarqueDesembarque;
		float tempoEntradaFilaMinimo = Config.tempoEntradaFilaMinimo;
		float tempoEntradaFilaMaximo = Config.tempoEntradaFilaMaximo;
		
		Carro carro = new Carro(numeroLugaresCarro);
		MontanhaRussa montanha = new MontanhaRussa(carro);
		Fila fila = new Fila();
		AlimentaFila alimentaFila = new AlimentaFila(fila);
		Maquinista maquinista = new Maquinista(fila, carro, montanha);
		
		alimentaFila.init();
		maquinista.init();
	}

}
