package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.security.Key;

public class Third implements Screen {//фотка взрыва
    final Drop game;
    SpriteBatch batch;
    OrthographicCamera camera;
    TextureRegion backgroundTexture;

    public Third(final Drop gam) {
        game = gam;
        backgroundTexture = new TextureRegion(new Texture("vsruv.jpg"), 0, 0, 800, 480);
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
        game.font.draw(game.batch, "Returning home, you think about a great summer and what lies ahead.", 100, 150);

        //Возвращаясь домой ты думаеш об отлично проведенном лете и о том, что предстоит в будущем.
        game.font.draw(game.batch, "Please,touch 3 to go,THIRD!", 100, 100);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)){
            game.setScreen(new Four(game));//запуск основно игры
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

