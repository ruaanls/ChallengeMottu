# Challenge Mottu – Sistema de Gerenciamento de Galpão de Motos

Este projeto tem como objetivo otimizar o controle e a gestão das operações do galpão de motos da Mottu. Ele oferece uma plataforma robusta, composta por uma interface web administrativa e um conjunto de APIs REST que também são consumidas diretamente pelo aplicativo mobile da Mottu. Essa solução centraliza, automatiza e traz maior eficiência aos processos de monitoramento, reserva, manutenção e gestão das motocicletas.

---

## Contexto e Funcionamento
A empresa Mottu utiliza este sistema para gerenciar toda a frota de motocicletas presente em seu galpão, facilitando o acompanhamento da disponibilidade, controla entradas e saídas, registra manutenções, permite reservas (por parte dos usuários via app mobile) e oferece relatórios gerenciais para o time de operações. A solução garante sincronização real-time de dados, apoiando a tomada de decisão rápida e segura.

As principais funcionalidades e APIs do backend são expostas para serem consumidas pelo aplicativo mobile da Mottu, oferecendo uma experiência integrada entre equipe administrativa e motociclistas.

---

## Tecnologias Utilizadas
- **Java JDK 21**
- **Spring Boot 3.5.5**
- Arquitetura **MVC** (Model-View-Controller)
- **Spring Data JPA** para persistência de dados
- **Thymeleaf** para renderização das páginas web administrativas
- **APIs REST** para integração com o app mobile e outros sistemas
- **SQL Server da Azure (nuvem)** como banco de dados principal
- **Maven** para gerenciamento de dependências e build
- Integração com **Azure DevOps** e Azure Container Registry para CI/CD

---

## Persistência e Modelagem de Dados
O sistema armazena todas as informações essenciais no **SQL Server hospedado na Azure**, aproveitando recursos de segurança, escalabilidade e alta disponibilidade da nuvem.

Principais entidades:
- **Moto**: informações cadastrais, status, histórico de uso e manutenções
- **Vaga**: controle da alocação e disponibilidade
- **Reserva**: vínculo entre usuário/app e uma vaga específica
- **Usuário**: dados dos responsáveis administrativos ou motociclistas

A comunicação com o banco é feita de maneira estruturada e segura utilizando o Spring Data JPA, que abstrai consultas e manipulação dos dados.

---

## Como Executar Localmente
1. Clone este repositório:
   ```
   git clone https://github.com/seu-usuario/challenge-mottu.git
   ```
2. Navegue até o diretório do projeto:
   ```
   cd challenge-mottu
   ```
3. Configure as credenciais do Azure SQL Server no arquivo `application.properties` ou `application.yml`.
4. Compile e rode o projeto com Maven:
   ```
   mvn spring-boot:run
   ```
   Ou com Gradle:
   ```
   ./gradlew bootRun
   ```
5. Acesse a interface web em:
   ```
   http://mottusprint.brazilsouth.azurecontainer.io:8080
   ```
6. As APIs REST estarão disponíveis para uso por aplicações externas (incluindo o app mobile Mottu).

---

## Integração com DevOps – Deploy Automatizado na Azure
O projeto está totalmente integrado com pipelines do **Azure DevOps**, garantindo automação, agilidade e rastreabilidade no ciclo de vida da aplicação:

- **Push dos Commits**: A cada envio de código para o repositório, a pipeline é automaticamente disparada no Azure DevOps.
- **Build CI**: O código é compilado, dependências resolvidas e a aplicação é empacotada. Falhas interrompem o processo.
- **Criação de Release**: Após o build bem-sucedido, uma nova release é gerada.
- **Container Registry**: A image Docker da aplicação é criada e publicada no **Azure Container Registry**, mantendo as versões atualizadas.
- **Deploy Automatizado**: O pipeline pode executar o deployment automático da última versão do container para ambiente de homologação e/ou produção, conforme as regras da Mottu.
- **Monitoramento & Logs**: Todo o ciclo é registrado para rastreamento e auditoria.

---

## APIs REST e Integração Mobile
As APIs deste projeto são fundamentais para o funcionamento do **aplicativo mobile da Mottu**, possibilitando:
- Consulta de vagas, reservas e status das motos em tempo real
- Ação direta pelo usuário para reservar ou liberar uma moto/vaga
- Sincronização constante com os dados administrativos e operacionais

Essas mesmas APIs podem integrar eventualmente com outros sistemas parceiros, mediante implementação e autorização.

---

## Padrões e Boas Práticas Adotados
- Código estruturado e conforme princípios **SOLID**
- Validação adequada das operações e tratamento global de exceções
- Uso de DTOs nas APIs REST
- Internacionalização básica (i18n)
- Documentação clara e orientada para desenvolvedores e operadores

---

## Requisitos Para Desenvolvedores
- Java JDK 21 instalado
- Conta e base no Azure SQL Server configurada
- Maven ou Gradle
- IDE recomendada: IntelliJ IDEA, Eclipse ou VSCode

Dica: Para testes locais, pode-se configurar um banco de dados alternativo (ex: H2), mas para operação real utilize sempre a conexão fornecida pela Azure.

---

Desenvolvido por RUAN LIMA, RICHARDY BORGES E MARCOS VINICIUS – 2025