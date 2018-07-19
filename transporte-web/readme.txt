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
  
  OBS: É possível configurar o jBoss AS 7.1.1.Final como serviço no windows seguindo instruções da comunidade no link: "https://developer.jboss.org/wiki/InstalandoJBossAS711ComoServicoNoWindowsServer2008X64"

