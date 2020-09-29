package digitalhouse.desafio.kotlin

class ProfessorAdjunto(
        cod: Int,
        nome: String,
        sobrenome: String,
        var horasDeMonitoria: Int
) : Professor(cod, nome, sobrenome)