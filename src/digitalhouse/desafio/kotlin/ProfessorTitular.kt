package digitalhouse.desafio.kotlin

class ProfessorTitular(
        cod: Int,
        nome: String,
        sobrenome: String,
        var especialidade: String
) : Professor(cod, nome, sobrenome)