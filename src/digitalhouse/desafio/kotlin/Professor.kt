package digitalhouse.desafio.kotlin

data class Professor(
        override val cod: Int,
        override var nome: String,
        override var sobrenome: String
) : Cadastro {
    
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