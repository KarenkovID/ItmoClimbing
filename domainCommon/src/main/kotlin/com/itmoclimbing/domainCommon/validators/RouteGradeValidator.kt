package com.itmoclimbing.domainCommon.validators

object RouteGradeValidator {

    fun validate(grade: String) = Regex("[4-9][a-cA-C]\\+?").matches(grade)

}