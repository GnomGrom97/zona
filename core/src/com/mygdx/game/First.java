package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.Rectangle;
import java.security.Key;

public class First implements Screen {
    //переменные
    Texture WindowImage;
    final Drop game;
    SpriteBatch batch;
    OrthographicCamera camera;
    TextureRegion backgroundTexture;
    Rectangle Window;
    public First(final Drop gam) {
        //переменные- описание
        game = gam;
        backgroundTexture =new TextureRegion(new Texture("bus.jpg"),0,0,800,480);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
       WindowImage = new Texture(Gdx.files.internal("window-.png"));
        Window = new Rectangle();//параметы окна
        Window.x =10;//ширина области
        Window.y = 100;//высота области
        Window.width = 128;
        Window.height = 128;
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
        game.font.draw(game.batch, "ТЫ прощаешься с Алисой, размышляешь о прекрасных днях и садишься в автобус", 100, 150);
        game.font.draw(game.batch, "Пожалуйста нажмите 1 для продолжения", 100, 100);


//смена тектуры если, нажал кнопку

        //   backgroundTexture=new TextureRegion(new Texture("window-.png"),-110,-110,800,480);
//отрисовать сразу же диалоговое окно на фоне!!!!!!!!!!
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
            backgroundTexture = new TextureRegion(new Texture("Second.jpg"), 0, 0, 800, 480);
            game.batch.draw(WindowImage, 50, 10);
            game.font.draw(game.batch, "ТЫ прощаешься с Алисой, размышляешь о прекрасных днях и садишься в автобус", 100, 150);
             game.font.draw(game.batch, "Пожалуйста нажмите 1 для продолжения", 100, 100);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            backgroundTexture = new TextureRegion(new Texture("bus.jpg"), 0, 0, 800, 480);
        }

        game.batch.end();
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
