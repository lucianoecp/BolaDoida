# MultiThreading em Java

## Introdução
MultiThreading em Java é uma caracteristica que permite que duas ou mais partes do programa executem concorrentemente para maior utilização do CPU.

Imagine que temos o seguinte problema, em um programa que simula um restaurante.

Abstraindo algumas partes, temos que:
1- O Garçom vai até a mesa e verifica qual o pedido de um cliente.]
2- O Garcom anota o pedido e leva para o cozinheiro.

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

1- Estender a classe Thread
2- Implementar a interface Runnable
