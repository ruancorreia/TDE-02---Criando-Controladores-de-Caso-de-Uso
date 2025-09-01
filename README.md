# Sistema de Gestão Acadêmica com Padrão MVC e Controladores de Caso de Uso

## 1. Visão Geral do Projeto

Este projeto é uma aplicação Java de linha de comando que implementa um sistema simples para gestão de Cursos e Alunos. Foi desenvolvido com um forte foco em boas práticas de arquitetura de software, demonstrando uma implementação clara do padrão **MVC (Model-View-Controller)** e a utilização de **Controladores de Caso de Uso** para gerenciar as funcionalidades do sistema.

A aplicação permite que o usuário interaja através de um menu no terminal para incluir e listar cursos e alunos, garantindo a integridade dos dados através de validações na camada de modelo.

## 2. Arquitetura e Padrões de Projeto

O código é estruturado para garantir a separação de responsabilidades, alta coesão e baixo acoplamento entre os componentes.

### Model-View-Controller (MVC)

* **Model**: Representa os dados e as regras de negócio da aplicação. Contém as classes `Curso`, `Aluno` e a exceção personalizada `ModelException`. Esta camada é totalmente independente da interface.
* **View**: A camada de visualização é representada pelo próprio terminal. O `CtrlPrograma` é responsável por renderizar os menus e as listas de dados para o usuário.
* **Controller**: A camada de controle é dividida em duas responsabilidades distintas:

    1.  **Controlador Principal (`CtrlPrograma`)**: Atua como o ponto de entrada e **despachante** (dispatcher). Sua única função é exibir o menu principal e delegar a ação do usuário para o controlador de caso de uso apropriado.

    2.  **Controladores de Caso de Uso (`CtrlIncluirCurso`, `CtrlIncluirAluno`)**: Cada classe nesta categoria é responsável por orquestrar um único fluxo de negócio. Por exemplo, `CtrlIncluirCurso` gerencia todo o processo de cadastrar um novo curso, desde a coleta dos dados do usuário até a sua persistência.

### Data Access Object (DAO)

* O projeto utiliza o padrão DAO (`DaoCurso`, `DaoAluno`) para abstrair a lógica de persistência dos dados. Nesta versão, a persistência é simulada em memória através de listas estáticas.

## 3. Funcionalidades Implementadas

* **Incluir Curso**: Permite o cadastro de um novo curso com código e nome.
* **Incluir Aluno**: Permite o cadastro de um novo aluno, associando-o obrigatoriamente a um curso já existente.
* **Listar Cursos**: Exibe a lista de todos os cursos cadastrados, incluindo o número de alunos matriculados em cada um.
* **Listar Alunos**: Exibe a lista completa de alunos, incluindo o curso em que estão matriculados.
* **Validação de Dados**: Regras de negócio, como códigos e matrículas maiores que zero, são validadas na camada de Modelo antes da criação dos objetos.

## 4. Tecnologias e Conceitos Aplicados

* **Linguagem**: Java
* **Padrões de Projeto**:
    * Model-View-Controller (MVC)
    * Controlador de Caso de Uso
    * Data Access Object (DAO)
* **Princípios**: Separação de Responsabilidades (SoC), Programação Orientada a Objetos (POO).

## 5. Como Executar o Projeto

Para compilar e executar a aplicação, siga os passos abaixo.

### Pré-requisitos
* **JDK (Java Development Kit)** instalado e configurado no seu sistema.

### Passos para Execução

1.  **Clone o repositório** ou baixe os arquivos para uma pasta em seu computador.

2.  **Abra o terminal** ou prompt de comando e navegue até a pasta raiz do projeto.

3.  **Compile todos os arquivos-fonte** com o seguinte comando. Ele irá gerar os arquivos `.class` na estrutura de pacotes correta.

    ```bash
    # Se os seus arquivos .java estão na pasta 'src'
    javac -d . src/controller/*.java src/model/*.java src/model/dao/*.java
    ```

4.  **Execute a aplicação** chamando a classe principal.

    ```bash
    java controller.CtrlPrograma
    ```

5.  O menu principal será exibido no terminal, e você poderá interagir com as opções disponíveis.
