# Projeto iFood (Java - MVC)

## Estrutura
- **Model**: Entidades (`Customer`, `DeliveryPerson`, `Restaurant`, `MenuItem`, `Order`, `Person`)
- **Repository**: CRUD em `ArrayList` com interface `CrudRepository`
- **Service**: Regras de negócio e validações
- **Controller**: Camada intermediária entre View e Service
- **View**: Menu no console (`MainView.java`)
- **App.java**: Ponto de entrada

## Requisitos Implementados
✔ MVC  
✔ 5 entidades com CRUD  
✔ Herança (Person → Customer/DeliveryPerson)  
✔ Polimorfismo (`getDetails()` sobrescrito)  
✔ Encapsulamento (atributos privados + getters/setters)  
✔ Interfaces (CrudRepository)  
✔ Tratamento de erros simples no menu  
✔ Serviços e repositórios separados  

## Como rodar
1. Instale **Java 17+**.
2. Compile:
   ```bash
   javac -d bin $(find src/main/java -name "*.java")
