enum class Nivel{BASICO, INTERMEDIARIO, AVANCADO}

data class Usuario(val nome : String)

data class ConteudoEducacional(val nome : String, val nivel:Nivel, val duracao : Int = 60)

data class Formacao(val nome:String, val conteudos: List<ConteudoEducacional>){ 
val inscritos = mutableListOf<Usuario>()
//funcao para matricular usuarios
fun matricular(usuario: Usuario){
    inscritos.add(usuario)
    println("usuario ${usuario.nome} inscrito com sucesso..")
    println()
}//fim de matricular()
//funcão para mostrar na tela informacões sobre a formacao
fun exibeInfo():Unit{
    var cont : Int = 0
    println("           FORMACAO : ${this.nome}")
    println()
    println("               CONTEUDOS")
    println("_______________________________________________")
    println("NOME               DURACAO.    NIVEL")
    conteudos.forEach{
      println("${it.nome}          ${it.duracao}     ${it.nivel}")
    }     
    println()
    println("_______________________________________________")  
    println()
    println("               INSCRITOS")
    println("_______________________________________________")
    inscritos.forEach{
        cont++
        println("(${cont}) = ${it.nome}")
        
        
    }
    println("______________________________________________")
    println("TOTAL DE INSCRITOS : ${cont}")
}//fim de exiberInfo()


}

fun main() {
    //criando usuarios
    val user1 = Usuario("Rafael")
    val user2 = Usuario("Pedro")
    val user3 = Usuario("Maria")
    
    //declaracão dos conteudos 
    val conteudo1 = ConteudoEducacional("funcoes kotlin", Nivel.INTERMEDIARIO, 25 )
    
    val conteudo2 = ConteudoEducacional("Exception", Nivel.INTERMEDIARIO, 20)
    
    val conteudo3 = ConteudoEducacional("Classes", Nivel.AVANCADO, 30)
    
    //criando uma lista com os conteudos a ser adicionado
    val listaConteudos : List<ConteudoEducacional> = listOf(conteudo1, conteudo2, conteudo3)
    
    //criando primeira formacao
    val formacao1 = Formacao("Kotlin",listOf(conteudo1, conteudo2))
    
    //inscrevendo usuarios
    formacao1.matricular(user1)
    formacao1.matricular(user2)
    formacao1.matricular(user3)
    
    //mostrando informacao sobre a formacao   
    formacao1.exibeInfo()
    
  
    

}
