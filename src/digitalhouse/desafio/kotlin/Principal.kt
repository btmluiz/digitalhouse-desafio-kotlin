package digitalhouse.desafio.kotlin

fun main() {
    val digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarProfessorTitular("Pedro", "Sampaio", 2001, "Kotlin")
    digitalHouseManager.registrarProfessorTitular("Rafaela", "Fernandes", 2002, "Python")

    digitalHouseManager.registrarProfessorAdjunto("Tereza", "Martins", 2001, 40)
    digitalHouseManager.registrarProfessorAdjunto("Tarcisio", "Moura", 2002, 55)

    digitalHouseManager.registrarCurso("Full Stack", 20001, 3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)

    digitalHouseManager.alocarProfessores(20001, 2002, 2001)
    digitalHouseManager.alocarProfessores(20002, 2001, 2002)

    digitalHouseManager.matricularAluno("Bruno", "Souza", 1000)
    digitalHouseManager.matricularAluno("Carla", "Albuquerque", 1001)
    digitalHouseManager.matricularAluno("Augusto", "Pessoa", 1002)
    digitalHouseManager.matricularAluno("Michelle", "Souza", 1003)

    digitalHouseManager.matricularAluno(1000, 20001)
    digitalHouseManager.matricularAluno(1001, 20001)

    digitalHouseManager.matricularAluno(1000, 20002)
    digitalHouseManager.matricularAluno(1002, 20002)
    digitalHouseManager.matricularAluno(1003, 20002)

    println(digitalHouseManager)
}