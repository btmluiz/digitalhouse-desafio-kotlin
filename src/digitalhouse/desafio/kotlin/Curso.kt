package digitalhouse.desafio.kotlin

data class Curso (
        val cod: Int,
        var nome: String,
        var professorTitular: ProfessorTitular,
        var professorAdjunto: ProfessorAdjunto,
        var qtdAlunos: Int,
) {
    val alunos = mutableListOf<Aluno>()

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
        return "Curso(cod=$cod, nome='$nome')"
    }
}