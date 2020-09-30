package digitalhouse.desafio.kotlin

class Aluno(val cod: Int, var nome: String, var sobrenome: String){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Aluno

        if (cod != other.cod) return false

        return true
    }

    override fun hashCode(): Int {
        return cod
    }

    override fun toString(): String {
        return "Aluno(cod=$cod, nome='$nome', sobrenome='$sobrenome')"
    }
}