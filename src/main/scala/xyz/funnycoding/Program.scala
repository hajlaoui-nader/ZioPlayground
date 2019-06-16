package xyz.funnycoding


import scalaz.zio.{App, ZIO}

object Program extends App {

  type StaticJsonReader = File with Json

  def prog[T](filename: String): ZIO[StaticJsonReader, PlaygroundError, String] = for {
    read <- FileReader.read(filename)
    decoded <- Js.decode(read)
  } yield decoded


  override def run(args: List[String]): ZIO[Environment, Nothing, Int] = {
    val x: StaticJsonReader = new SyncFile with CirceJson
    prog[List[String]]("sample.json")
      .provide(x)
      .fold(err => {
        println(err)
        0
      },
        v => {
          println(v)
          1
        })
  }
}
