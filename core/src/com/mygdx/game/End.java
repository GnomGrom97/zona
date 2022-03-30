package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class End implements Screen{
    final Drop game;
    OrthographicCamera camera;
    TextureRegion backgroundTexture;

    public End(final Drop gam) {
        game = gam;
        backgroundTexture =new TextureRegion(new Texture("fon.jpg.jpg"),0,0,800,480);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0);
        game.batch.draw(backgroundTexture, 0, Gdx.graphics.getHeight());
        game.font.draw(game.batch, "Amazing! You win! END ", 100, 150);
        game.font.draw(game.batch, "The end,please touch DoWN", 100, 100);
        game.batch.end();

       if (Gdx.input.isKeyPressed(Input.Keys.NUM_4)) {//при нажатии кнопки вниз закрытие приложения
            game.setScreen(new MyGdxGame(game));//запуск основно игры
            dispose();
        }
    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}




