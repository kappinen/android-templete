package screens

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.{Color, GL20, Texture}
import com.badlogic.gdx.math.Matrix4
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.{Gdx, Screen}
import com.kappinen.Bathfighter
import dsl.GameDSL
;


/**
 * Created by evka on 10.10.2014.
 */
class MainScreen(main:Bathfighter) extends Screen {
  val spriteBatch = new SpriteBatch();
  val background = new Texture(Gdx.files.internal("data/mainScreenBackground.jpg"));
  val music = GameDSL.musicLoop("data/music.mp3")
  var resolution = (480:Float, 320:Float)
  val viewMatrix = new Matrix4()
  val transformMatrix = new Matrix4();

  override def render(delta: Float): Unit = {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    viewMatrix.setToOrtho2D(0, 0, resolution._1, resolution._2);
    spriteBatch.setProjectionMatrix(viewMatrix);
    spriteBatch.setTransformMatrix(transformMatrix);
    spriteBatch.begin();
    spriteBatch.disableBlending();
    spriteBatch.setColor(Color.WHITE);
//    spriteBatch.draw(background, 0, 0, resolution._1, resolution._2, 0, 0, background.getWidth, background.getHeight, false, false);
    spriteBatch.enableBlending();
    spriteBatch.end();

  }

  override def hide(): Unit = {
    Gdx.app.debug("MainScreen","MainScreen.hide")
  }

  override def resize(width: Int, height: Int): Unit = {
    Gdx.app.debug("MainScreen", "MainScreen.resize " + width + ":" + height)
    resolution = (width.toFloat, height.toFloat)
  }

  override def dispose(): Unit = {
    Gdx.app.debug("MainScreen", "MainScreen.dispose")
    List(music, spriteBatch, background).map((a:Disposable) => a.dispose())

    scala.sys.exit()
  }

  override def pause(): Unit = {
    Gdx.app.debug("MainScreen", "MainScreen.pause")
    music.pause() }

  override def show(): Unit = { Gdx.app.debug("MainScreen", "MainScreen.show") }

  override def resume(): Unit = {
    Gdx.app.debug("MainScreen","MainScreen.resume")
    music.play()
  }
}
