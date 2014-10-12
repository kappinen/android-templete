package com.kappinen

import com.badlogic.gdx.{Application, Game, Gdx}
import screens.{GameLoopScreen, MainScreen}



class Bathfighter extends Game {

    override def create() {
      Gdx.app.setLogLevel(Application.LOG_DEBUG)

      Gdx.app.debug("Game", "Starts")

      nextScreen(null)

      Gdx.app.debug("Game", "Ends")
    }

   def nextScreen[T](screen:T) = screen match {
     case _:MainScreen => setScreen(new GameLoopScreen(this))
     case _=> setScreen(new MainScreen(this))
   }
}


