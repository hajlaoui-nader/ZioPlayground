package xyz.funnycoding

package Model {
//  final case class ProfileId(value: String) extends AnyVal
//  final case class Index(value: Long) extends AnyVal
  final case class Friend(id: Long, name: String)
  final case class Profile(_id: String, index: Long, friends: List[Friend])
  final case class Profiles(profiles: List[Profile])
}
