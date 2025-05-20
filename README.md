# ☁️ Desafio Java AWS – Integração com SQS, Lambda e S3

Este projeto demonstra a integração de uma aplicação Java com serviços da AWS utilizando **SQS**, **Lambda** e **S3**, simulando uma arquitetura assíncrona de processamento de mensagens e armazenamento de dados na nuvem.

---

## 📌 Objetivo

O objetivo deste projeto foi colocar em prática conceitos de:
- Comunicação assíncrona com **Amazon SQS**
- Execução de funções serverless com **AWS Lambda**
- Armazenamento de arquivos/dados no **Amazon S3**
- Processamento de mensagens em fila com um consumidor escrito em Java

---

## 🛠️ Tecnologias utilizadas

- **Java 11**
- **AWS SDK para Java**
- **Amazon SQS** – fila de mensagens
- **AWS Lambda** – execução automática de funções
- **Amazon S3** – armazenamento em nuvem
- **Maven** – gerenciamento de dependências
- **IntelliJ IDEA** – ambiente de desenvolvimento

---

## ⚙️ Como funciona

1. **Produção de mensagens**:  
   Uma mensagem é enviada para a fila **Amazon SQS**, simulando a entrada de um evento no sistema.

2. **Processamento com Lambda**:  
   Uma função Lambda configurada escuta a fila e, ao receber a mensagem, processa o conteúdo.

3. **Armazenamento no S3**:  
   A função Lambda envia os dados tratados para um bucket no **Amazon S3**, finalizando o ciclo.

---

## 🔁 Fluxo resumido

[Java App] → [SQS] → [Lambda] → [S3]


---

## 📁 Estrutura do projeto

src/
└── main/
└── java/
└── br/com/awsdesafio/
├── config/
├── service/
└── model/



- `config/`: configurações do AWS SDK e credenciais
- `service/`: lógica de envio e recebimento de mensagens
- `model/`: estrutura dos dados trafegados

---

## ✅ Funcionalidades

- Envio de mensagens para o SQS via aplicação Java
- Consumo das mensagens com AWS Lambda
- Armazenamento dos dados processados no S3
- Estrutura modular com boas práticas de organização

---

## 📦 Como rodar o projeto

> 💡 É necessário ter uma conta na AWS com permissões para SQS, Lambda e S3.

1. Clone este repositório  
   `git clone https://github.com/Akemi-Samantha/Desafio-Java-AWS-SQS-Lambda-S3`

2. Configure suas **credenciais AWS** (via `~/.aws/credentials` ou variáveis de ambiente)

3. Execute o método principal para envio de mensagens

4. Verifique a execução da função Lambda e o armazenamento no S3

---

## ✨ Sobre

Este projeto foi criado com foco em aprendizagem prática de cloud computing, eventos assíncronos e integração entre serviços da AWS.  
Foi desenvolvido com base no vídeo “[Integrando aplicações Java com AWS SQS, Lambda e S3](https://www.youtube.com/watch?v=rqOi8h1GDb8)” do canal **Codando com Will**, utilizado como guia de estudo e implementação prática.

Faz parte do meu processo de evolução como desenvolvedora backend com visão em soluções escaláveis e modernas.

---

## 👩‍💻 Por Akemi Samantha Nakayama

🔗 [LinkedIn](https://www.linkedin.com/in/akemi-samantha-nakayama-121622206/)  
🐙 [GitHub](https://github.com/Akemi-Samantha)


