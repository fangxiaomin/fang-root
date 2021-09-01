package com.fang.user.design.template;

/**
 * @description:
 * @version:1.0
 */
public class TemplateCricket extends TemplateGame{
    @Override
    public void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");

    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");

    }
}
