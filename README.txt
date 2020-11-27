*Updates de hoy*

VER TANDAS DE INFECTADOS

para la parte grafica: nuestra GUI principal es un JFrame, su contentPane es un PanelImagen. El panel imagen de lo único que se encarga es de poner el GIF de fondo para el juego.
Empezamos intentando poner el JLabel del jugador principal, para hacerlo se siguen una serie de pasos para minimizar responsabilidades. 
- desde la GUI, se crea una nueva instacia de MenteJuego, el cual extiende a Juego. 
- desde MenteJuego, su constructor inicializaJugador(). Se calcula la posicion en el mapa, su movimiento, y se crea una nueva instacia. (respeta el patron singleton para que el cliente no tenga la posibilidad de crear más de una instancia de un Jugador, por lo cual no se utiliza de forma explicita el constructor del Jugador) 
- por ultimo, se llama a agregarJugador() en JFrameJuego, se recupera su JLabel y se agrega al contentPane.  

logicaEntidades: modifiqué todo básicamente, ahora las mismas clases se encargan de crear su propia gráfica y visitor, así le ahorramos responsabilidad a las otras clases. Pd: ahora TODAS las entidades tienen vida (sino era un lío que algunas tengan vida y otras colisionen, ademas como esto no estaba en Entidad.java, no ibamos a poder acceder a los metodos del arreglo de entidades en el juego).

Clase Juego: es un invento porque no sabía que otro nombre usar, cada vez que vean juego.unmetodo() a juego lo pueden cambiar por el nombre de la clase que si vaya a existir, lo que sí, necesito que esos métodos existan: un metodo que devuelva al jugador, un metodo que realentice a los enemigos y otro que cambie el arma del jugador por un tiempo determinado. El tiempo en estos dos ultimos puede ser acumulativo, onda que tenga dos atributos de instancia tiempoCO y tiempoSA y cada vez que el jugador agarre el premio Cuarentena obligatoria que dura 10 seg, se sumen 10 seg (tambien se puede hacer que el tiempo no sea acumulativo, onda te quedan 7seg de premio y agarras otro premio del mismo tipo y volves a tener 10 seg de premio; eso que lo decida quien haga el método jajajajaja).

graficaEntidades: todo auxiliar para que los constructores de las entidades no tiren error jajajaja la idea mas o menos está pero el resize es re de onda (lo saqué de mi sudoku ahre) para no olvidar de hacer resize en el futuro (? y chequeen el gif jugador.gif en la carpeta IMG <3
Metodo que encontre leyendo los metodos de la clase: etiqueta.getBounds().intersects(otraetiqueta.getBounds()); <--- asi controlemos las colisiones

visitor: cambié el visitor de los premios temporales, lo que dije de la clase juego también se aplica acá.

clase Juego: no compila porque faltan metodos, pero por si lo quieren leer, tiene muchos comentarios. Obvio pueden agregar lo que les guste

deje subida en el main una clase que es un jpanel con una imagen de fondo, super basica, pero para no hacerla desde cero. es lo mismo si se quiere usar un GIF

Cambié el nombre de la clase LogicaMapa por Juego. Lo puse en un package logicaJuego junto con lo de los niveles(que solo hice la clase abstracta nivel con los métodos que fui
necesitando).
No estoy segura de cómo crear el movimiento del proyectil del jugador, tipo que posiciones ponerle, xq como que la posicion inicial tendria que estar relacionado con la relacion del jugador.
Necesitaría agregar un método que getEntidadGrafica en todas las entidades.
--->agregado!

Agrugue varias cosas al MenteJuego, dentro del run. Metodos que quitan a las entidades que ya no tienen vida, para detectar colisiones y para que los enemigos disparen. 
Me genera dudas el enemigosDisparar(), porque atacar devuelve un Proyectil y no estoy segura si crear un Proyectil nuevo y de ahi enviarle una instruccion al Proyectil o como. 

Los cambios en la clase Juego, son dos metodos nuevos que tienen los parametros con las clases inicializadas para evitar nulls. 
Y actualizado Movimiento y MovimientoJugador con esos metodos (no es abstracto para no implementarlo en todas las clases, se puede arreglar. En MovimientoJugador deje ambos metodos por si alguna clase usaba el sin parametros)
