// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {

    // Conteudo de um curso especifico
    val androidConteudo = listOf(
        ConteudoEducacional(nome = "Princípios básicos em kotlin", duracao = 60),
        ConteudoEducacional(nome = "POO em kotlin", duracao = 90),
        ConteudoEducacional(nome = "Seu primeiro app em, kotlin", duracao = 90),
        ConteudoEducacional(nome = "Banco de dados com Room DB", duracao = 120),
        ConteudoEducacional(nome = "REST API com Retrofit", duracao = 150),
        ConteudoEducacional(nome = "Arquitetura MVVM", duracao = 90),
        ConteudoEducacional(nome = "Injeção de dependência com Hilt", duracao = 60),
        ConteudoEducacional(nome = "Seu primerio app em Jetpack compose", duracao = 120)
    )

    // Formacao de um curso especifico
    val formacaoAndroid = Formacao(nome = "Formação Android", conteudos = androidConteudo)

    // Instancias de alunos novos
    val iniciante = Usuario("Jose", Nivel.BASICO)
    val intermediario = Usuario("Mario", Nivel.INTERMEDIARIO)
    val avancado = Usuario("Daniela", Nivel.DIFICIL)

    // Alunos novos se matriculando
    formacaoAndroid.matricular(iniciante)
    formacaoAndroid.matricular(intermediario)
    formacaoAndroid.matricular(avancado)

    // Checando quais aulas o alunos tem disponivel
    val insiraNome: String? = readLine()

    when(formacaoAndroid.inscritos.find { usuario -> usuario.nome == insiraNome }?.nivel) {
        Nivel.BASICO -> {
            println("O usuario $iniciante tem disponivel as aulas ${formacaoAndroid.conteudos.subList(0, 3)}")
        }
        Nivel.INTERMEDIARIO -> {
            println("O usuario $iniciante tem disponivel as aulas ${formacaoAndroid.conteudos.subList(0, 6)}")
        }
        Nivel.DIFICIL -> {
            println("O usuario $iniciante tem disponivel as aulas ${formacaoAndroid.conteudos}")
        }
        else -> println("Usuario nao existe")
    }
}
