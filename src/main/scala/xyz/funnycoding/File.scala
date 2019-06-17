package xyz.funnycoding

import scalaz.zio.{IO, ZIO}

import scala.io.Source

trait File {
  val service: File.Service
}
object File {
  trait Service {
    def read(fileName: String): IO[FileNotFoundError, Iterator[String]]
  }
}
trait SyncFile extends File {
  override val service: File.Service = (fileName: String) => ZIO
    .effect(Source.fromResource(fileName).getLines())
    .refineOrDie {
      case _: Exception => FileNotFoundError(s"$fileName file not found")
    }
}
object SyncFile extends SyncFile

object FileReader {
  def read(filename: String): ZIO[File, FileNotFoundError, Iterator[String]] =
    ZIO.accessM(_.service read filename)
}