package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView implements IObserver {

	private GameModel model;	
	private GraphicsContext gr;
	private int updateCnt;

	public GameView(GameModel model) {
		this.model = model;
		
		// this.model.setView(this);
		this.model.registerObserver(this);

		this.updateCnt = 1;
	}

	public void setGraphics(GraphicsContext gr)
	{
		this.gr = gr;
	}

	public GameController makeController() {
		return new GameController(this.model);
	}

	@Override
	public void update() {
		this.updateCnt++;
	}

	private void drawLogo(Position logoPos)
	{
		this.gr.drawImage(new Image("icons/fit-icon-256x256.png"), logoPos.getX(), logoPos.getY());
	}

	public void render() {
		if(this.updateCnt > 0)
		{
			Position logoPos = this.model.getLogoPos();
			this.drawLogo(logoPos);

			//
			this.updateCnt = 0;
		}
	}

}
