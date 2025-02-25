package Game;

public class Mago extends Personagem {

    public Mago(String nome, int hp, String mainAttackName, int mainAttackDamage, String especialAttackName,
            int especialAttackDamage) {
        super(nome, hp, mainAttackName, mainAttackDamage, especialAttackName, especialAttackDamage);
    } // HERDA CLASSE ABSTRATA PERSONAGEM

    @Override
    public int getEspecialAttackDamage() {
        return this.especialAttackDamage * 2;
    }// GET DANO ATAQUE ESPECIAL

}