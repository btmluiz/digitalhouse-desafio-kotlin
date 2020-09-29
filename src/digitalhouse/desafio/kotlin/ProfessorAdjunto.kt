package digitalhouse.desafio.kotlin

class ProfessorAdjunto(
        cod: Int,
        nome: String,
        sobrenome: String,
        var horasDeMonitoria: String
) : Professor(cod, nome, sobrenome)