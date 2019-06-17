package xyz.funnycoding

import org.scalatest.FunSpec
import scalaz.zio.{Runtime, ZIO}
import scalaz.zio.internal.{Platform, PlatformLive}

class Bla extends FunSpec{

  type StaticJsonReader = File with Json

  def prog[T](filename: String): ZIO[StaticJsonReader, PlaygroundError, T] = for {
    read <- ZIO.environment[File].flatMap(_.service.read(filename))
    decoded <- Js.decode[T](read)
  } yield decoded

  private val platform: Platform = PlatformLive.Default

  val myRuntime =
    Runtime(new SyncFile with CirceJson, platform)



  describe("chwerreb ") {
    it("shows its lips") {
      assert(myRuntime.unsafeRun(prog[List[String]]("sample.json")) == Nil)

    }

  }

}
