package xyz.funnycoding

import scalaz.zio.ZIO

trait Json {
  val instance: Json.Service
}
object Json {
  trait Service {
    def jsonDecoder[T](iterator: Iterator[String]): Either[DeserializationError, T]
  }
}
trait CirceJson extends Json {
  override val instance: Json.Service = new Json.Service {
    override def jsonDecoder[T](iterator: Iterator[String]): Either[DeserializationError, T] =
      Left(DeserializationError("oh hell `-_-"))
  }
}
object CirceJson extends CirceJson

object Js {
  def decode[T](iterator: Iterator[String]): ZIO[Json, DeserializationError, T] = {
    ZIO.accessM(v => ZIO.fromEither(v.instance.jsonDecoder[T](iterator)))
  }
}