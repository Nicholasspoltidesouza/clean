# Usar a imagem base do Maven com OpenJDK 17
FROM maven:3.8.5-openjdk-17-slim

# Definir o diretório de trabalho no contêiner
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar o código-fonte do projeto
COPY src ./src

# Compilar o código do projeto
RUN mvn package -DskipTests

# Expor a porta que a aplicação vai rodar
EXPOSE 8000

# Comando para rodar a aplicação
CMD ["java", "-jar", "target/clean-0.0.1-SNAPSHOT.jar"]
