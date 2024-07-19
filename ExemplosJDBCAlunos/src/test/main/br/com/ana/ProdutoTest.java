package br.com.ana;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.ana.dao.ProdutoDAO;
import br.com.ana.domain.Produto;

public class ProdutoTest {

    @Test
    public void cadastrarTest() throws Exception {
        ProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("1");
        produto.setNome("Notebook");
        produto.setDescricao("Notebook Dell Inspiron");
        produto.setPreco(3500.00);
        produto.setDisponivel(true);

        System.out.println("Cadastrando produto...");
        Integer quant = dao.cadastrar(produto);
        assertTrue(quant == 1);
        System.out.println("Produto cadastrado com sucesso!");

        System.out.println("Consultando produto cadastrado...");
        Produto produtoDB = dao.consultar("1");
        assertNotNull(produtoDB);
        assertNotNull(produtoDB.getId());
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getDescricao(), produtoDB.getDescricao());
        assertEquals(produto.getPreco(), produtoDB.getPreco());
        assertEquals(produto.getDisponivel(), produtoDB.getDisponivel());
        System.out.println("Produto consultado com sucesso!");

        System.out.println("Atualizando produto...");
        produto.setNome("Outro nome prod");
        produto.setDescricao("Notebook Dell Inspiron Atualizado");
        produto.setPreco(3600.00);
        produto.setDisponivel(false);
        Integer quantAlt = dao.atualizar(produto);
        assertTrue(quantAlt == 1);
        System.out.println("Produto atualizado com sucesso!");

        System.out.println("Consultando produto atualizado...");
        Produto produtoAtualizadoDB = dao.consultar("1");
        assertNotNull(produtoAtualizadoDB);
        assertEquals(produto.getCodigo(), produtoAtualizadoDB.getCodigo());
        assertEquals(produto.getNome(), produtoAtualizadoDB.getNome());
        assertEquals(produto.getDescricao(), produtoAtualizadoDB.getDescricao());
        assertEquals(produto.getPreco(), produtoAtualizadoDB.getPreco());
        assertEquals(produto.getDisponivel(), produtoAtualizadoDB.getDisponivel());
        System.out.println("Produto atualizado consultado com sucesso!");

        System.out.println("Consultando todos os produtos...");
        List<Produto> listaProdutos = dao.consultarAll();
        assertNotNull(listaProdutos);
        for (Produto produtoBDAll : listaProdutos) {
            assertNotNull(produtoBDAll.getId());
            assertNotNull(produtoBDAll.getCodigo());
            assertNotNull(produtoBDAll.getNome());
        }
        System.out.println("Todos os produtos consultados com sucesso!");

        System.out.println("Excluindo produto...");
        Integer quantDel = dao.excluir(produtoAtualizadoDB);
        assertEquals(Integer.valueOf(1), quantDel);
        System.out.println("Produto excluído com sucesso!");

        System.out.println("Consultando produto excluído...");
        Produto produtoExcluidoDB = dao.consultar("1");
        assertNull(produtoExcluidoDB);
        System.out.println("Produto excluído consultado com sucesso!");

        // Verificação adicional diretamente no banco de dados
        System.out.println("Verificando diretamente no banco de dados...");
        List<Produto> produtosNoBanco = dao.consultarAll();
        boolean produtoAindaExiste = produtosNoBanco.stream().anyMatch(p -> "1".equals(p.getCodigo()));
        assertTrue(!produtoAindaExiste);
        System.out.println("Verificação direta no banco de dados concluída com sucesso!");
    }
}
