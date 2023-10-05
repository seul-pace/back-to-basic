package com.seul.backtobasic.c;

public class Game {
    private GameNumGen gameNumGen;

    public Game(GameNumGen gameNumGen) {
        this.gameNumGen = gameNumGen;
    }

    public void init(GameLevel level) {
        gameNumGen.generate(level);
    }
}
