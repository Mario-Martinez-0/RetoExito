#Gustavo Andres Ramirez Muñoz
#language: es

Característica: Yo como usuario quiero comprar productos aletorios

  Antecedentes: Abrir pagina
    Dado que el usuario se encuentra en la pagina

  Esquema del escenario: El usuario seleccionara productos aleatorioamente
    Dado que el usuario se dirige a la <categoria> con <subCategoria>
    Cuando el usuario selecciona <cantidad> productos aletorios y estos con cantidades aletorias
    Entonces el usuario validara el nombre de los productos en el carrito
    Y validara el precio total de productos en el carrito
    Y validara las cantidades de los productos
    Y validara el mumero de productos
    Ejemplos:
      | categoria  | subCategoria | cantidad |
      | Dormitorio | Cabeceros    | 5        |


