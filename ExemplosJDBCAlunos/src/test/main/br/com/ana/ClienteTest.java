package br.com.ana;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.ana.dao.ClienteDAO;
import br.com.ana.dao.IClienteDAO;
import br.com.ana.domain.Cliente;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
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
}
