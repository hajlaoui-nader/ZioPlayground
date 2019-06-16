package xyz.funnycoding

sealed trait PlaygroundError
final case class FileNotFoundError(msg: String) extends PlaygroundError
final case class DeserializationError(msg: String) extends PlaygroundError