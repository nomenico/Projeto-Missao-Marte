import java.util.Scanner;
import java.util.Random;

public class Rover {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in); // Objeto scanner nomeado ler
        Random gerador = new Random(); // Objeto random nomeado "gerador"
        String tipoSolo = "Normal"; // Define o tipo de solo. É "Normal" por padrão.
        int x2 = 10, y2 = 10; // Posições finais para o cálculo da Distância Euclidiana
        double distancia = 0; // O cálculo da distancia é realizado dentro do loop while
        char movimento; // Caractere para a movimentação (WASD)
        int contadorTurnos = 0; // Define quando o tipo de solo muda

        // Introdução do jogo
        System.out.println("Bem-vindo ao Projeto: Rover de Marte - Sobrevivencia e Exploracao!\n");
        System.out.println("Objetivo:\n");
        System.out.println("Chegar na Base de Comando, localizada nas coordenadas (10,10). Tenha cuidado, o ambiente e hostil.\n");
        System.out.println("Instrucoes:\n");
        System.out.println("Seu Rover tem 100 de integridade e 100 de energia.\n");
        System.out.println("Para se movimentar, basta digitar:\n W (para cima)\n A (para a esquerda)\n S (para baixo)\n D (para a direita)\n");
        System.out.println("O Rover comeca nas coordenadas (0,0).");
        System.out.println("A cada movimento, voce gasta 3 de energia.");
        System.out.println("Pense em um plano cartesiano, onde 'W' e 'S' movimentam o eixo Y e 'A' e 'D' movimentam o eixo X.\n");
        System.out.println("Existe a possibilidade de se deparar com obstaculos a cada movimento.\nCada um desses obstaculos podem causar algum dano ao Rover, outros podem aumentar o consumo de energia.\n");
        System.out.println("Existem dois dados que sao jogados automaticamente: um dado para definir os imprevistos e outro para definir o tipo de solo onde o Rover caminha:");
        System.out.println("Dado de Eventos (e jogado a cada movimento):\n Valores entre 1 e 3 = Buraco (reduz 3 de integridade e consome 6 de energia)\n Valores entre 4 e 6 = Tempestade de Areia (reduz 5 de integridade)\n Valores entre 7 e 8: Colisao contra rocha (reduz 7 de integridade)\n Valores entre 9 e 10: Nada acontece\n");
        System.out.println("Dado de Tipo de Solo (e jogado a cada 3 movimentos):\n Valor 1: Solo Normal (nenhum dano extra)\n Valor 2: Solo Arenoso (consumo de energia dobrado)\n Valor 3: Solo Rochoso (perde 2 de integridade a cada movimento)");
        System.out.println("Voce vence o jogo apos as posicoes X e Y forem iguais a 10.\n");
        System.out.println("Iniciando o jogo...\n");

        // Inicio do Jogo
        while ((RoverStats.getEnergia() > 0 && RoverStats.getIntegridade() > 0)) {
            distancia = Math.sqrt(Math.pow(RoverStats.getPosX() - x2, 2) + Math.pow(RoverStats.getPosY() - y2, 2));
            System.out.println("-----Status do Rover-----");
            System.out.println("Integridade: " + RoverStats.getIntegridade());
            System.out.println("Energia: " + RoverStats.getEnergia());
            System.out.println("Posicao X e Y: (" + RoverStats.getPosX() + "," + RoverStats.getPosY() + ")");
            //System.out.println("Posicao Y: " + RoverStats.getPosY());
            System.out.printf("Distancia ate a base: %.2f", distancia);
            System.out.print(" metros\n");
            System.out.print("Digite alguma tecla para se movimentar: ");
            movimento = ler.next().toUpperCase().charAt(0);
            System.out.println("-------------------------");
            do {
                // Verifica se a tecla digitada é diferente de WASD.
                if ((movimento != 'W') && (movimento != 'A') && (movimento != 'S') && (movimento != 'D')) {
                    System.out.print("Tecla invalida. Digite novamente: ");
                    movimento = ler.next().toUpperCase().charAt(0);

                }
            } while ((movimento != 'W') && (movimento != 'A') && (movimento != 'S') && (movimento != 'D'));
            contadorTurnos++; // Incrementa a cada movimento

            System.out.println();
            System.out.println("Valor do contador de movimentos ate mudar o terreno: " + contadorTurnos);
            // Lógica do contador de movimentos para alterar o tipo de solo
            if (contadorTurnos == 3) {
                int dadoSolo = gerador.nextInt(1, 4); //gera um número inteiro aleatório de 1 a 3
                if (!"Normal".equals(tipoSolo)) {
                    System.out.println("O Rover esta passando por um terreno diferente...");
                }
                System.out.println("Valor do dado de tipo do solo aleatorio: " + dadoSolo);
                if (dadoSolo == 1) {
                    tipoSolo = "Normal";
                    System.out.println("O tipo do solo e Normal. Nao ha danos extras nos proximos 3 movimentos.\n");
                } else if (dadoSolo == 2) {
                    tipoSolo = "Arenoso";
                    System.out.println("O tipo do solo e Arenoso. O consumo de energia foi dobrado nos proximos 3 movimentos.\n");
                } else {
                    tipoSolo = "Rochoso";
                    System.out.println("O tipo do solo e Rochoso. O Rover perdera 2 de integridade por movimento nos proximos 3 movimentos.\n");
                }
                contadorTurnos = 0; // Reseta a variável, fazendo com que o tipo de solo permaneça por 3 movimentos.
            }

            // Lógica da movimentação, onde 'W' e 'S' alteram a posição Y e 'A' e 'D' alteram a posição X.
            // Cada movimento gasta 3 de energia. Dependendo do tipo de solo, pode dobrar o consumo de energia ou perder integridade além da energia.
            switch (movimento) {
                case 'W':
                    if ("Arenoso".equals(tipoSolo)) {
                        RoverStats.setEnergia(RoverStats.getEnergia() - 6);
                    } else if ("Rochoso".equals(tipoSolo)) {
                        RoverStats.setIntegridade(RoverStats.getIntegridade() - 2);
                        RoverStats.setEnergia(RoverStats.getEnergia() - 3);
                    } else {
                        RoverStats.setEnergia(RoverStats.getEnergia() - 3);
                    }
                    RoverStats.setPosY(RoverStats.getPosY() + 1);
                    break;
                case 'A':
                    if ("Arenoso".equals(tipoSolo)) {
                        RoverStats.setEnergia(RoverStats.getEnergia() - 6);
                    } else if ("Rochoso".equals(tipoSolo)) {
                        RoverStats.setIntegridade(RoverStats.getIntegridade() - 2);
                        RoverStats.setEnergia(RoverStats.getEnergia() - 3);
                    } else {
                        RoverStats.setEnergia(RoverStats.getEnergia() - 3);
                    }
                    RoverStats.setPosX(RoverStats.getPosX() - 1);
                    break;
                case 'S':
                    if ("Arenoso".equals(tipoSolo)) {
                        RoverStats.setEnergia(RoverStats.getEnergia() - 6);
                    } else if ("Rochoso".equals(tipoSolo)) {
                        RoverStats.setIntegridade(RoverStats.getIntegridade() - 2);
                        RoverStats.setEnergia(RoverStats.getEnergia() - 3);
                    } else {
                        RoverStats.setEnergia(RoverStats.getEnergia() - 3);
                    }
                    RoverStats.setPosY(RoverStats.getPosY() - 1);
                    break;
                case 'D':
                    if ("Arenoso".equals(tipoSolo)) {
                        RoverStats.setEnergia(RoverStats.getEnergia() - 6);
                    } else if ("Rochoso".equals(tipoSolo)) {
                        RoverStats.setIntegridade(RoverStats.getIntegridade() - 2);
                        RoverStats.setEnergia(RoverStats.getEnergia() - 3);
                    } else {
                        RoverStats.setEnergia(RoverStats.getEnergia() - 3);
                    }
                    RoverStats.setPosX(RoverStats.getPosX() + 1);
                    break;
            }

            // Lógica para os eventos aleatórios
            int dadoEvento = gerador.nextInt(1, 11); //gera um número inteiro aleatório de 1 a 10
            System.out.println("Valor do dado de evento aleatorio: " + dadoEvento);
            if (dadoEvento >= 1 && dadoEvento <= 3) {
                System.out.println("ALERTA: Voce passou por cima de um buraco!");
                RoverStats.setEnergia(RoverStats.getEnergia() - 4);
                RoverStats.setIntegridade(RoverStats.getIntegridade() - 3);
                System.out.println("O Rover perdeu 3 de integridade e foi obrigado a gastar 4 de energia para sair do buraco!\n");
            } else if (dadoEvento >= 4 && dadoEvento <= 6) {
                System.out.println("ALERTA: Uma tempestade de areia te atingiu!!");
                RoverStats.setIntegridade(RoverStats.getIntegridade() - 5);
                System.out.println("O Rover perdeu 5 de integridade!\n");
            } else if (dadoEvento >= 7 && dadoEvento <= 8) {
                System.out.println("ALERTA: Voce colidiu com uma rocha!!");
                RoverStats.setIntegridade(RoverStats.getIntegridade() - 7);
                System.out.println("O Rover perdeu 7 de integridade!\n");
            } else {
                System.out.println("SORTE: Voce seguiu viagem sem levar danos!!\n");
            }

            // Atualiza Energia para evitar exibir valores negativos no relatório final
            RoverStats.setEnergia(Math.max(0, RoverStats.getEnergia()));

            // Atualiza Integridade para evitar exibir valores negativos no relatório final
            RoverStats.setIntegridade(Math.max(0, RoverStats.getIntegridade()));

            // Finaliza o loop após X e Y = 10
            if (RoverStats.getPosX() == 10 && RoverStats.getPosY() == 10) {
                break;
            }
        }

        // Relatório final
        System.out.println("-----Status final do Rover-----");
        System.out.println("Integridade: " + RoverStats.getIntegridade());
        System.out.println("Energia: " + RoverStats.getEnergia());
        System.out.println("Posicao X e Y: (" + RoverStats.getPosX() + "," + RoverStats.getPosY() + ")");
        if (RoverStats.getPosX() == 10 && RoverStats.getPosY() == 10) {
            System.out.println("Missao cumprida! O Rover chegou na Base de Comando!");
        } else if (RoverStats.getEnergia() <= 0 || RoverStats.getIntegridade() <= 0) {
            System.out.printf("Distancia ate a base: %.2f", distancia);
            System.out.print(" metros\n");
            System.out.println("A missao falhou...");
        }
    }
}