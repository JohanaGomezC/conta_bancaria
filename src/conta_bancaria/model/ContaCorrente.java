package conta_bancaria.model;

public class ContaCorrente extends Conta {//Classe que herda de Conta
	
	private float limite; //declaro a variavel propria da conta corrente como private 

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	//get e set para conseguir acessar os atributos de um jeito seguro
	public float getLimite() { 
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override //indica que o metodo esta sendo sobrescrito
	public boolean sacar(float valor) {
		
		if (this.getSaldo() + this.getLimite() < valor) {
			
			//questiona se tem dinheiro suficiente para sacar considerando o saldo da conta e o limite disponivel
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	@Override
	public void visualizar() { 
		//invocando metodo visualizar da Classe Conta para reaproveitar a visualização e sobrescrevo o que preciso mostrar
		super.visualizar();
		System.out.println("Límite de Crédito: R$ " + this.limite);
	}

}
