package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Cliente;
import com.senai.domain.repositories.ClienteRepository;

@SpringBootTest
public class ClienteTest {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Guilherme das Congonha");
		cli.setCpfOuCnpj("99338712457");
		cli.setEmail("guilhermao@gmail.com.br");
		clienteRepo.save(cli);
	}
	
	@Test
	public void listaCliente() {
		List<Cliente> list = clienteRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void idCliente() {
		Cliente cliente = clienteRepo.findById(1).get();
		assertEquals("Guilherme Henrique M. Andrade", cliente.getNome());
	}
	
	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepo.findById(2).get();
		cliente.setNome("Maquinobaldo da Silva");
		clienteRepo.save(cliente);
		assertNotEquals("Maquinobaldo Jorge Júnior", cliente.getNome());
	}
	
	@Test
	public void deleteClinte() {
		clienteRepo.deleteById(2);
		assertThat(clienteRepo.existsById(2));
	}
	
	
	//Teste das Operações Matemáticas 
	@Test
	public void somar() {
		double num1 = 5;
		double num2 = 10;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num1, num2);
		assertEquals(15, soma);
	}
	
	@Test
	public void subtrair() {
		double num1 = 10;
		double num2 = 5;
		Cliente cliente = new Cliente();
		double subtracao = cliente.subtrair(num1, num2);
		assertEquals(5, subtracao);
	}
	
	@Test
	public void multiplicar() {
		double num1 = 5;
		double num2 = 10;
		Cliente cliente = new Cliente();
		double multiplicacao = cliente.multiplicar(num1, num2);
		assertEquals(50, multiplicacao);
	}
	
	@Test
	public void dividir() {
		double num1 = 30;
		double num2 = 5;
		Cliente cliente = new Cliente();
		double divisao = cliente.dividir(num1, num2);
		assertEquals(6, divisao);
	}

}
