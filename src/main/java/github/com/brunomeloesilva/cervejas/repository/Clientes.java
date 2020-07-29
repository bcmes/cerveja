package github.com.brunomeloesilva.cervejas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.cervejas.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long>{

	public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

}
