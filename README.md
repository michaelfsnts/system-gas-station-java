
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)



# Sistema de Gerenciamento de Posto de Gasolina ⛽

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

---

## Visão Geral
Este projeto é um sistema desktop desenvolvido em **Java** para simular a operação de um posto de gasolina, incluindo:
- Vendas na loja de conveniência
- Abastecimento de veículos
- Controle de estoque das bombas de combustíveis

O sistema permite registrar vendas, controlar o estoque de combustíveis (com atualização automática após cada abastecimento) e calcular o lucro das operações.

**Exemplo:** Se a bomba possui 100 litros de gasolina e são vendidos 20 litros, o sistema atualiza automaticamente o estoque para 80 litros.

---

## Funcionalidades
- Interface gráfica (Swing)
- Controle de estoque de combustíveis
- Registro de vendas de combustíveis e serviços adicionais (ducha, troca de óleo, balanceamento, café)
- Relatórios de vendas e lucros
- Simulação de reabastecimento das bombas

---

## Estrutura do Projeto

```
src/
	PostoView.java        # Interface principal do sistema
	PostoVO.java          # Lógica e dados do posto (estoque, vendas, lucros)
	RelatorioView.java    # Tela de relatórios
	SistemaPosto.java     # Classe principal (main)
build.xml               # Script de build (Ant)
manifest.mf             # Manifesto do projeto
nbproject/              # Configurações do NetBeans
```

---

## Requisitos
- Java 8 ou superior
- (Opcional) NetBeans para facilitar o build e execução

---

## Como Executar
1. Compile o projeto:
	 - Usando o NetBeans: basta abrir o projeto e clicar em "Executar".
	 - Usando o terminal (Ant):
		 ```sh
		 ant clean
		 ant jar
		 java -jar dist/SistemaPosto.jar
		 ```
2. Siga as instruções na interface gráfica.

---

## Créditos
- Trabalho acadêmico para a Universidade Guarulhos 📘
- Orientação: Prof. João Ortiz 👨‍🏫
- Autores: *Michael Ferreira* | *Luan Modesto*

