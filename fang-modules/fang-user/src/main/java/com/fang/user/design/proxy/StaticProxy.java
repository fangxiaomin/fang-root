package com.fang.user.design.proxy;

/**
 * @description:  静态代理
 * @version:1.0
 */
public class StaticProxy {
    /**
     * 最顶层接口 歌手
     */
    interface Singer {
        void sing();
    }
    /**
     * 真实实现，一个歌星
     */
    static class Star implements Singer {
        @Override
        public void sing() {
            System.out.println("Star Singing~~~");
        }
    }
    /**
     * 代理实现，代理了歌星，唱歌的时候 会先在歌手唱歌之前收钱，然后再唱歌
     */
    static class Agent implements Singer {
        Star s;
        public Agent(Star s) {
            super();
            this.s = s;
        }
        @Override
        public void sing() {
            System.out.println("在歌手唱歌之前收钱....");
            s.sing();
        }
    }
    public static void main(String[] args) {
        Singer singer = new Agent(new Star());
        singer.sing();
    }

}
