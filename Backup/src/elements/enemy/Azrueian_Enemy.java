package elements.enemy;

import elements.hero.List_of_Characters;

import java.util.ArrayList;
import java.util.List;

public class Azrueian_Enemy implements List_of_Azrueian_Enemies, List_of_Characters {
    private final String name;
    private final List<String> SKILL_NAME;
    private final List<Integer> BASE_DMG;

    private final String enemyType;


    protected void init(Current_Enemy enemy){
        enemy.setNAME(name);
        enemy.setSKILL_NAME(SKILL_NAME);
        enemy.setBASE_DMG(BASE_DMG);
        enemy.setEnemyType(enemyType);
    }

    protected Azrueian_Enemy(int encounterCtr, boolean isNorm){
        switch (encounterCtr){
            case 1:
                name = Norm_List.get(0);
                SKILL_NAME = AzrNormV1_SKILL_NAME;
                BASE_DMG = Azr_BASE_DMG;
                enemyType = "norm";
                break;
            case 2:
                name = Norm_List.get(1);
                SKILL_NAME = AzrNormV2_SKILL_NAME;
                BASE_DMG = Azr_BASE_DMG;
                enemyType = "norm";
                break;
            case 3:
                name = Elite_List.get(0);
                SKILL_NAME = AzrEliteV1_SKILL_NAME;
                BASE_DMG = Azr_BASE_DMG;
                enemyType = "elite";
                break;
            case 4:
                name = Norm_List.get(2);
                SKILL_NAME = AzrNormV3_SKILL_NAME;
                BASE_DMG = Azr_BASE_DMG;
                enemyType = "norm";
                break;
            case 5:
                name = Norm_List.get(3);
                SKILL_NAME = AzrNormV4_SKILL_NAME;
                BASE_DMG = Azr_BASE_DMG;
                enemyType = "norm";
                break;
            case 6:
            default:
                if(isNorm){
                    name = Norm_List.get(4);
                    SKILL_NAME = AzrNormV5_SKILL_NAME;
                    BASE_DMG = Azr_BASE_DMG;
                    enemyType = "norm";
                }
                else {
                    name = Elite_List.get(1);
                    SKILL_NAME = AzrEliteV2_SKILL_NAME;
                    BASE_DMG = Azr_BASE_DMG;
                    enemyType = "elite";
                }
                break;
        }
        
    }

}
