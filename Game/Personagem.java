package Game;

import java.util.Scanner;

public abstract class Personagem implements Ipersonagem {
    protected String nome;
    protected int hp;
    protected String mainAttackName;
    protected int mainAttackDamage;
    protected int dodge;
    protected String especialAttackName;
    protected int especialAttackDamage;

    public Personagem(String nome, int hp, String mainAttackName, int mainAttackDamage, String especialAttackName,
            int especialAttackDamage) {
        this.nome = nome;
        this.hp = hp;
        this.mainAttackName = mainAttackName;
        this.mainAttackDamage = mainAttackDamage;
        this.especialAttackName = especialAttackName;
        this.especialAttackDamage = especialAttackDamage;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome = nome;
    }

    public void setStatus(String nome, int hp) {
        this.nome = nome;
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    } // VERIFICAR SE O PERSONAGEM ESTA VIVO

    public void SetMainAttackName(String mainAttackName) {
        this.mainAttackName = mainAttackName;
    }// SET ATAQUE PRINCIPAL

    public String GetMainAttackName() {
        return this.mainAttackName;
    } // GET NOME DO ATAQUE PRINCIPAL

    public void setMainAttackDamage(int mainAttackDamage) {
        this.mainAttackDamage = mainAttackDamage;
    } // SET DANO DO ATAQUE PRINCIPAL


    public void setEspecialAttackDamage(int especialAttackDamage) {
        this.especialAttackDamage = especialAttackDamage;
    }

    public int getMainAttackDamage() {
        return this.mainAttackDamage;
    } // GET DANO ATAQUE PRINCIPAL

    public  abstract int getEspecialAttackDamage();// GET DANO ATAQUE ESPECIAL

    public int especialAttack() {
        return 0;
    } // SET ATACK ESPECIAL

    public void setEspecialAttackName(String especialAttackName) {
        this.especialAttackName = especialAttackName;
    }

    public String getEspecialAttackName() {
        return this.especialAttackName;
    }// GET NO NOME DO ATAQUE ESPECIAL

    public void attack(int option) {
        System.out.println("Escolha seu próximo movimento!");
        System.out.println("0. Ataque Normal");
        System.out.println("1. Ataque Especial");

        // Lê a opção do jogador
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();

        switch (option) {
            case 0:
                // Realiza o ataque normal
                System.out.println(this.nome + " realiza " + this.mainAttackName + " causando " + this.mainAttackDamage
                        + " de dano!");
                break;
            case 1:
                // Verifica se o ataque especial pode ser realizado
                if (this.hp > 1000) { // Critério: HP deve ser maior que 1000
                    int danoEspecial = especialAttack();
                    System.out.println(this.nome + " realiza " + this.getEspecialAttackName() + " causando "
                            + danoEspecial + " de dano!");
                } else {
                    System.out.println("Ataque especial não pode ser realizado. HP insuficiente!");
                }
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }

}