# MultiThreading em Java

## Introdução
MultiThreading em Java é uma caracteristica que permite que duas ou mais partes do programa executem concorrentemente para maior utilização do CPU.

Imagine que temos o seguinte problema, em um programa que simula um restaurante.

Abstraindo algumas partes, temos que:

1- O Garçom vai até a mesa e verifica qual o pedido de um cliente.
2- O Garcom anota o pedido e leva para o cozinheiro.
3- O Cozinheiro prepara a comida.
4- O Cozinheiro avisa o Garcom, o Garcom leva o pedido até a mesa que o solicitou.

```
public void Restaurante(){
    Garcom garcom1 = new Garcom();
    Garcom garcom2 = new Garcom();

    Cozinheiro cozinheiro = new Cozinheioro()

    garcom1.atendeMesa()
    garcom2.atendeMesa()

    garcom1.encaminhaPedido()
    garcom2.encaminhaPedido()

    cozinheiro.cozinha()
    garcom1.atendeMesa()
    
  }
```
Com o programa dessa maneira, teriamos alguns problemas, como:
O outro garçom teria que esperar o primeiro garçom atender a mesa para poder atender outra mesa, e após levar o pedido, ele teria que esperar o cozinheiro preparar o pedido para poder entregar e então atender outra mesa, mas nenhum restaurante iria bem caso funcionasse dessa maneira, e por isso o uso de Thread para simular essas atividades que ocorrem paralelas, é muito util.

Para criação de Threads precisamos de:
1- Estender a classe Thread
2- Implementar a interface Runnable
