package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        var firstName:String? = null
        var lastName:String? = null
        if (fullName == "" || fullName == " ") {
            return firstName to lastName
        } else {
            firstName = parts?.getOrNull(0)
            lastName = parts?.getOrNull(1)
            return firstName to lastName
        }
    }

    fun transliterarion(payload: String, divider:String = " "): String {
        val lettersAr: ArrayList<String> = ArrayList()
        for(j in 0..payload.length-1) {
            lettersAr.add(payload[j].toString())
        }
        var payloadAr:ArrayList<String> = ArrayList()
        var resultWord = ""
        for(i in 0..payload.length-1){
            when(lettersAr[i]) {
                "а"-> payloadAr.add("a")
                "б"-> payloadAr.add("b")
                "в"-> payloadAr.add("v")
                "г"-> payloadAr.add("g")
                "д"-> payloadAr.add("d")
                "е"-> payloadAr.add("e")
                "ё"-> payloadAr.add("e")
                "ж"-> payloadAr.add("zh")
                "з"-> payloadAr.add("z")
                "и"-> payloadAr.add("i")
                "й"-> payloadAr.add("i")
                "к"-> payloadAr.add("k")
                "л"-> payloadAr.add("l")
                "м"-> payloadAr.add("m")
                "н"-> payloadAr.add("n")
                "о"-> payloadAr.add("o")
                "п"-> payloadAr.add("p")
                "р"-> payloadAr.add("r")
                "с"-> payloadAr.add("s")
                "т"-> payloadAr.add("t")
                "у"-> payloadAr.add("u")
                "ф"-> payloadAr.add("f")
                "х"-> payloadAr.add("h")
                "ц"-> payloadAr.add("c")
                "ч"-> payloadAr.add("ch")
                "ш"-> payloadAr.add("sh")
                "щ"-> payloadAr.add("sh'")
                "ъ"-> payloadAr.add("")
                "ы"-> payloadAr.add("i")
                "ь"-> payloadAr.add("")
                "э"-> payloadAr.add("e")
                "ю"-> payloadAr.add("yu")
                "я"-> payloadAr.add("ya")
                "А"-> payloadAr.add("A")
                "Б"-> payloadAr.add("B")
                "В"-> payloadAr.add("V")
                "Г"-> payloadAr.add("G")
                "Д"-> payloadAr.add("D")
                "Е"-> payloadAr.add("E")
                "Ё"-> payloadAr.add("E")
                "Ж"-> payloadAr.add("Zh")
                "З"-> payloadAr.add("Z")
                "И"-> payloadAr.add("I")
                "Й"-> payloadAr.add("I")
                "К"-> payloadAr.add("K")
                "Л"-> payloadAr.add("L")
                "М"-> payloadAr.add("M")
                "Н"-> payloadAr.add("N")
                "О"-> payloadAr.add("O")
                "П"-> payloadAr.add("P")
                "Р"-> payloadAr.add("R")
                "С"-> payloadAr.add("S")
                "Т"-> payloadAr.add("T")
                "У"-> payloadAr.add("U")
                "Ф"-> payloadAr.add("F")
                "Х"-> payloadAr.add("H")
                "Ц"-> payloadAr.add("C")
                "Ч"-> payloadAr.add("Ch")
                "Ш"-> payloadAr.add("Sh")
                "Щ"-> payloadAr.add("Sh'")
                "Э"-> payloadAr.add("E")
                "Ю"-> payloadAr.add("Yu")
                "Я"-> payloadAr.add("Ya")
                " "-> payloadAr.add(divider)
                else-> payloadAr.add(lettersAr[i])
            }
        }

        for(j in 0..payloadAr.count()-1){
            resultWord = resultWord + payloadAr[j]
        }
        return resultWord
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var firstInit:String? = null
        var lastInit:String? = null
        val firstNameAr:List<String>? = firstName?.split("")
        val lastNameAr:List<String>? = lastName?.split("")

        if((firstName == "" || firstName == " ") && (lastName == "" || lastName == " ")){
            return "$firstInit $lastInit"
        }else{
            firstInit = firstNameAr?.getOrNull(1)
            lastInit = lastNameAr?.getOrNull(1)
            firstInit = firstInit?.toUpperCase()
            lastInit = lastInit?.toUpperCase()

            return "$firstInit${if(lastInit == null)" null" else "$lastInit"}"
        }
    }
}
