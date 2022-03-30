package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;


public class Drop extends Game {//откуда game

    SpriteBatch batch;
    BitmapFont font;

    public void create() {
        //отрисовка шрифта должна быть в дропе
        batch = new SpriteBatch();
        // libGDX по умолчанию использует Arial шрифт.
        font = new BitmapFont();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("assets/GOST_A.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = 20;
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter);
        generator.dispose();
        this.setScreen(new MainMenuScreen(this));// запуск начального окна

    }

    public void render() {
        super.render(); // важно!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}