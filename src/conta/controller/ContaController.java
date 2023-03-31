package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA conta número: " +numero+ " não foi encontrada!");
	
	}

	@Override
	public void listarTodas() {
		for (var conta: listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número: "+conta.getNumero()+ " foi criado com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getAgencia());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nAconta número: " +conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("\nA conta número: "+conta.getNumero() + " não foi encontrada!");
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			System.out.println("\nA conta número: "+numero+ " foi deletada com sucesso");		
			}else
				System.out.println("\nA conta númeri: "+numero+ " não foi encontrada!");
		}
		

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if (conta.sacar(valor) == true)
				System.out.println("\nSaque na conta número: "+numero+ " foi efetuado com sucesso!");
		}else
			System.out.println("\nConta número: "+numero+ " não foi encontrada!");
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nDepósito da conta número: "+numero+ " foi efeutado com sucesso!");
		} else
			System.out.println("\nA conta número: "+numero+ " não foi encontrada ou a conta destino não é uma conta corrente!");
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			contaDestino.depositar(valor);
			System.out.println("\nA transferência foi efetuada com sucesso!");
		}else
			System.out.println("\nA conta de origem e/ou destino n]ao foram encontradas");
		
	}
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta: listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
	public int retornaTipo(int numero) {
		for (var conta: listaContas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();			
		}
	}
	return 0;
}
}
