package br.com.ana.dao;

import br.com.ana.domain.Cliente;
import java.util.List;

public interface IClienteDAO {
    
    public Integer cadastrar(Cliente cliente) throws Exception;
    public Cliente consultar(String codigo) throws Exception;
    public Integer excluir(Cliente clienteBD) throws Exception;
    public List<Cliente> consultarTodos() throws Exception;
    public Integer atualizar(Cliente cliente) throws Exception; // Novo método para atualizar um cliente
}
