package com.bignerdranch.android.test
//Задание 1
class Employee(val id: Long, val vacancy: Vacancy) {

    fun getVacancy(): String{
        return vacancy.getVacancy()
    }

    fun getid(): Long{
        return id
    }
}

class Vacancy(val profession: String){
    fun getVacancy(): String {
        return profession
    }
}