-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: Codding_school
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Alternative`
--

DROP TABLE IF EXISTS `Alternative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Alternative` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `explanatory_text` varchar(100) DEFAULT NULL,
  `order_in_system` int DEFAULT NULL,
  `correct` tinyint(1) DEFAULT NULL,
  `justification` varchar(100) DEFAULT NULL,
  `question_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `Alternative_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `Question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alternative`
--

LOCK TABLES `Alternative` WRITE;
/*!40000 ALTER TABLE `Alternative` DISABLE KEYS */;
/*!40000 ALTER TABLE `Alternative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `order_in_system` int DEFAULT NULL,
  `description` text,
  `active` tinyint(1) DEFAULT NULL,
  `icon_path` varchar(255) DEFAULT NULL,
  `color_code` varchar(255) DEFAULT NULL,
  `study_guide` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'Programa????o','programacao',1,'Programe nas principais linguagens e plataformas. Iniciantes s??o bem vindos nos cursos de l??gica e JavaScript.',1,'https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png','#00c86f',''),(2,'DevOps','devops',2,'Aprenda Git. Entenda a entrega cont??nua. Estude Linux. Gerencie servidores na nuvem. Explore o mundo de Internet das coisas e da rob??tica.',1,'https://www.alura.com.br/assets/api/formacoes/categorias/512/devops-transparent.png','#f16165',''),(3,'Business','business',0,'Agilidade. Pr??ticas de gest??o. Vendas. Lideran??a.',0,'https://www.alura.com.br/assets/api/formacoes/categorias/512/inovacao-gestao-transparent.png','#ff8c2a','');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `estimated_time` int DEFAULT NULL,
  `visible` tinyint(1) DEFAULT NULL,
  `target` text,
  `instructor` varchar(255) DEFAULT NULL,
  `description` text,
  `developed_skills` text,
  `subcategory_id` bigint NOT NULL,
  `study_guide` text,
  PRIMARY KEY (`id`),
  KEY `subcategory_id` (`subcategory_id`),
  CONSTRAINT `Course_ibfk_1` FOREIGN KEY (`subcategory_id`) REFERENCES `Subcategory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES (1,'Git e Github para Sobreviv??ncia','git-e-github-para-sobrevivencia',6,1,'Desenvolvedores em qualquer linguagem ou plataforma que desejam mais seguran??a para seus projetos com as ferramentas de controle de vers??o Git e GitHub.','Mario souto','-O que ?? Git? <br> *Introdu????o <br> *Para que serve Git? <br> *Utilidade de um VCS <br> *Instalando o Git <br> *Para saber mais: Instala????o <br> *Reposit??rios <br> *Primeiros passos <br>  <br> -Iniciando os trabalhos <br> *Salvando altera????es <br> *Primeira configura????o do Git <br> *Para saber mais: git status <br> *Vendo o hist??rico <br> *Para saber mais: git log <br> *Ignorando arquivos <br> *Para saber mais: Quando commitar <br>  <br> -Compartilhando o trabalho <br> *Reposit??rios remotos <br> *Servidor Git <br> *Trabalhando com reposit??rios remotos <br> *Sincronizando os dados <br> *Compartilhamos as altera????es <br> *GitHub <br> *Para saber mais: GitHub <br>  <br> -Trabalhando em equipe <br> *Branches <br> *Para saber mais: Ramifica????es <br> *Unindo o trabalho <br> *Merge de branches <br> *Atualizando a branch <br> *Rebase vs Merge <br> *Resolvendo conflitos <br> *Para saber mais: Conflitos com rebase <br>  <br> -Manipulando as vers??es <br> *Ctrl+Z no Git <br> *Desfazendo o trabalho <br> *Guardando para depois <br> *Salvando temporariamente <br> *Viajando no tempo <br> *Checkout <br>  <br> -Gerando entregas <br> *Vendo as altera????es <br> *Exibi????o das mudan??as com o diff <br> *Tags e releases <br> *Tags no GitHub <br> *Consolidando o seu conhecimento','Descubra o que ?? Git e Github? <br> Entenda um sistema de controle de vers??o <br> Salve e recupere seu c??digo em diferentes vers??es <br> Resolva merges e conflitos <br> Trabalhe com diferentes branches',5,''),(2,'Java e JPA: Consultas avan??adas performance e modelos complexos','java-jpa-consultas-avancadas-performance-modelos-complexos',10,1,'Pessoas desenvolvedoras que j?? conhecem o b??sico de JPA e queiram aprofundar os conhecimentos.','Rodrigo Ferreira','-Mais relacionamentos <br> *Apresenta????o <br> *Mapeando novas entidades <br> *Relacionamentos many-to-many <br> *Relacionamentos bidirecionais <br> *Teste do relacionamento bidirecional <br>  <br> -Consultas avan??adas <br> *Consultas com fun????es de agrega????o <br> *Consultas para relat??rios <br> *Consultas com select new <br> *Utilizando Named Queries <br>  <br> -Performance de consultas <br> *Entendendo Lazy e Eager <br> *Consultas com Join Fetch <br>  <br> -Criteria API <br> *Consultas com par??metros din??micos <br> *Consultas com Criteria API <br>  <br> -Outros t??picos <br> *Simplificando entidades com Embeddable <br> *Mapeamento de heran??a <br> *Mapeamento de chaves compostas <br> *Conclus??o','Saiba como modelar corretamente relacionamentos bidirecionais <br> Aprenda a utilizar o recurso de select new para realizar consultas avan??adas <br> Entenda a diferen??a entre relacionamentos EAGER e LAZY <br> Conhe??a o recurso de join fetch para planejar queries <br> Conhe??a a API de Criteria da JPA <br> Saiba como mapear entidades que utilizam heran??a e chave composta',2,''),(3,'Java OO: Introdu????o ?? Orienta????o a Objetos','java-introducao-orientacao-objetos',8,1,'Desenvolvedores que est??o come??ando com Java e querem aprender mais sobre OO.','Paulo Silveira','-O problema do paradigma procedural <br> *Paradigma procedural vs Objetos <br> *Id??ia central do paradigma OO <br> *Cheiro procedural <br>  <br> -Come??ando com Orienta????o a Objetos <br> *Primeira classe - Contas <br> *Caracter??sticas dos objetos <br> *Instancia????o atributos e refer??ncias <br> *Definindo tipos <br> *Segunda Inst??ncia <br> *Valores default de atributos <br> *Definindo valor de atributos <br> *Refer??ncias vs Objetos <br> *Refer??ncias de objetos <br> *M??o na massa: Criando as primeiras classes <br>  <br> -Definindo comportamento <br> *Nosso primeiro m??todo <br> *Sobre m??todos <br> *Como chamar um m??todo? <br> *Voc?? conhece o this? <br> *M??todos com retorno <br> *M??todos validos <br> *Onde usar o this? <br> *M??todos com refer??ncia e mais retorno <br> *Declara????o do m??todo <br> *M??o na massa: Criando m??todos <br>  <br> -Composi????o de objetos <br> *Composi????o de Objetos <br> *Extraindo o que ?? comum  <br> *Refer??ncia Null <br> *Problema n??o esperado <br> *Solucionando o problema no c??digo  <br> *O que aprendemos? <br> *M??o na massa: Refer??ncias <br>  <br> -Encapsulamento e visibilidade <br> *Atributos privados e encapsulamento <br> *P??blico x Privado <br> *Getters e Setters <br> *Criando Getters e Setters <br> *Getters e Setters de refer??ncia <br> *Vantagens de atributos privados <br> *M??o na massa: Criando Getters e Setters <br> *Para saber mais: Cuidado com o Modelo An??mico <br>  <br> -Construtores e membros est??ticos <br> *Construtores <br> *Utilizando Construtores <br> *Aonde est?? o erro? <br> *Static <br> *Por que n??o soma? <br> *M??os na massa: Criando construtores e vari??veis est??ticas <br> *Para saber mais: Reaproveitamento entre construtores','Domine o paradigma de programa????o mais usado no mercado de trabalho <br> Entenda o que s??o refer??ncias e objetos <br> Use atributos m??todos da instancia e da classe <br> Define objetos atrav??s de construtores <br> Aprenda sobre encapsulamento',1,''),(4,'Java JRE e JDK: Escreva o seu primeiro c??digo com Eclipse','java-primeiros-passos',8,1,'Desenvolvedores que querem come??ar com a linguagem Java.','Paulo Silveira','-O que ?? Java? <br> *A plataforma Java <br> *Benef??cio da JVM <br> *Quais caracter??sticas? <br> *Quais sistemas? <br> *Bytecode vs EXE? <br> *Sobre o Bytecode <br> *Para saber mais: o nome Bytecode <br>  <br> -Instala????o e o primeiro programa <br> *Instala????o do JDK no Windows <br> *JRE vs JDK <br> *Para saber mais: JVM vs JRE vs JDK <br> *Compile e rode seu primeiro programa Java <br> *Entrada da aplica????o <br> *Sobre a compila????o e execu????o <br> *Compilar e executar <br> *M??o na massa: Instalando o JDK <br> *M??o na massa: Escrevendo nosso primeiro c??digo <br>  <br> -Come??ando com Eclipse <br> *Instalando o Eclipse <br> *M??o na massa: Instale a IDE Eclipse <br> *Sobre IDEs e editores <br> *Dentro do Eclipse IDE <br> *Nosso programa rodando no Eclipse <br> *M??o na massa: Rodando nosso programa no Eclipse <br> *Projeto Java <br> *Sobre a View Navigator <br>  <br> -Tipos e vari??veis <br> *Tipo inteiro: int <br> *Criando uma vari??vel num??rica <br> *M??o na massa: Utilizando o tipo int <br> *Tipo flutuante: double <br> *Opera????es entre numeros <br> *M??o na massa: Utilizando o tipo double <br> *Convers??es e outros tipos <br> *Imprimindo texto e n??meros <br> *M??o na massa: Algumas convers??es em Java <br> *Para saber mais: Type Casting <br>  <br> -Trabalhando com caracteres <br> *Char e String <br> *Declarando String e char <br> *Qual ser?? o resultado? <br> *Vari??veis guardam valores <br> *Concatena????o de String e inteiros <br> *M??o na massa: Praticando char e String <br>  <br> -Praticando condicionais <br> *Testes com IF <br> *Trabalhando com if <br> *M??o na massa: A condicional if <br> *Boolean condicionais <br> *Tipo boolean <br> *Operador l??gico <br> *M??o na massa: Um pouco mais de if <br> *Escopo e inicializa????o de vari??veis <br> *Declara????o da vari??vel <br> *M??o na massa: Escopo de vari??veis <br> *Opcional: Al??quota com ifs <br> *Para saber mais: o comando switch <br>  <br> -Controlando fluxo com la??os <br> *La??o com while <br> *Enquanto isso o while... <br> *Fixando o la??o while <br> *Escopo nos la??os <br> *Um erro de compila????o... <br> *La??o com for <br> *Transformando while em for <br> *M??o na massa: La??os <br> *La??os encadeados <br> *Mais la??os com break <br> *Fixando o comando break <br> *Exercitando la??os aninhados e break <br> *M??o na massa: Aprofundando la??os <br> *Desafio Opcional: M??ltiplos de 3 <br> *Desafio opcional: Fatorial','JVM? JDK? JRE? Aprenda o que s??o essas siglas? <br> Compile e execute c??digo java <br> Aprenda a usar Eclipse <br> Veja como usar vari??veis e controle de fluxo <br> Conhe??a os principais tipos do Java',1,'');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Explanation`
--

DROP TABLE IF EXISTS `Explanation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Explanation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `explanatory_text` text,
  `title` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `order_in_system` int DEFAULT NULL,
  `section_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `section_id` (`section_id`),
  CONSTRAINT `Explanation_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `Section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Explanation`
--

LOCK TABLES `Explanation` WRITE;
/*!40000 ALTER TABLE `Explanation` DISABLE KEYS */;
/*!40000 ALTER TABLE `Explanation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Profile`
--

DROP TABLE IF EXISTS `Profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Profile` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Profile`
--

LOCK TABLES `Profile` WRITE;
/*!40000 ALTER TABLE `Profile` DISABLE KEYS */;
INSERT INTO `Profile` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_STUDENT');
/*!40000 ALTER TABLE `Profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Question`
--

DROP TABLE IF EXISTS `Question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Question` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `statement` varchar(255) DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `order_in_system` int DEFAULT NULL,
  `section_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `section_id` (`section_id`),
  CONSTRAINT `Question_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `Section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Question`
--

LOCK TABLES `Question` WRITE;
/*!40000 ALTER TABLE `Question` DISABLE KEYS */;
/*!40000 ALTER TABLE `Question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Section`
--

DROP TABLE IF EXISTS `Section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Section` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `order_in_system` int DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `test` tinyint(1) DEFAULT NULL,
  `course_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `Section_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `Course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Section`
--

LOCK TABLES `Section` WRITE;
/*!40000 ALTER TABLE `Section` DISABLE KEYS */;
/*!40000 ALTER TABLE `Section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subcategory`
--

DROP TABLE IF EXISTS `Subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subcategory` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `order_in_system` int DEFAULT NULL,
  `description` text,
  `active` tinyint(1) DEFAULT NULL,
  `category_id` bigint NOT NULL,
  `study_guide` text,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `Subcategory_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subcategory`
--

LOCK TABLES `Subcategory` WRITE;
/*!40000 ALTER TABLE `Subcategory` DISABLE KEYS */;
INSERT INTO `Subcategory` VALUES (1,'Java','java',1,'Java ?? uma grande plataforma presente em todo lugar: de corpora????es ?? bancos e governo. Desenvolva aplica????es robustas com um back-end e construa APIs.',1,1,''),(2,'Java e Persist??ncia','java-e-persistencia',2,'Java ?? uma grande plataforma presente em todo lugar: de corpora????es ?? bancos e governo. Desenvolva aplica????es robustas com um back-end e construa APIs.',1,1,''),(3,'PHP','php',3,'PHP ?? uma das linguagens mais utilizadas.',1,1,''),(4,'COBOL','cobol',0,'Cobol',0,1,''),(5,'Builds e Controle de vers??o','builds-e-controle-de-versao',1,'As ferramentas mais utilizadas para desenvolvimento: controle de vers??o com Git e Github al??m de build da aplica????o atrav??s de Maven.',1,2,'');
/*!40000 ALTER TABLE `Subcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'root','root@gmail.com','$2a$10$wDnEKq1mEfRqbMC/tT57weGzdsWmfAB4x.4aAbzlqqBtyo4Vnzq4i'),(2,'Aluno','aluno@gmail.com','$2a$10$wDnEKq1mEfRqbMC/tT57weGzdsWmfAB4x.4aAbzlqqBtyo4Vnzq4i');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Video`
--

DROP TABLE IF EXISTS `Video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Video` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `video_time` int DEFAULT NULL,
  `transcription` varchar(255) DEFAULT NULL,
  `activity` int DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `order_in_system` int DEFAULT NULL,
  `section_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `section_id` (`section_id`),
  CONSTRAINT `Video_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `Section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Video`
--

LOCK TABLES `Video` WRITE;
/*!40000 ALTER TABLE `Video` DISABLE KEYS */;
/*!40000 ALTER TABLE `Video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_profile` (
  `user_id` bigint NOT NULL,
  `profile_id` bigint NOT NULL,
  KEY `FKp9he0binjgjtpcrbrtfcys8iy` (`profile_id`),
  KEY `FKicn6th6qb3tmbp8x72hccvato` (`user_id`),
  CONSTRAINT `FKicn6th6qb3tmbp8x72hccvato` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  CONSTRAINT `FKp9he0binjgjtpcrbrtfcys8iy` FOREIGN KEY (`profile_id`) REFERENCES `Profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-02 14:02:48
