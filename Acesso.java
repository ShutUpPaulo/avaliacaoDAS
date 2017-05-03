
public class Acesso {

	public static final float VALOR_FRACAO = (float) 2.0;
	public static final float VALOR_HORA = (float) 7.0;
	public static final float VALOR_DIARIA = (float) 30.0;
	
	public String placa;
	public int dia, mes, ano;
	public int horaEntrada, 
	           minutosEntrada;
	public int horaSaida, 
			   minutosSaida;
	


	public Acesso() {}

	
	public Acesso(int dia, int mes, int ano, int horaEntrada, int minutosEntrada) { 
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.horaEntrada = horaEntrada;
		this.minutosEntrada = minutosEntrada;
	}
	
	public int quantidadeHoras(){
		int quantidadeHoras = horaSaida - horaEntrada; 
		
		return quantidadeHoras;
	}
	
	public boolean horaSaidaMaiorQueEntrada(){
		
		if (horaSaida > horaEntrada)
			return true;
		else return false;
	}
	
	public boolean maisDeUmaHora(){
		
		if (horaSaidaMaiorQueEntrada() && minutosEntrada < minutosSaida)
			return true;
		else return false;
	}
	
	public int quantidadeMinutos(){
		int quantidadeHoras = quantidadeHoras();
		int quantidadeMinutos;
		
		if (horaSaida == horaEntrada)
			quantidadeMinutos = minutosSaida - minutosEntrada;
		else if (horaSaidaMaiorQueEntrada() && minutosEntrada == minutosSaida){
			quantidadeMinutos = 0;
		}
		else if (maisDeUmaHora()) 
			quantidadeMinutos = minutosSaida - minutosEntrada;
		else if (maisDeUmaHora()){
			quantidadeMinutos = minutosSaida + (60 - minutosEntrada);
			quantidadeHoras-= 1;
		}
		else {
			quantidadeHoras = 0;
			quantidadeMinutos = 0;
		}
		
		return quantidadeMinutos;
	}
	
	public float calcularValor() { 
		int quantidadeHoras = quantidadeHoras();
		int quantidadeMinutos = quantidadeMinutos(); 

		float valorTotal = 0; 
		valorTotal += quantidadeHoras * VALOR_HORA;
		valorTotal += Math.ceil(quantidadeMinutos / 15.0) * VALOR_FRACAO;		
		
		if (quantidadeHoras >=9)
			return VALOR_DIARIA;
		else 
			return valorTotal;
	}
	
	
	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}


	public void setMinutosSaida(int minutosSaida) {
		this.minutosSaida = minutosSaida;
	}
	
	
	
}
