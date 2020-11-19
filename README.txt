Duuudas:

Escribo aca para no olvidarme: como se haria para que los infectados extiendan a thread? hay que cambiar la clase abstracta por una interfaz?
Yo no haría que extiendan a thread porque cada vez que crees un infectado va a haber un thread nuevo. Haría que haya una clase tipo super inteligencia ahre y que ahí controle a los infectados a través de la clase movimiento. Igual eso último lo iba a consultar mañana.


Otra cosa que nada que ver, las clases abstractas no tienen métodos abstractos, tendrían que tener?
(Me parece que no es necesario que tengas métodos abstractos, tipo puede haber o no)

Visitor para todas las entidades es necesario? O podría haber solo para el jugador y los infectados? Ya que son los que interactúan con otras cosas.

Tengo dudas sobre la lógica del mapa: Nosotras dijimos que ibamos a manejar las posiciones de cada cosa en el mapa desde la lógica, pero me parece que es neceario que cada Entidad 
tenga una posición, asi sería más fácil, y les damos la posicion que tienen que tener desde la lógica del mapa. Es algo que se me ocurrió recién, habria que ver bien jaja.
Otra cosa, vieron que el otro día habiamos hablado de tener una lista para los proyectiles y para los premios en el mapa, y me parece que no hace falta, porque eso tipo no sería
parte del mapa en si, sino que van a aparecer en cierto momento, entonces hice una lista de entidades que sean objetos a agregar y ahí podrian ir apareciendo.
