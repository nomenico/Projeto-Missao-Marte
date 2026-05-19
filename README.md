# Projeto-Missao-Marte

Bem-vindo ao Projeto: Rover de Marte - Sobrevivência e Exploração!

## Sobre o projeto:
O projeto foi desenvolvido na Firjan Senai Caxias, com base em um documento de referência criado pelo professor Jonathan Mattos, com o objetivo de aprimorar o conhecimento na linguagem Java. Consiste em um jogo onde um Rover espacial se move em Marte até chegar na Base de Comando, que é o objetivo principal. Entretanto, o caminho até lá é bem perigoso, com eventos aleatórios que podem destruir o Rover ou deixá-lo sem energia.

### O que o projeto contém

Dois arquivos .java, um para executar o jogo "Rover.java" e outro que contém as estatísticas do Rover "RoverStats.java" (atributos privados com métodos públicos) 

Objetivo:
Chegar na Base de Comando, localizada nas coordenadas (10,10). Tenha cuidado, o ambiente e hostil.

Instruções:
Seu Rover tem 100 de integridade e 100 de energia.

Para se movimentar, basta digitar:
W (para cima)
A (para a esquerda)
S (para baixo)
D (para a direita)

O Rover comeca nas coordenadas (0,0).
A cada movimento, voce gasta 3 de energia.
Pense em um plano cartesiano, onde 'W' e 'S' movimentam o eixo Y e 'A' e 'D' movimentam o eixo X.
Existe a possibilidade de se deparar com obstaculos a cada movimento.\nCada um desses obstaculos podem causar algum dano ao Rover, outros podem aumentar o consumo de energia.
Existem dois dados que sao jogados automaticamente: um dado para definir os imprevistos e outro para definir o tipo de solo onde o Rover caminha:
Dado de Eventos (e jogado a cada movimento):
Valores entre 1 e 3 = Buraco (reduz 3 de integridade e consome 6 de energia)\n Valores entre 4 e 6 = Tempestade de Areia (reduz 5 de integridade)\n Valores entre 7 e 8: Colisao contra rocha (reduz 7 de integridade)\n Valores entre 9 e 10: Nada acontece\n");
        System.out.println("Dado de Tipo de Solo (e jogado a cada 3 movimentos):\n Valor 1: Solo Normal (nenhum dano extra)\n Valor 2: Solo Arenoso (consumo de energia dobrado)\n Valor 3: Solo Rochoso (perde 2 de integridade a cada movimento)");
        System.out.println("Voce vence o jogo apos as posicoes X e Y forem iguais a 10.\n");
