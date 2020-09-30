package digitalhouse.desafio.kotlin

class DigitalHouseManager {
    val alunos = mutableListOf<Aluno>()
    val professores = mutableListOf<Professor>()
    val cursos = mutableListOf<Curso>()
    val matriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, cod: Int, qtdAlunos: Int) =
            cursos.add(Curso(cod, nome, qtdAlunos))

    fun excluirCurso(cod: Int) {
        val delCurso = cursos.filter { it.cod == cod }
        cursos.removeAll(delCurso)
        matriculas.removeIf { it.curso in delCurso }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, cod: Int, qtdHoras: Int) {
        if (professores.filter { it.cod == cod }.isEmpty()) {
            professores.add(ProfessorAdjunto(cod, nome, sobrenome, qtdHoras))
        } else {
            println("Professor adjunto já cadastrado!")
        }
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, cod: Int, especialidade: String) {
        if (professores.filter { it.cod == cod }.isEmpty())
            professores.add(ProfessorTitular(cod, nome, sobrenome, especialidade))
        else
            println("Professor titular já cadastrado!")
    }

    fun excluirProfessor(cod: Int) {
        val delProfessor = professores.filter { it.cod == cod }
        professores.removeAll(delProfessor)
        cursos.forEach {
            if (it.professorAdjunto as Professor in delProfessor)
                it.professorAdjunto = null
            if (it.professorTitular as Professor in delProfessor)
                it.professorTitular = null
        }
    }

    fun matricularAluno(nome: String, sobrenome: String, cod: Int) {
        if (alunos.filter { it.cod == cod }.isEmpty())
            alunos.add(Aluno(cod, nome, sobrenome))
        else
            println("Aluno já matriculado!")
    }

    fun matricularAluno(codAluno: Int, codCurso: Int) {
        try {
            val curso = cursos.first { it.cod == codCurso }
            val aluno = alunos.first { it.cod == codAluno }
            if (curso.alunos.filter { it.equals(aluno) }.isEmpty()) {
                if (curso.addAluno(aluno)) {
                    matriculas.add(Matricula(aluno, curso))
                    println("Aluno: ${aluno.nome} ${aluno.sobrenome} adicionado com sucesso ao curso: ${curso.nome}")
                } else
                    println("Turma Cheia")
            } else
                println("O aluno: ${aluno.nome} ${aluno.sobrenome} já matriculado neste curso!")
        } catch (e: NoSuchElementException) {
            println("Aluno ou curso não cadastrado")
        }
    }

    fun alocarProfessores(codCurso: Int, codProfTitular: Int, codProfAdjunto: Int) {
        try {
            val professorTitular = professores.filter { it is ProfessorTitular && it.cod == codProfTitular }
            val professorAdjunto = professores.filter { it is ProfessorAdjunto && it.cod == codProfAdjunto }
            try {
                val curso = cursos.first { it.cod == codCurso }
                curso.professorTitular = professorTitular as ProfessorTitular?
                curso.professorAdjunto = professorAdjunto as ProfessorAdjunto?

                println("Professores alocados com sucesso ao curso ${curso.nome}")
            } catch (e: NoSuchElementException) {
                println("Curso não encontrado")
            }
        } catch (e: NoSuchElementException) {
            println("Professor Titular ou adjunto não encontrado")
        }
    }

    override fun toString(): String {
        return "DigitalHouseManager(alunos=$alunos, professores=$professores, cursos=$cursos, matriculas=$matriculas)"
    }
}