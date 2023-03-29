package conta.model;

public class Conta {
	//abstract
	
	private int Numero;
	private int Agencia;
	private int Tipo;
	private String Titular;
	private float Saldo;
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		super();
		Numero = numero;
		Agencia = agencia;
		Tipo = tipo;
		Titular = titular;
		Saldo = saldo;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public int getAgencia() {
		return Agencia;
	}
	public void setAgencia(int agencia) {
		Agencia = agencia;
	}
	public int getTipo() {
		return Tipo;
	}
	public void setTipo(int tipo) {
		Tipo = tipo;
	}
	public String getTitular() {
		return Titular;
	}
	public void setTitular(String titular) {
		Titular = titular;
	}
	public float getSaldo() {
		return Saldo;
	}
	public void setSaldo(float saldo) {
		Saldo = saldo;
	}
	
	public boolean sacar(float valor) {
		
		if(this.getSaldo() < valor ) {
			System.out.println("\n Saldo Insulficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
		
	}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo()+valor);
	}
	
	public void visualizar() {
		String Tipo = "";
		
		switch(this.Tipo) {
		case 1: 
			Tipo = "Conta Corrente";
			break;
		case 2: Tipo = "contaPoupança";break;
		}
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("***********************************************************");
		System.out.println("Numero da Conta: " + this.Numero);
		System.out.println("Agência: " + this.Agencia);
		System.out.println("Tipo da Conta: " + Tipo);
		System.out.println("Titular: " + this.Titular);
		System.out.println("Saldo: " + this.Saldo);
		
	}

}
