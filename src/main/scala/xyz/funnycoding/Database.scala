package xyz.funnycoding

import scalaz.zio.{Task, ZIO}

trait Database {
  val database: Database.Service
}
object Database {
  // The database service
  trait Service {
    def lookupUser(uid: String): Task[String]
  }
}
trait DatabaseLive extends Database {
  val database =
    (userID: String) => Task.succeed(s"hello child $userID")
}
object DatabaseLive extends DatabaseLive

object DB {
  def lookupUser(uid: String): ZIO[Database, Throwable, String] =
    ZIO.accessM(_.database lookupUser uid)
}