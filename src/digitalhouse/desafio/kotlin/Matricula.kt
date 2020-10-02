package digitalhouse.desafio.kotlin

import java.util.*

class Matricula(val aluno: Aluno, val curso: Curso) {

    val data = Date()

    override fun toString(): String {
        return "Matricula(aluno=$aluno, curso=$curso, data=$data)"
    }
}