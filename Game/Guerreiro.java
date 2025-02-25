package Game;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome, int hp, String mainAttackName, int mainAttackDamage, String especialAttackName,
            int especialAttackDamage) {
        super(nome, hp, mainAttackName, mainAttackDamage, especialAttackName, especialAttackDamage);

    }

    @Override
    public int getEspecialAttackDamage() {
        return this.especialAttackDamage*2;
    }// GET DANO ATAQUE ESPECIAL

}
