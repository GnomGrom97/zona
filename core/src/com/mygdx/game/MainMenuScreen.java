package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenuScreen implements Screen {//принадлежит ошибка при переключении экранов работы (нее открывает  окно
    final Drop game;
    SpriteBatch batch;
    OrthographicCamera camera;
    TextureRegion backgroundTexture;
    BitmapFont font;
    String saveName;
    TextButton.TextButtonStyle textButtonStyle;

    public MainMenuScreen(final Drop gam) {
        game = gam;
        batch = new SpriteBatch();

        backgroundTexture = new TextureRegion(new Texture("zona.jpg"), 0, 0, 800, 480);
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
        game.font.draw(game.batch, "Добро пожаловать в Бесконечну зону !!! ", 100, 150);
        game.font.draw(game.batch, "Пожалуйста нажмите левую кнопку мышы, для смены фона используется 1,2 и тд", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {//если нажимаем то запускаем
            game.setScreen(new First(game));//запуск основно игры// запуск ферста
            dispose();
        }
         if (Gdx.input.isKeyPressed(Input.Keys.NUM_5)) {//если нажимаем то запускаем
              game.setScreen(new Seven(game));//запуск основно игры// запуск ферста
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