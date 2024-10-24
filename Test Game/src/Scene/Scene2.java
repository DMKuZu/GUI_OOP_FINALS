package Scene;

import Game.Game;

public class Scene2 extends Scene{
    public Scene2(Game game) {
        super(game);
    }

    @Override
    public void getAction() {
        System.out.println("Enter input");
        switch (sc.nextInt()){
            case 1 -> game.nextScene();
            case 2 -> game.prevScene();
        }
    }

    @Override
    public void print() {
        System.out.println("Scene 2");
    }
}