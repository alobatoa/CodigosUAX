package com.example.login.model

abstract class Persona {

    fun metodo1(): Unit {

    }
    fun metodo2(): Unit {

    }
    abstract fun metodoABS()
}

class Alumno : Persona() {
    override fun metodoABS() {

    }

}

class Profesor : Persona() {
    override fun metodoABS() {

    }

}

var persona = Alumno()
fun main() {
    val lista= arrayListOf<Persona>()
    lista.add(Alumno())
    lista.add(Profesor())
    lista.forEach { it.metodoABS() }
}