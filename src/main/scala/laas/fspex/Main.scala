package laas.fspex

/**
 * Created by administrateur on 16/04/2015.
 */

import laas.fspex.utils.Logger
import laas.fspex.parser._


object Main {

  private var _context:String = null
  def context = _context

  def initContext(configPath:String) = {
    _context = configPath
    println("Initializing ...")

  }

  def main(args:Array[String]):Unit = {

    if(args.length < 1) {
      Logger.error("Must use subcommand")
      System.exit(1)
    }



    val call =
      args(0) match {
        case "extract" =>
          val configPath = args(1)
          () => OsmParser.parse(configPath)
          
        case "hello" => 
          () => println("hello world!")

        case s =>
          Logger.error(s"Unknown subcommand $s")
          System.exit(1)
          () => { }
      }

    call()
  }

}
