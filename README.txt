*Updates de hoy*

logicaEntidades: modifiqué todo básicamente, ahora las mismas clases se encargan de crear su propia gráfica y visitor, así le ahorramos responsabilidad a las otras clases. 

Clase Juego: es un invento porque no sabía que otro nombre usar, cada vez que vean juego.unmetodo() a juego lo pueden cambiar por el nombre de la clase que si vaya a existir, lo que sí, necesito que esos métodos existan: un metodo que devuelva al jugador, un metodo que realentice a los enemigos y otro que cambie el arma del jugador por un tiempo determinado. El tiempo en estos dos ultimos puede ser acumulativo, onda que tenga dos atributos de instancia tiempoCO y tiempoSA y cada vez que el jugador agarre el premio Cuarentena obligatoria que dura 10 seg, se sumen 10 seg (tambien se puede hacer que el tiempo no sea acumulativo, onda te quedan 7seg de premio y agarras otro premio del mismo tipo y volves a tener 10 seg de premio; eso que lo decida quien haga el método jajajajaja).

graficaEntidades: todo auxiliar para que los constructores de las entidades no tiren error jajajaja la idea mas o menos está pero el resize es re de onda (lo saqué de mi sudoku ahre) para no olvidar de hacer resize en el futuro (? y chequeen el gif jugador.gif en la carpeta IMG <3
Metodo que encontre leyendo los metodos de la clase: etiqueta.getBounds().intersects(otraetiqueta.getBounds()); <--- asi controlemos las colisiones

visitor: cambié el visitor de los premios temporales, lo que dije de la clase juego también se aplica acá.
