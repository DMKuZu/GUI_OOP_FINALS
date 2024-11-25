package elements.creature.enemy.enemyClass;

import elements.creature.Creature;
import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Effects;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Random;

public class Elite_Enemy extends Enemy {
    private final int currWorld;

    public Elite_Enemy(Hero hero, int currWorld, int currEncounter){
        super(hero,0.9,2.2,0.5,0.4,0.3);
        this.currWorld = currWorld;

        switch (hero.getNAME()){
            case "Radea":
                switch (currWorld){
                    case 1:
                        switch (currEncounter) {
                            case 3 -> NAME = Azr_Elite_List.get(0);
                            case 6 -> NAME = Azr_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(AzrSkills);
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 3 -> NAME = Qua_Elite_List.get(0);
                            case 6 -> NAME = Qua_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(QuaSkills);
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 3 -> NAME = Sar_Elite_List.get(0);
                            case 6 -> NAME = Sar_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(SarSkills);
                        break;
                }
                break;
            case "Mazupe":
                switch (currWorld){
                    case 1:
                        switch (currEncounter) {
                            case 3 -> NAME = Sar_Elite_List.get(0);
                            case 6 -> NAME = Sar_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(SarSkills);
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 3 -> NAME = Azr_Elite_List.get(0);
                            case 6 -> NAME = Azr_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(AzrSkills);
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 3 -> NAME = Qua_Elite_List.get(0);
                            case 6 -> NAME = Qua_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(QuaSkills);
                        break;
                }
                break;
            case "Zipau":
            default:
                switch (currWorld){
                    case 1:
                        switch (currEncounter) {
                            case 3 -> NAME = Qua_Elite_List.get(0);
                            case 6 -> NAME = Qua_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(QuaSkills);
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 3 -> NAME = Sar_Elite_List.get(0);
                            case 6 -> NAME = Sar_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(SarSkills);
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 3 -> NAME = Azr_Elite_List.get(0);
                            case 6 -> NAME = Azr_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(AzrSkills);
                        break;
                }
        }
    }

    @Override
    public String attack() {
        Random rand = new Random();
        int skillNum = rand.nextInt(4) + 1;

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
                            case 4:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's DEF by 20 for 3 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,3,20);
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
                            case 4:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Regenerate 10 HP for 3 turns!
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
                            case 4:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Inflicts 15 damage to %s for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,2,15);
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
                            case 4:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Inflicts 15 damage to %s for 2 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,2,15);
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
                            case 4:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's DEF by 20 for 3 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,3,20);
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
                            case 4:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Regenerate 10 HP for 3 turns!
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
                            case 4:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        Regenerate 10 HP for 3 turns!
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
                            case 4:
                                msg = String.format(
                                        """
                                        %s used %s!
                                        
                                        %sDealt %d damage!
                                        
                                        Decreased %s's DEF by 20 for 3 turns!
                                        """,
                                        NAME, getSKILL_NAME(skillNum),
                                        crit,damage,
                                        creature.getNAME()
                                );
                                creature.addEffects(effects,3,20);
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
