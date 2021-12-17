package com.senai;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senai.domain.Cidade;
import com.senai.domain.Cliente;
import com.senai.domain.Endereco;
import com.senai.domain.Estado;
import com.senai.domain.enuns.TipoCliente;
import com.senai.domain.repositories.CidadeRepository;
import com.senai.domain.repositories.ClienteRepository;
import com.senai.domain.repositories.EnderecoRepository;
import com.senai.domain.repositories.EstadoRepository;

@SpringBootApplication
public class Senai3Application implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Senai3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Rio de Janeiro");
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Rio de Janeiro", est2);
		cidadeRepository.saveAll(Arrays.asList(c1,c2));
		
		Cliente cli1 = new  Cliente(null, "Guilherme Henrique M. Andrade", "22255577790", "guilhermehma2005@gmail.com", 
				TipoCliente.PESSOAFISICA);
		Cliente cli2 = new  Cliente(null, "Maquinobaldo Jorge Júnior", "77788822201", "maquinobaldotop@gmail.com", 
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("24000002345", "12124354987"));
		cli2.getTelefones().addAll(Arrays.asList("44444567789", "00000987656"));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		
		Endereco e1 = new Endereco(null, "Rua Martinesia", "322","", "Centro", "38345678",cli1,c1);
		Endereco e2 = new Endereco(null, "Rua São Paulo", "245","", "Jardim Brasília", "61677790",cli2,c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
