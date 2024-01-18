# Projeto Sistema de Gerenciamento de Estoque - README

Este repositório contém a implementação de um sistema focado no gerenciamento de estoque de uma loja de varejo. Utilizan o banco de dados MySQL para armazenamento de dados, seguindo padrões modernos de desenvolvimento e design de software. A seguir, estão listados os principais requisitos e características do projeto:

<div align="center">
<img src="https://github.com/marcossbento/projetoSistemaGerenciamento/assets/99231673/00cc2643-e1ea-44ab-b1c6-a81ded20c937" width="800px">
</div>

# Banco de Dados em MySQL

O sistema utiliza o banco de dados MySQL para armazenar e gerenciar dados de maneira eficiente. Os arquivos .sql e .mwb fornecidos neste repositório contêm a estrutura do banco de dados, facilitando a implantação e manutenção.

<div align="center">
<img src="https://github.com/marcossbento/projetoSistemaGerenciamento/assets/99231673/56ddafe6-2aa8-4fb4-ae87-3ce086da5a1f" width="800px">
</div>

# Configuração da Aplicação por XML (AppConfig)

A configuração da aplicação é realizada por meio de arquivos XML, seguindo as práticas de boas configurações. O arquivo AppConfig.xml centraliza as configurações importantes, permitindo uma fácil adaptação do sistema a diferentes ambientes.

# Login (Usuário + Senha com Técnica de Proteção de Morris-Thompson 'Sal n-bits')

A autenticação de usuários é realizada por meio de um sistema seguro que utiliza a técnica de proteção de Morris-Thompson, incorporando um sal n-bits para aumentar a segurança. Isso garante a proteção adequada das credenciais dos usuários.

<div align="center">
<img src="https://github.com/marcossbento/projetoSistemaGerenciamento/assets/99231673/42aba66c-e8ec-4039-89d7-341c3a4fea73" width="800px">
</div>

# Geração de Exception Logs em XML

O sistema gera logs de exceção em formato XML, fornecendo informações detalhadas sobre eventos inesperados. Esses logs são essenciais para a identificação rápida e eficaz de problemas durante a execução da aplicação.

# Utilização dos Padrões MVC, DAO, Unity of Work e Singleton

O projeto segue as melhores práticas de arquitetura de software, implementando os padrões Model-View-Controller (MVC), Data Access Object (DAO), Unity of Work e Singleton. Esses padrões contribuem para a modularidade, manutenibilidade e escalabilidade do código-fonte.
