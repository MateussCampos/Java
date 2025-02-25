package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBattle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end = 0, end2 = 0;
        int op1, op2;
        int closeGame = 1; // Encerra o programa;

        while (closeGame == 1) {

            System.out.println("\n-------------------------------------------");
            System.out.println(
                    "Jogadores! Insiram o número correspondente ao seu personagem!\n caso insiram um NÚMERO INVALIDO o personagem GURREIRO SERÁ ESCOLHIDO POR PADRÃO!!!");
            System.out.println(" ");
            // Escolha do Personagem do Jogador 1
            System.out.println("Jogador 1, escolha seu personagem:");
            System.out.println("[0]. Mago" + " [1]. Berserk" + " [2]. Guerreiro");
            try {
                op1 = sc.nextInt();
            } catch (InputMismatchException e) {// TRATAR QUALQUER INPUT DIFERENTE DE INT

                System.out.println("Entrada inválida! O personagem Guerreiro será escolhido por padrão.");
                op1 = 2; // Define Guerreiro como padrão
                sc.next(); // Limpa o buffer do scanner
            }

            // Escolha do Personagem do Jogador 2
            System.out.println("Jogador 2, escolha seu personagem:");
            System.out.println("[0]. Mago" + " [1]. Berserk" + " [2]. Guerreiro");

            try {
                op2 = sc.nextInt();
            } catch (InputMismatchException e) {// TRATAR QUALQUER INPUT DIFERENTE DE INT

                System.err.println("Entrada inválida! O personagem Guerreiro será escolhido por padrão.");
                op2 = 2; // Define Guerreiro como padrão
                sc.next(); // Limpa o buffer do scanner
            }

            // Criar Personagens com base nas escolhas (VIA METODO PRIVADO)
            Personagem p1 = criarPersonagem(op1);
            Personagem p2 = criarPersonagem(op2);

            System.out.println("A batalha começou! ");

            while (p1.getHp() > 0 && p2.getHp() > 0 && end == 0 && end2 == 0) {
                jogadaPlayer01();
                int danoP1 = escolha(p1); // Captura o dano causado pelo player 1
                p2.hp -= danoP1; // Diminui o HP do player 2

                // Exibir HP e dano infligido
                System.out.println(p1.getNome() + " causou " + danoP1 + " de dano a " + p2.getNome());
                System.out.println(p2.getNome() + " HP atual: " + p2.getHp());

                if (p2.getHp() <= 0) {
                    System.out.println(p2.getNome() + " foi derrotado!");
                    break; // Sai do loop se o player 2 for derrotado
                }

                jogadaPlayer02();
                int danoP2 = escolha(p2); // Captura o dano causado pelo player 2
                p1.hp -= danoP2; // Diminui o HP do player 1

                // Exibir HP e dano infligido
                System.out.println(p2.getNome() + " causou " + danoP2 + " de dano a " + p1.getNome());
                System.out.println(p1.getNome() + " HP atual: " + p1.getHp());
                System.out.println("\n-------------------------------------------------------");

                if (p1.getHp() <= 0) {
                    System.out.println(p1.getNome() + " foi derrotado!");
                    break; // Sai do loop se o player 1 for derrotado
                }
                // Pergunta se deseja jogar novamente
                System.out.println("Deseja jogar novamente? [0].SIM  [1].NÃO");
                try {
                    closeGame = sc.nextInt();
                    if (closeGame != 0 && closeGame != 1) {
                        System.err.println("Você inseriu uma opção inválida, logo o jogo será fechado!");
                        closeGame = 1; // Para fechar o jogo
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Você inseriu uma opção inválida, logo o jogo será fechado!");
                    closeGame = 1; // Para fechar o jogo
                    sc.next(); // Limpa o buffer do scanner
                }
            }
        }
        sc.close();
    }

    private static Personagem criarPersonagem(int op1) {
        Personagem personagem;
        switch (op1) {
            case 0:
                personagem = new Mago("Mago", op1, "Isqueiro e gasolina", op1, "Acabou o frio!", op1);

                personagem.setStatus("Mago", 5000);
                personagem.SetMainAttackName("Utilizou o golpe:  Isqueiro e gasolina");
                personagem.setMainAttackDamage(1200);
                personagem.setEspecialAttackName("Utilizou o golpe:  Acabou o frio!");
                personagem.setEspecialAttackDamage(1300);
                break;
            case 1:
                personagem = new Berserk("Berserk", op1, "Colher de pau", op1, "Espada com Tetano", op1);
                personagem.setStatus("Berserk", 6500);
                personagem.SetMainAttackName("Utilizou o golpe:  Colher de pau");
                personagem.setEspecialAttackName("Utilizou o golpe:  Espada com Tetano");
                personagem.setMainAttackDamage(600);
                personagem.setEspecialAttackDamage(1950);
                break;
            case 2:
                personagem = new Guerreiro("Guerreiro", op1, "Utilizou o golpe: Espada", op1, "Protagonismo", op1);
                personagem.setStatus("Guerreiro", 8900); // HP padrão para Guerreiro
                personagem.SetMainAttackName("Utilizou o golpe: Espada");
                personagem.setEspecialAttackName("Utilizou o golpe: Protagonismo");
                personagem.setMainAttackDamage(1000);
                personagem.setEspecialAttackDamage(1500);
                break;
            default:
                personagem = new Guerreiro("Guerreiro", op1, "Utilizou o golpe: Espada", op1, "Protagonismo", op1); // Personagem                                                                                                       // padrão
                personagem.setStatus("Guerreiro", 8900); // HP padrão para Guerreiro
                personagem.setEspecialAttackName("Utilizou o golpe:  Protagonismo"); // SET nome do ataque especial
                personagem.SetMainAttackName("Utilizou o golpe:  Espada");
                personagem.setMainAttackDamage(1000);
                personagem.setEspecialAttackDamage(1500);
                break;
        }
        return personagem; // Retorna o personagem criado
    }

    private static void jogadaPlayer01() {
        System.out.println("Player 01 faça a sua jogada!");
    }

    private static void jogadaPlayer02() {
        System.out.println("Player 2 faça a sua jogada! ");
    }

    private static int escolha(Personagem personagem) {
        Scanner sc = new Scanner(System.in);
        int mov;
        System.out.println("Insira o número do seu próximo movimento! ");
        System.out.println(" [0].Ataque principal. [1].Ataque especial [2].Fugir");
        try {
            mov = sc.nextInt();
        } catch (InputMismatchException e) {// TRATA QUALQUER ENTRADA DIFERENTE DE INT
            System.err.println("\nEntrada inválida! Você perdeu sua vez.");
            mov = 3; // Define excessão de opções (Perde a vez)
            sc.next(); // Limpa o buffer do scanner

        }

        int dano = 0; // Variável para armazenar o dano causado

        switch (mov) {
            case 0:
                System.out.println(personagem.getEspecialAttackName() + "\n");
                dano = personagem.getEspecialAttackDamage(); // Captura o dano do ataque especial
                break;
            case 1:
                System.out.println(personagem.GetMainAttackName() + "\n");
                dano = personagem.getMainAttackDamage(); // Captura o dano do ataque normal
                break;
            case 2:
                System.out.println(personagem.getNome() + " decidiu fugir!\n Recuperando 500 de hp");
                dano = 0; // Não causa dano ao fugir
                personagem.hp+=500;
                break;
            default:
                System.out.println("Você digitou uma OPÇÃO INVÁLIDA. Perdeu sua vez!");
                break;
        }
        return dano; // Retorna o dano causado
    }
}