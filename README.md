# **Sistema de Gestão de Imóveis**

## **1. Contexto/Problema/Solução**

### **Contexto**

Gerenciar informações relacionadas a imóveis, proprietários, matrículas e histórico de alterações em um sistema digital que permita controle centralizado e eficiente. Atualmente, muitas empresas enfrentam dificuldades devido à utilização de documentos físicos e processos manuais, resultando em atrasos, inconsistências e perda de informações.

### **Problema**

- Registro e consulta de informações de imóveis realizados manualmente, aumentando o risco de erros.
- Dificuldade em manter um histórico das alterações realizadas nos registros.
- Falta de controle centralizado sobre os proprietários e suas propriedades.
- Impossibilidade de auditoria eficiente das ações realizadas no sistema.

### **Solução**

Implementar um sistema de gestão de imóveis com:

- Cadastro e consulta de imóveis, proprietários e matrículas.
- Auditoria das ações realizadas por meio de um padrão Observer.
- Interface simples e intuitiva para facilitar o uso.

---

## **2. Requisitos**

### **Funcionais**

- [ ]  Cadastro de usuários, proprietários, imóveis e matrículas.
- [ ]  Alteração e exclusão de registros.
- [ ]  Manter histórico das alterações realizadas em matrículas e propriedades.
- [ ]  Login e autenticação de usuários.
- [ ]  Função de administrador para gerenciamento de usuários.

### **Não Funcionais**

- [ ]  O sistema deve ser implementado em Java.
- [ ]  A base de dados deve ser mantida em memória (usando listas) para fins de simplificação.
- [ ]  O código deve ser modular e escalável.
- [ ]  Suporte a testes unitários e de integração.

## **3. Diagrama de casos de uso**

## **4. Diagrama de classes**

## **5. Diagrama de atividades**

https://www.notion.so/Sistema-de-Gest-o-de-Im-veis-154b0c98e8ce8010b462e2d266d38af1?pvs=4

## **6. Descrição dos Padrão Utilizado**

### **Padrão Observer**

- **Aplicação:** Utilizado para notificar automaticamente os observadores sobre alterações no estado de proprietários e matrículas.
- **Benefícios:**
    - Simplifica o gerenciamento de histórico.
    - Centraliza a lógica de notificação, evitando código duplicado.

## **7. Descrição dos testes de unidade e de integração**

1. **Classe: Imóvel**
    
    Testes realizados:
    
    testCriacaoImovel
    Valida a criação de objetos da classe Imóvel com atributos como endereço, tamanho e valor.
    
    Cenário: Um imóvel é criado com informações específicas e os atributos são verificados.
    
    Objetivo: Garantir que o construtor da classe funcione corretamente e que os atributos sejam armazenados conforme esperado.
    
    testCalcularImposto
    Verifica se o cálculo do imposto baseado no valor do imóvel está correto.
    
    Cenário: Um imóvel é criado, e o método calcularImposto é chamado. O resultado é comparado ao valor esperado.
    
    Objetivo: Testar a precisão da lógica de cálculo do imposto.
    

---

1. **Classe: Matrícula**
    
    Testes realizados:
    
    testCriacaoMatricula
    Avalia se uma matrícula é criada corretamente com o número de registro e a data de emissão.
    
    Cenário: Um objeto de matrícula é criado, e os atributos são verificados.
    
    Objetivo: Garantir a consistência na criação de matrículas.
    
    testAssociacaoImovel
    Verifica se um imóvel pode ser associado a uma matrícula corretamente.
    
    Cenário: Um imóvel é vinculado a uma matrícula. O método de associação é chamado, e a relação é verificada.
    
    Objetivo: Testar a funcionalidade de vincular matrículas a imóveis.
    

---

1. **Classe: Arquivo Digitalizado**

Testes realizados:

testBuscarArquivosPorData
Verifica se os arquivos digitalizados podem ser buscados por uma data específica.

Cenário: Vários arquivos são criados com diferentes datas, e a busca é feita para uma data existente e uma inexistente.

Objetivo: Garantir a precisão na busca por data.

testExtrairTextoOCR
Avalia se o método extrairTextoOCR retorna corretamente o texto extraído de um arquivo.

Cenário: Um arquivo é criado, e o método é chamado. O texto retornado é comparado ao esperado.

Objetivo: Validar a funcionalidade de extração de texto OCR.

---

1. **Classe: Histórico de Alteração**

Testes realizados:

testListarAlteracoesPorData
Confirma se o método retorna apenas as alterações de uma data específica.

Cenário: Alterações com datas diferentes são criadas. A busca é feita para uma data existente e uma inexistente.

Objetivo: Validar a filtragem por data.

testLimparDadosCompartilhados
Garante que os dados compartilhados entre as alterações sejam limpos antes de novos testes.

Cenário: O método de limpeza é chamado, e a lista compartilhada deve estar vazia após a execução.

Objetivo: Manter o ambiente de teste isolado.

---

1. **Classe: Histórico de Proprietário**

Testes realizados:

testRegistrarAlteracaoProprietario
Testa o registro de alterações de proprietários no histórico.

Cenário: Várias alterações são registradas para um imóvel. O histórico é verificado quanto à consistência.

Objetivo: Garantir que as alterações de proprietários sejam registradas corretamente.

testListarProprietariosHistorico
Verifica se o método retorna todos os proprietários registrados no histórico.

Cenário: O histórico é preenchido com vários proprietários. O método retorna a lista completa, que é comparada ao esperado.

Objetivo: Validar a listagem completa de proprietários no histórico.

---

1. **Classe: Proprietário**

Testes realizados:

testCriacaoProprietario
Confirma a criação de objetos Proprietário com nome, CPF e endereço.

Cenário: Um proprietário é criado, e seus atributos são comparados com os valores esperados.

Objetivo: Garantir a consistência na criação de proprietários.

testAssociarImovel
Testa se um imóvel pode ser associado a um proprietário corretamente.

Cenário: Um imóvel é vinculado a um proprietário. O vínculo é verificado após a associação.

Objetivo: Validar a funcionalidade de vincular imóveis a proprietários.

---

1. **Classe: Usuário**

Testes realizados:

testCriacaoUsuario
Avalia a criação de um usuário com nome, e-mail e senha.

Cenário: Um usuário é criado, e seus atributos são comparados aos valores fornecidos.

Objetivo: Garantir que a criação de usuários funcione corretamente.

testValidarCredenciais
Testa a validação de credenciais de login.

Cenário: Um usuário é criado com credenciais específicas. A validação é feita com credenciais corretas e incorretas.

Objetivo: Verificar a lógica de autenticação de usuários.

## **8. Mecânicas de Refatoração Aplicadas**

- **Extração de métodos:** Trechos de código repetitivo foram movidos para métodos reutilizáveis.
- **Aplicação de padrões:** O código foi modularizado usando o padrão Observer.
- **Nomenclatura:** Os nomes de variáveis e métodos foram revisados para melhorar a legibilidade.

---

## **9. Frameworks e Tecnologias Utilizadas**

- **Linguagem de Programação:** Java 23
- **Build Tool:** Maven
- **Biblioteca de Testes:** JUnit 5.10.0
- **IDE:** IntelliJ IDEA
- **Controle de Versão:** Git e GitHub
