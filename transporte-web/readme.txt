Passos a serem seguidos.

- OBSERVAÇÕES IMPORTANTES

1. O código fonte está no github. Endereço: "https://github.com/renancelso/transporte"

2. O sistema foi desenvolvido na IDE Eclipse (Versão NEON), utilizando JDK 1.7 e servidor de aplicação jBoss AS 7.1.1.Final

3. Foi utilizado o Maven para gerenciar as dependências do projeto.

4. Descompactar o arquivo "Exercicio1.zip". 
   - Se necessário, seguir primeiramente o documento fornecido "01_Instalacao_MySql.docx"
   
5. É necessário baixar o servidor de aplicação "jboss-as-7.1.1.Final". Link utilizado: "http://jbossas.jboss.org/downloads"

6. É necessário configurar um datasource para a base mysql. Pode-se utilizar o documento "02_Configuracao_jboss-as-7.1.1.Final.docx" fornecido.

7. Dentro da pasta TARGET, é encontrado o artefato "transporte-web.war" da aplicação já pronta pra dar deploy no servidor de aplicação configurado. 

8. Caso o servidor esteja configurado e iniciado, basta colocar o arquivo dentro do diretório "jboss-as-7.1.1.Final\standalone\deployments"
  - Caso esteja utilizando a IDE Eclipse, pode-se fazer deploy através dela também.
  
  OBS: É possível configurar o jBoss AS 7.1.1.Final como serviço no windows seguindo instruções da comunidade no link: 
  "https://developer.jboss.org/wiki/InstalandoJBossAS711ComoServicoNoWindowsServer2008X64"

9. O sistema tem 2 menus (Transporte e Cadastro)

	- Dentro do menu Transporte, existe o submenu Calcular Custos com a principal funcionalidade do sistema:
	Neste exercício queremos que você desenvolva um pequeno aplicativo Web, que disponibilize
	uma página HTML simples onde seja possível informar os seguintes parâmetros:
		* distância em rodovia pavimentada
		* distância em rodovia não-pavimentada
		* veículo utilizado
		* carga transportada
	Ao submeter os dados do formulário, a página deve apresentar o custo do transporte que foi
	calculado.
	
	- Dentro do menu Cadastro, existem dois submenus, que são Veículo e Via.
	São telas de cadastro, exclusão, alteração e consulta dos veículos e das vias cadastradas para serem usadas no cálculo de custos.
	
10. Tudo já funciona dinamicamente, e o sistema já está preparado pra funcionar caso o usuário decida criar um novo tipo de via 
e/ou um novo tipo de veículo.

11. Dentro da pasta mysql, tem um arquivo chamado "transporte_backup.sql" com a estrutura e os dados das tabelas que o sistema usa já prontos para uso, 
contudo, os dados podem ser inseridos através do próprio sistema.

