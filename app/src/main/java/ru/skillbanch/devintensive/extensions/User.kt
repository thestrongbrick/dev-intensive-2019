package ru.skillbanch.devintensive.extensions

import ru.skillbanch.devintensive.models.User
import ru.skillbanch.devintensive.models.UserView
import ru.skillbanch.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {

    val nickName = Utils.transliterarion("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "никогда не был" else if(isOnline) "online" else "последний раз был ${lastVisit.humanizeDiff(lastVisit)}"

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
    val todayDate = Date()
    val yestDate:Date = date
    println(todayDate.time - yestDate.time)
    if(todayDate>=yestDate) {
        when ((todayDate.time - yestDate.time) / 1000) {
            in 0..1 -> return "только что"
            in 1..45 -> return "несколько секунд назад"
            in 45..75 -> return "минуту назад"

            in 75..45 * 60 -> return "${when (((todayDate.time - yestDate.time) / 1000 / 60).toInt()) {
                1, 21, 31, 41 -> "${(todayDate.time - yestDate.time) / 1000 / 60} минуту"
                in 2..4, in 22..24, in 32..34, in 42..44 -> "${(todayDate.time - yestDate.time) / 1000 / 60} минуты"
                else -> "${(todayDate.time - yestDate.time) / 1000 / 60} минут"
            }
            } назад"

            in 45 * 60..75 * 60 -> return "час назад"

            in 75 * 60..22 * 60 * 60 -> return "${when (((todayDate.time - yestDate.time) / 1000 / 60 / 60).toInt()) {
                1, 21 -> "${(todayDate.time - yestDate.time) / 1000 / 60 / 60} час"
                in 2..4, 22 -> "${(todayDate.time - yestDate.time) / 1000 / 60 / 60} часа"
                else -> "${(todayDate.time - yestDate.time) / 1000 / 60 / 60} часов"
            }
            } назад"

            in 22 * 60 * 60..26 * 60 * 60 -> return "день назад"

            in 26 * 60 * 60..360 * 24 * 60 * 60 -> return "${when (((todayDate.time - yestDate.time) / 1000 / 60 / 60 / 24).toInt()) {
                1, 21, 31, 41, 51, 61, 71, 81, 91, 101, 111, 121, 131, 141, 151, 161, 171,
                181, 191, 201, 211, 221, 231, 241, 251, 261, 271, 281, 291, 301, 311, 321, 331, 341, 351 -> "${(todayDate.time - yestDate.time) / 1000 / 60 / 60 / 24} день"
                in 2..4, in 22..24, in 32..34, in 42..44, in 52..54, in 62..64, in 72..74, in 82..84, in 92..94, in 102..104,
                in 122..124, in 132..134, in 142..144, in 152..154, in 162..164, in 172..174, in 182..184, in 192..194,
                in 202..204, in 222..224, in 232..234, in 242..244, in 252..254, in 262..264, in 272..274, in 282..284,
                in 292..294, in 302..304, in 322..324, in 332..334, in 342..344, in 352..354 -> "${(todayDate.time - yestDate.time) / 1000 / 60 / 60 / 24} дня"
                else -> "${(todayDate.time - yestDate.time) / 1000 / 60 / 60 / 24} дней"
            }
            } назад"

            else -> return "более года назад"
        }
    }else{
        when ((yestDate.time - todayDate.time) / 1000) {
            in 0..1 -> return "вот-вот"
            in 1..45 -> return "через несколько секунд"
            in 45..75 -> return "через минуту"

            in 75..45 * 60 -> return "через ${when (((yestDate.time - todayDate.time) / 1000 / 60).toInt()) {
                1, 21, 31, 41 -> "${(todayDate.time - yestDate.time) / 1000 / 60} минуту"
                in 2..4, in 22..24, in 32..34, in 42..44 -> "${(yestDate.time - todayDate.time) / 1000 / 60} минуты"
                else -> "${(yestDate.time - todayDate.time) / 1000 / 60} минут"
            }
            }"

            in 45 * 60..75 * 60 -> return "через час"

            in 75 * 60..22 * 60 * 60 -> return "через ${when (((yestDate.time - todayDate.time) / 1000 / 60 / 60).toInt()) {
                1, 21 -> "${(yestDate.time - todayDate.time) / 1000 / 60 / 60} час"
                in 2..4, 22 -> "${(yestDate.time - todayDate.time) / 1000 / 60 / 60} часа"
                else -> "${(yestDate.time - todayDate.time) / 1000 / 60 / 60} часов"
            }
            }"

            in 22 * 60 * 60..26 * 60 * 60 -> return "через день"

            in 26 * 60 * 60..360 * 24 * 60 * 60 -> return "через ${when (((yestDate.time - todayDate.time) / 1000 / 60 / 60 / 24).toInt()) {
                1, 21, 31, 41, 51, 61, 71, 81, 91, 101, 111, 121, 131, 141, 151, 161, 171,
                181, 191, 201, 211, 221, 231, 241, 251, 261, 271, 281, 291, 301, 311, 321, 331, 341, 351 -> "${(yestDate.time - todayDate.time) / 1000 / 60 / 60 / 24} день"
                in 2..4, in 22..24, in 32..34, in 42..44, in 52..54, in 62..64, in 72..74, in 82..84, in 92..94, in 102..104,
                in 122..124, in 132..134, in 142..144, in 152..154, in 162..164, in 172..174, in 182..184, in 192..194,
                in 202..204, in 222..224, in 232..234, in 242..244, in 252..254, in 262..264, in 272..274, in 282..284,
                in 292..294, in 302..304, in 322..324, in 332..334, in 342..344, in 352..354 -> "${(yestDate.time - todayDate.time) / 1000 / 60 / 60 / 24} дня"
                else -> "${(yestDate.time - todayDate.time) / 1000 / 60 / 60 / 24} дней"
            }
            }"

            else -> return "более чем через год"
        }
    }
}


