package elements.creature.value;


import elements.creature.Creature;

public class Status {
    private final Effects effect;
    private int turns;
    private final int value;

    private boolean isUsed;
    private Creature creature;

    public Status(Effects effect, int turns,int value){
        this.effect = effect;
        this.turns = turns;
        this.value = value;

        this.isUsed = false;
    }

    public Effects getEffect() {
        return effect;
    }
    public boolean isExpired() {
        return turns <= 0;
    }

    @Override
    public String toString(){
        return String.format(
                """
                %s  ->  %d turn/s left
                """,
                effect,turns
        );
    }
    public void nextTurn(){
        this.turns--;
    }


    public void applyEffect(Creature creature) {
        this.creature = creature;

        switch (this.effect) {
            case INFLICTION -> infliction();
            case REGEN -> regen();
            case WEAKEN -> weaken();
            case EMPOWER -> empower();
            case FRAIL -> frail();
            case FORTIFY -> fortify();
            case SHARPEN -> sharpen();
            case ENSHROUD -> enshroud();
            case STUN -> stun();
            default -> {
                // Do nothing for NONE
            }
        }
    }

    private void infliction() {
        int currHP = creature.getCURRSTATS().getHP();
        creature.getCURRSTATS().setHP(Math.max(currHP - value, 0));
    }
    private void regen() {
        int currHP = creature.getCURRSTATS().getHP();
        int HP = creature.getSTATS().getHP();
        creature.getCURRSTATS().setHP(Math.min(currHP + value, HP));
    }
    private void weaken() {
        if (!isUsed) {
            int currATK = creature.getCURRSTATS().getATK();
            creature.getCURRSTATS().setATK(Math.max(currATK - value, 0));
            this.isUsed = true;
        }
    }
    private void empower() {
        if (!isUsed) {
            int currATK = creature.getCURRSTATS().getATK();
            creature.getCURRSTATS().setATK(currATK + value);
            this.isUsed = true;
        }
    }
    private void frail() {
        if (!isUsed) {
            int currDEF = creature.getCURRSTATS().getDEF();
            creature.getCURRSTATS().setDEF(Math.max(currDEF - value, 0));
            this.isUsed = true;
        }
    }
    private void fortify() {
        if (!isUsed) {
            int currDEF = creature.getCURRSTATS().getDEF();
            creature.getCURRSTATS().setDEF(currDEF + value);
            this.isUsed = true;
        }
    }
    private void sharpen() {
        if (!isUsed) {
            double currCRIT = creature.getCURRSTATS().getCRIT();
            creature.getCURRSTATS().setCRIT(currCRIT + (value / 100.0));
            this.isUsed = true;
        }
    }
    private void enshroud() {
        if (!isUsed) {
            double currDODGE = creature.getCURRSTATS().getDODGE();
            creature.getCURRSTATS().setDODGE(Math.min(currDODGE + (value / 100.0), 0.8));
            this.isUsed = true;
        }
    }
    private void stun() {
        if (!isUsed) {
            creature.stunned();
            this.isUsed = true;
        }
    }



    public void revertEffect() {
        switch (this.effect) {
            case WEAKEN -> revert_weaken();
            case EMPOWER -> revert_empower();
            case FRAIL -> revert_frail();
            case FORTIFY -> revert_fortify();
            case SHARPEN -> revert_sharpen();
            case ENSHROUD -> revert_enshroud();
            case STUN -> revert_stun();
            default -> {
                // Do nothing for effects that don't need reversion
            }
        }
    }

    private void revert_weaken() {
        int currATK = creature.getCURRSTATS().getATK();
        creature.getCURRSTATS().setATK(currATK + value);
    }
    private void revert_empower() {
        int currATK = creature.getCURRSTATS().getATK();
        creature.getCURRSTATS().setATK(Math.max(currATK - value, 0));
    }
    private void revert_frail() {
        int currDEF = creature.getCURRSTATS().getDEF();
        creature.getCURRSTATS().setDEF(currDEF + value);
    }
    private void revert_fortify() {
        int currDEF = creature.getCURRSTATS().getDEF();
        creature.getCURRSTATS().setDEF(Math.max(currDEF - value, 0));
    }
    private void revert_sharpen() {
        double currCRIT = creature.getCURRSTATS().getCRIT();
        creature.getCURRSTATS().setCRIT(Math.max(currCRIT - (value / 100.0), 0));
    }
    private void revert_enshroud() {
        double currDODGE = creature.getCURRSTATS().getDODGE();
        creature.getCURRSTATS().setDODGE(Math.max(currDODGE - (value / 100.0), 0));
    }
    private void revert_stun() {
        creature.notStunned();
    }
}
