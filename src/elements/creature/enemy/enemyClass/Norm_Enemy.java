package elements.creature.enemy.enemyClass;

import elements.creature.Creature;
import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Effects;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Random;

public class Norm_Enemy extends Enemy {
    private final int currWorld;

    public Norm_Enemy(Hero hero, int currWorld, int currEncounter){
        super(hero,0.7,2.0,0.4,0.3,0.2);
        this.currWorld = currWorld;

        SKILLS = new ArrayList<>(3);

        switch (hero.getNAME()) {
            case "Radea":
                switch (currWorld) {
                    case 1:
                        switch (currEncounter) {
                            case 1 -> NAME = Azr_Norm_List.get(0);
                            case 2 -> NAME = Azr_Norm_List.get(1);
                            case 4 -> NAME = Azr_Norm_List.get(2);
                            case 5 -> NAME = Azr_Norm_List.get(3);
                            case 6 -> NAME = Azr_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(AzrSkills.get(i));
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1 -> NAME = Qua_Norm_List.get(0);
                            case 2 -> NAME = Qua_Norm_List.get(1);
                            case 4 -> NAME = Qua_Norm_List.get(2);
                            case 5 -> NAME = Qua_Norm_List.get(3);
                            case 6 -> NAME = Qua_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(QuaSkills.get(i));
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1 -> NAME = Sar_Norm_List.get(0);
                            case 2 -> NAME = Sar_Norm_List.get(1);
                            case 4 -> NAME = Sar_Norm_List.get(2);
                            case 5 -> NAME = Sar_Norm_List.get(3);
                            case 6 -> NAME = Sar_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(SarSkills.get(i));
                        }
                        break;
                }
                break;
            case "Mazupe":
                switch (currWorld) {
                    case 1:
                        switch (currEncounter) {
                            case 1 -> NAME = Sar_Norm_List.get(0);
                            case 2 -> NAME = Sar_Norm_List.get(1);
                            case 4 -> NAME = Sar_Norm_List.get(2);
                            case 5 -> NAME = Sar_Norm_List.get(3);
                            case 6 -> NAME = Sar_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(SarSkills.get(i));
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1 -> NAME = Azr_Norm_List.get(0);
                            case 2 -> NAME = Azr_Norm_List.get(1);
                            case 4 -> NAME = Azr_Norm_List.get(2);
                            case 5 -> NAME = Azr_Norm_List.get(3);
                            case 6 -> NAME = Azr_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(AzrSkills.get(i));
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1 -> NAME = Qua_Norm_List.get(0);
                            case 2 -> NAME = Qua_Norm_List.get(1);
                            case 4 -> NAME = Qua_Norm_List.get(2);
                            case 5 -> NAME = Qua_Norm_List.get(3);
                            case 6 -> NAME = Qua_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(QuaSkills.get(i));
                        }
                        break;
                }
                break;
            case "Zipau":
            default:
                switch (currWorld) {
                    case 1:
                        switch (currEncounter) {
                            case 1 -> NAME = Qua_Norm_List.get(0);
                            case 2 -> NAME = Qua_Norm_List.get(1);
                            case 4 -> NAME = Qua_Norm_List.get(2);
                            case 5 -> NAME = Qua_Norm_List.get(3);
                            case 6 -> NAME = Qua_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(QuaSkills.get(i));
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1 -> NAME = Sar_Norm_List.get(0);
                            case 2 -> NAME = Sar_Norm_List.get(1);
                            case 4 -> NAME = Sar_Norm_List.get(2);
                            case 5 -> NAME = Sar_Norm_List.get(3);
                            case 6 -> NAME = Sar_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(SarSkills.get(i));
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1 -> NAME = Azr_Norm_List.get(0);
                            case 2 -> NAME = Azr_Norm_List.get(1);
                            case 4 -> NAME = Azr_Norm_List.get(2);
                            case 5 -> NAME = Azr_Norm_List.get(3);
                            case 6 -> NAME = Azr_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(AzrSkills.get(i));
                        }
                        break;
                }
        }

    }

    @Override
    public String attack() {
        Random rand = new Random();
        int skillNum = rand.nextInt(3) + 1;

        return useSkill(skillNum);
    }


    @Override
    protected String skill(int skillNum, boolean isCrit, int damage, Creature creature) {
        String msg;
        String crit = isCrit ? "CRIT! " : "";
        Effects effects = getSKILL_EFFECTS(skillNum);

        switch (HERO.getNAME()){
            case "Radea":
                switch (currWorld) {
                    case 1:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's ATK by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased CRIT by 20 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,2,20);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }
                        break;
                    case 2:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Increased ATK by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                                addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased DEF by 20 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,3,20);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }
                        break;
                    case 3:
                    default:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's DEF by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased DODGE by 10 for 3 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,3,10);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }

                }
                break;
            case "Mazupe":
                switch (currWorld) {
                    case 1:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's DEF by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased DODGE by 10 for 3 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,3,10);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }
                        break;
                    case 2:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's ATK by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased CRIT by 20 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,2,20);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }
                        break;
                    case 3:
                    default:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Increased ATK by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                                addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased DEF by 20 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,3,20);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }
                }
                break;
            case "Zipau":
            default:
                switch (currWorld) {
                    case 1:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Increased ATK by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                                addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased DEF by 20 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,3,20);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }
                        break;
                    case 2:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's DEF by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased DODGE by 10 for 3 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,3,10);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }
                        break;
                    case 3:
                    default:
                        switch (skillNum){
                            case 2:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's ATK by 10 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,2,10);
                                break;
                            case 3:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Increased CRIT by 20 for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum)
                                );
                                addEffects(effects,2,20);
                                break;
                            default:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage
                                );
                        }
                }
        }

        return msg;
    }
}
