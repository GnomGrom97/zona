package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.Drop;
import java.awt.Rectangle;
import java.awt.Window;
import java.util.Iterator;

class MyGdxGame implements Screen {
	final Drop game;
	SpriteBatch batch;
	OrthographicCamera camera;
	Texture dropImage;
	Texture bucketImage;
	Texture WindowImage;
	Sound dropSound;
	Music rainMusic;
	Rectangle Window;
	Rectangle drop;
	TextureRegion background;
	 Stage stage;
	 BitmapFont font;
	 String saveName;
	 TextButton.TextButtonStyle textButtonStyle;
	private StringBuilder getPhrase;//отрисосвка фраз
	private boolean buttonIsPressed;
	private Texture textField;

	public MyGdxGame(final Drop gam) {
		this.game = gam;
		//это русский язык пока не корректно
		batch = new SpriteBatch();
		font = new BitmapFont();
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("assets/GOST_A.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
		parameter.size = 20;
		parameter.color = Color.WHITE;
		font = generator.generateFont(parameter);
		generator.dispose();
		//отрисовка текстуры фона
		background = new TextureRegion(new Texture("images.jpg"), 0, 0, 800, 480);
		// Загрузка изображений окна и ульяны, каждое размером 64x64 пикселей
		dropImage = new Texture(Gdx.files.internal("ylya.png"));

		WindowImage = new Texture(Gdx.files.internal("window-.png"));

// Загрузка звукового эффекта падающей капли и фоновой "музыки" дождя
		dropSound = Gdx.audio.newSound(Gdx.files.internal("bite_carrot_raw.mp3"));//нужен мп3
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("water-boiling.mp3"));
// Сразу же воспроизводиться музыка для фона
		rainMusic.setLooping(true);
		rainMusic.play();
		//Камера и SpriteBatch
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch();
		// создается Rectangle для представления ведра
		//bucket = new Rectangle();
		drop = new Rectangle();//параметры ульяны
		drop.x = -200;//ширина области
		drop.y = 100;//высота области
		drop.width = 64;
		drop.height = 64;
		Window = new Rectangle();//параметы окна
		Window.x =50;//ширина области
		Window.y = -200;//высота области
		Window.width = 128;
		Window.height = 128;
	}
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ScreenUtils.clear(1, 0, 0, 1);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();//отрисовка
		game.batch.draw(background, 0, 0, background.getRegionWidth(), background.getRegionHeight());

		//отрисовка Девочки и диалога
		game.batch.draw(dropImage, drop.x, drop.y);
		game.batch.draw(WindowImage, Window.x, Window.y);
		game.batch.draw(textField, 0, 0);
		//Здесь рисуется текст
		game.font.draw(game.batch, getPhrase.toString(), 10, 150);
//кривой цикл перемещения диалога и девочки в центр
		if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_3)) {

			while (drop.x != 50) {
				drop.x += 100 * Gdx.graphics.getDeltaTime();//вылетает если не 100
			}
			if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_3)) {//тык по экрану
				while (Window.y != 1) {
					Window.y += 100 * Gdx.graphics.getDeltaTime();//вылетает если не 100
					game.font.draw(game.batch, "Please,touch 4 to go,4!", 100, 100);
				}
			}
		}
			//закрытие основного цикла
			game.batch.end();
			//dropSound.play();
			;//счетчик кролей
			// if (dropsGathered >= 5) {
			//   game.setScreen(new End(game));
			//  dispose();
			// }

	}
	@Override
	public void dispose() {
		// высвобождение всех нативных ресурсов
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
		batch.dispose();
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
	public void show() {
		// воспроизведение фоновой музыки
		// когда отображается экрана
		//rainMusic.play();
	}
}
