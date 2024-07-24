package br.com.ana;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.ana.dao.ClienteDAO;
import br.com.ana.dao.IClienteDAO;
import br.com.ana.domain.Cliente;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("1");
        cliente.setNome("ana alice");

        System.out.println("Tentando cadastrar cliente: " + cliente.getCodigo() + " - " + cliente.getNome());

        Integer qtd = dao.cadastrar(cliente);
        System.out.println("Cadastro realizado, linhas afetadas: " + qtd);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        System.out.println("Cliente consultado: " + clienteBD);
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        System.out.println("Cliente excluído, linhas afetadas: " + qtdDel);
        assertNotNull(qtdDel);
    }

    @Test
    public void atualizarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("2");
        cliente.setNome("joao silva");

        System.out.println("Tentando cadastrar cliente: " + cliente.getCodigo() + " - " + cliente.getNome());

        Integer qtd = dao.cadastrar(cliente);
        System.out.println("Cadastro realizado, linhas afetadas: " + qtd);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        System.out.println("Cliente consultado: " + clienteBD);
        assertNotNull(clienteBD);

        clienteBD.setNome("joao silva atualizado");
        Integer qtdAtualizada = dao.atualizar(clienteBD);
        System.out.println("Cliente atualizado, linhas afetadas: " + qtdAtualizada);
        assertTrue(qtdAtualizada == 1);

        Cliente clienteAtualizado = dao.consultar(clienteBD.getCodigo());
        assertEquals("joao silva atualizado", clienteAtualizado.getNome());

        Integer qtdDel = dao.excluir(clienteAtualizado);
        System.out.println("Cliente excluído, linhas afetadas: " + qtdDel);
        assertNotNull(qtdDel);
    }

    @Test
    public void consultarTodosTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("3");
        cliente1.setNome("maria jose");

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("4");
        cliente2.setNome("jose maria");

        dao.cadastrar(cliente1);
        dao.cadastrar(cliente2);

        List<Cliente> clientes = dao.consultarTodos();
        System.out.println("Clientes consultados: " + clientes);
        assertNotNull(clientes);
        assertTrue(clientes.size() >= 2);

        for (Cliente cliente : clientes) {
            dao.excluir(cliente);
        }
    }
}
