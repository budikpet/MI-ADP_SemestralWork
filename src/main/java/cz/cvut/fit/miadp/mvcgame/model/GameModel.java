package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

public class GameModel implements IObservable {

    private Cannon cannon;
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private List<Collision> collisions;
    private GameInfo gameInfo;

    private Position logoPos;
    private List<IObserver> myObservers;

    public GameModel() {
        this.logoPos = new Position((int) ((MvcGameConfig.MAX_X / 2) - 128), (int) ((MvcGameConfig.MAX_Y / 2) - 128));
        this.myObservers = new ArrayList<IObserver>();

        this.cannon = new Cannon();
        this.enemies = new ArrayList<Enemy>();
        this.missiles = new ArrayList<Missile>();
        this.collisions = new ArrayList<Collision>();
        this.gameInfo = new GameInfo();
    }

    public void moveLogoUp() {
        logoPos.setY(logoPos.getY() - 10);

        this.notifyObservers();
    }

    public void moveLogoRight() {
        logoPos.setX(logoPos.getX() + 10);

        this.notifyObservers();
    }

    public void moveLogoLeft() {
        logoPos.setX(logoPos.getX() - 10);

        this.notifyObservers();
    }

    public void moveLogoDown() {
        logoPos.setY(logoPos.getY() + 10);

        this.notifyObservers();
    }

    public Position getLogoPos() {
        return new Position(this.logoPos);
    }

    @Override
    public void registerObserver(IObserver obs) {
        this.myObservers.add(obs);

    }

    @Override
    public void unregisterObserver(IObserver obs) {
        this.myObservers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(IObserver obs : this.myObservers)
        {
            obs.update();
        }
    }

}
