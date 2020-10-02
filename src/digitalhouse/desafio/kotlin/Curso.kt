package digitalhouse.desafio.kotlin

data class Curso (
        val cod: Int,
        var nome: String,
        var qtdAlunos: Int,
) {
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null
    val alunos = mutableListOf<Aluno>()

    fun addAluno(aluno: Aluno): Boolean{
        return if (alunos.size < qtdAlunos){
            alunos.add(aluno)
            true
        } else {
            false
        }
    }

    fun delAluno(aluno: Aluno) {
        alunos.remove(aluno)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (cod != other.cod) return false

        return true
    }

    override fun hashCode(): Int {
        return cod
    }

    override fun toString(): String {
        return "Curso(cod=$cod, nome='$nome', qtdAlunos=$qtdAlunos, professorTitular=$professorTitular, professorAdjunto=$professorAdjunto, alunos=$alunos)"
    }
}