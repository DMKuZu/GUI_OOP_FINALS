package elements.creature;

import elements.creature.value.Skills;

import java.util.Arrays;
import java.util.List;

import static elements.creature.value.Effects.*;

public interface Hero_Skills {
    List<Skills> Mazupe_Skills = Arrays.asList(
            new Skills("Basic Strike",20,1,NONE),
            new Skills("Mountain Breaker",30,12,FRAIL),
            new Skills("War Cry",0,15,EMPOWER),
            new Skills("Stone SKin",2,15,REGEN),
            new Skills("Titan's Grip",50,5,STUN)
    );

    List<Skills> Radea_Skills = Arrays.asList(
            new Skills("Shadow Strike",15,1,NONE),
            new Skills("Psychic Drain",20,12,WEAKEN),
            new Skills("Mental Fortress",0,8,FORTIFY),
            new Skills("Thought Pierce",20,12,FRAIL),
            new Skills("Mass Hysteria",35,6,INFLICTION)
    );

    List<Skills> Zipau_Skills = Arrays.asList(
            new Skills("Quick Slash",10,1,NONE),
            new Skills("Flash Strike",15,15,EMPOWER),
            new Skills("Wind Walker",0,8,ENSHROUD),
            new Skills("Bright Blade",30,6,SHARPEN),
            new Skills("Blade Dance",40,3,FRAIL)
    );

    List<Skills> Supa_Skills = Arrays.asList(
            new Skills("Reality Warp",10,1,NONE),
            new Skills("Dimensional Shift",15,9,NONE),
            new Skills("Entropy Wave",20,7,NONE),
            new Skills("Void Embrace",0,5,NONE),
            new Skills("Ultimate Erasure",30,3,NONE)
    );
}
