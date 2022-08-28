# Game-of-Life
Project for coding Game of Life in Java

class Celula(estado: Boolean, posicion: Posicion) {
private var estado: Boolean = estado
var posicion: Posicion = posicion
var vecinas: MutableSet<Celula> = mutableSetOf()

    fun vivir() {
        estado = true
    }

    fun morir() {
        estado = false
    }

    fun estaViva(): Boolean {
        return estado
    }

    fun anadirVecina(celula: Celula) {
        vecinas.add(celula)
    }

    fun siguienteEstado() {
        val vecinasVivas = vecinas.filter { celula: Celula -> celula.estaViva() }.size
        val vecinasMuertas = vecinas.size - vecinasVivas

/*        if(estaViva() && (vecinasVivas == 2 || vecinasVivas == 3)) vivir()
else morir()*/

        if(vecinasVivas < 2 && estaViva()) morir()
        else if(vecinasVivas > 3 && estaViva()) morir()
        else if((vecinasVivas == 2 || vecinasVivas == 3) && estaViva()) vivir()
        else if(!estaViva() && vecinasVivas == 3) vivir()
    }
}

class Posicion(fila: Int, columna: Int) {
private var fila: Int = fila
private var columna: Int = columna
}

fun main() {
val celula00 = Celula(estado = true, posicion = Posicion(0,0))
val celula01 = Celula(estado = false, posicion = Posicion(0,1))
val celula10 = Celula(estado = false, posicion = Posicion(1,0))
val celula11 = Celula(estado = true, posicion = Posicion(1,1))
celula00.anadirVecina(celula01)
celula00.anadirVecina(celula10)
celula00.anadirVecina(celula11)
celula00.siguienteEstado()
println(celula00)
}


----------------------------------------------------------

.class GameOfLive(listOf: List<List<Int>>){
fun nextGeneration(): List<List<Int>> {
return listOf(
listOf(0,1,0,1,0,0,0,1),
listOf(1,0,0,0,0,1,0,0),
listOf(1,0,0,0,0,1,0,0),
listOf(1,0,0,0,0,1,0,0)
)
}


}

fun main(){
var juegoDeLaVida: GameOfLive = GameOfLive(
listOf(
listOf(0,1,0,1,0,0,0,1),
listOf(1,0,0,0,0,1,0,0),
listOf(1,0,0,0,0,1,0,0),
listOf(1,0,0,0,0,1,0,0)
)
)
println(juegoDeLaVida.nextGeneration())
println(juegoDeLaVida.nextGeneration())

}
