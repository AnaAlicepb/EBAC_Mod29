<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Sistema de Vendas desenvolvido no módulo 29">
    <meta name="keywords" content="Java, PostgreSQL, JUnit, Eclipse">
    <meta name="author" content="Ana Alice Rodrigues">
    
</head>
<body>

<header>
    <h1>Projeto VendasModulo29</h1>
    
</header>

<details>
    <summary>Índice</summary>
    <ol>
        <li><a href="#sobre-o-projeto">Sobre o projeto</a></li>
        <li><a href="#parte-tecnica">Parte Técnica</a></li>
        <li><a href="#estrutura-dos-arquivos">Estrutura dos Arquivos</a></li>
        <li><a href="#execucao-dos-testes">Execução dos Testes</a></li>
        <li><a href="#banco-de-dados">Banco de Dados</a></li>
        <li><a href="#ferramentas">Ferramentas</a></li>
        <li><a href="#contato">Contato</a></li>
    </ol>
</details>

<section id="sobre-o-projeto">
    <h2>Sobre o projeto</h2>
    <p>
        Este projeto é um sistema de vendas desenvolvido no contexto do módulo 29 do curso da EBAC. Ele permite o gerenciamento de clientes, produtos e vendas, utilizando Java, PostgreSQL e JUnit. O objetivo é oferecer uma experiência de aprendizado prática na implementação de funcionalidades básicas de um sistema de vendas.
    </p>
    <p>
        Proposta de Valor: Oferecer uma experiência de compra conveniente, com uma seleção diversificada de produtos, facilidade de navegação e processos de compra e entrega eficientes.
    </p>
</section>

<section id="parte-tecnica">
    <h2>Parte Técnica</h2>
    <ul>
        <li>Backend: Java é utilizado para a lógica do servidor, gerenciamento de sessões, autenticação de usuários e manipulação do carrinho de compras.</li>
        <li>Banco de Dados: PostgreSQL para armazenar dados de usuários, produtos, pedidos e detalhes de pagamento.</li>
    </ul>
</section>

<section id="estrutura-dos-arquivos">
    <h2>Estrutura dos Arquivos</h2>
    <pre>
ExemplosJDBCAlunos
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── br.com.ana.dao
│   │   │   │   ├── ClienteDAO.java
│   │   │   │   ├── IClienteDAO.java
│   │   │   │   ├── IProdutoDAO.java
│   │   │   │   ├── ProdutoDAO.java
│   │   │   ├── br.com.ana.dao.jdbc
│   │   │   │   ├── ConnectionFactory.java
│   │   │   ├── br.com.ana.domain
│   │   │   │   ├── Cliente.java
│   │   │   │   ├── Produto.java
│   ├── test
│       ├── java
│           ├── br.com.ana
│           │   ├── ClienteTest.java
│           │   ├── ProdutoTest.java
└── Referenced Libraries
    └── JUnit 4
    </pre>
</section>

<section id="execucao-dos-testes">
    <h2>Execução dos Testes</h2>
    <ol>
        <li><strong>Abrir o Eclipse</strong>: Abra o projeto no Eclipse IDE.</li>
        <li><strong>Executar Testes</strong>: Clique com o botão direito no arquivo <code>ClienteTest.java</code> ou <code>ProdutoTest.java</code> e selecione <code>Run As > JUnit Test</code>.</li>
    </ol>
</section>

<section id="banco-de-dados">
    <h2>Banco de Dados</h2>
    <h3>Tabelas</h3>
    <h4>cliente</h4>
    <table>
        <thead>
            <tr>
                <th>Coluna</th>
                <th>Tipo</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>id</td>
                <td>BIGINT</td>
            </tr>
            <tr>
                <td>nome</td>
                <td>VARCHAR(255)</td>
            </tr>
            <tr>
                <td>codigo</td>
                <td>VARCHAR(255)</td>
            </tr>
        </tbody>
    </table>
    <h4>produto</h4>
    <table>
        <thead>
            <tr>
                <th>Coluna</th>
                <th>Tipo</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>id</td>
                <td>BIGINT</td>
            </tr>
            <tr>
                <td>nome</td>
                <td>VARCHAR(255)</td>
            </tr>
            <tr>
                <td>codigo</td>
                <td>VARCHAR(255)</td>
            </tr>
            <tr>
                <td>descricao</td>
                <td>TEXT</td>
            </tr>
            <tr>
                <td>preco</td>
                <td>DECIMAL</td>
            </tr>
            <tr>
                <td>disponivel</td>
                <td>BOOLEAN</td>
            </tr>
        </tbody>
    </table>
    <h3>Sequences</h3>
    <ul>
        <li>cliente_id_seq</li>
        <li>produto_id_seq</li>
        <li>sq_cliente_2</li>
    </ul>
</section>

<section id="ferramentas">
    <h2>Ferramentas</h2>
    <ul>
        <li><img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white" alt="Badge Java"></li>
        <li><img src="https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="Badge JUnit"></li>
        <li><img src="https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white" alt="Badge PostgreSQL"></li>
        <li><img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white" alt="Badge Eclipse"></li>
    </ul>
</section>

<section id="contato">
    <h2>Contato</h2>
    <ul>
        <li><a href="https://linktr.ee/anaeanali5" target="_blank"><img src="https://img.shields.io/badge/Ana_Alice_Rodrigues-blue?style=for-the-badge" alt="Perfil de Ana Alice Rodrigues"></a></li>
    </ul>
</section>

</body>
</html>
