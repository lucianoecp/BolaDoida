# MultiThreading em Java

## Introdução
MultiThreading em Java é uma caracteristica que permite que duas ou mais partes do programa executem concorrentemente para maior utilização do CPU.

Imagine que temos o seguinte problema, em um programa que simula um restaurante.

'''
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
'''

1- Estender a classe Thread
2- Implementar a interface Runnable
