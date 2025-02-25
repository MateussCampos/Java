package Game;
public class Berserk extends Personagem{
    public Berserk(String nome, int hp, String mainAttackName, int mainAttackDamage, String especialAttackName,
                int especialAttackDamage) {
            super(nome, hp, mainAttackName, mainAttackDamage, especialAttackName, especialAttackDamage);
           
        }//HERDA CLASSE ABSTRATA PERSONAGEM
    
        @Override
    public int getEspecialAttackDamage(){
        return this.especialAttackDamage*3;
    }// GET DANO ATAQUE ESPECIAL
    
}