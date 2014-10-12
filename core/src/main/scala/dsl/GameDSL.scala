package dsl


import com.badlogic.gdx.Files.FileType
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music

/**
 * Created by home on 10.10.2014.
 */
object GameDSL {


  def musicLoop(path: String): Music = {
    var music = Gdx.audio.newMusic(Gdx.files.getFileHandle(path, FileType.Internal))
    music.setLooping(true)
    music.play()
    music
  }




}
