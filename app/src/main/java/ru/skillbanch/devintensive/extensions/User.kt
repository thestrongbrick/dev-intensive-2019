package ru.skillbanch.devintensive.extensions

import ru.skillbanch.devintensive.models.User
import ru.skillbanch.devintensive.models.UserView
import ru.skillbanch.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {

    val nickName = Utils.transliterarion("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "was never" else if(isOnline) "online" else "last time was ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status
    )
}
fun Date.humanizeDiff(date:Date = Date()):String{
    val shit = ""
    return shit

}