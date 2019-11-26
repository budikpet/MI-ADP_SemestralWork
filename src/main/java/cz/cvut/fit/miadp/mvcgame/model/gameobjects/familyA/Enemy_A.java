package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.strategy.enemy.IEnemyMovingStrategy;

public class Enemy_A extends AbsEnemy {
    private IEnemyMovingStrategy strategy;

    public Enemy_A(IEnemyMovingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void move() {
        this.strategy.updatePosition(this);
    }
}