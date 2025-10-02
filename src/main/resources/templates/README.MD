# Challenge Mottu

Challenge Mottu é um sistema de gerenciamento de vagas de motocicletas desenvolvido em Java com Spring Boot, projetado para facilitar a administração, reserva e controle de vagas em estacionamentos destinados a motocicletas.

---

## Tecnologias Utilizadas

- **Java JDK 21**
- **Spring Boot 3.5.5**
- Arquitetura **MVC** (Model-View-Controller)
- **Spring Data JPA** para acesso e manipulação da base de dados
- **Thymeleaf** como motor de templates para interface web
- APIs **REST** para integração com outros sistemas

---

## Funcionalidades Principais

- Cadastro e gerenciamento de vagas para motocicletas
- Controle de ocupação em tempo real
- Reservas e liberações de vagas via interface web
- APIs REST para consulta e manipulação de dados externas
- Visualização de relatórios e estatísticas de uso

---

## Estrutura do Projeto

- **Model:** Entidades JPA que representam a estrutura do banco de dados
- **View:** Templates Thymeleaf para renderização dinâmica das páginas web
- **Controller:** Controladores Spring MVC que manipulam requisições HTTP
- **Repository:** Interfaces Spring Data para acesso aos dados no banco

---

## Requisitos

- Java JDK 21 instalado
- Banco de dados configurado (ex.: PostgreSQL, MySQL, H2 para testes)
- Maven ou Gradle para gerenciamento das dependências
- IDE recomendada: IntelliJ IDEA, Eclipse ou VSCode

---

## Como Executar

1. Clone o repositório:
   ```
git clone https://github.com/seu-usuario/challenge-mottu.git
   ```
2. Navegue até o diretório do projeto:
   ```
cd challenge-mottu
   ```
3. Configure as propriedades de conexão no arquivo `application.properties` ou `application.yml`.
4. Compile e rode o projeto com Maven:
   ```
mvn spring-boot:run
   ```
   Ou com Gradle:
   ```
./gradlew bootRun
   ```
5. Acesse a aplicação via navegador em:
   ```
http://localhost:8080
   ```

---



## Padrões e Boas Práticas

- Código estruturado seguindo princípios SOLID
- Uso de DTOs para comunicação via API REST
- Validação de dados na entrada e tratamento de exceções globais
- Configuração para internacionalização (i18n) básica na interface web
- Testes unitários e de integração recomendados

---

---

Desenvolvido por RUAN LIMA, RICHARDY BORGES E MARCOS VINICIUS – 2025
```