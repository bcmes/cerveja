package github.com.brunomeloesilva.cervejas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.cervejas.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long>{

}
