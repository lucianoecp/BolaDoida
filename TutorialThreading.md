# MultiThreading em Java

## Introdução
MultiThreading em Java é uma caracteristica que permite que duas ou mais partes do programa executem concorrentemente para maior utilização do CPU.

Imagine que temos o seguinte problema, em um programa que simula um restaurante.

Abstraindo algumas partes, temos que:

- O Garçom vai até a mesa e verifica qual o pedido de um cliente.
- O Garcom anota o pedido e leva para o cozinheiro.
- O Cozinheiro prepara a comida.
- O Cozinheiro avisa o Garcom, o Garcom leva o pedido até a mesa que o solicitou.

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

## Criação de Threads
Para criação de Threads podemos:
- Estender a classe Thread.
- Implementar a interface Runnable.

Primeiro criamos uma classe que extende a classe java.lang.Thread, e dentro dessa classe sobrescrevemos a classe run(), a Thread começa dentro do metodo run() e chamamos o metodo start() para executa-la.

Dentro da interface Runnable, tamnbem existe o metodo run(), e é dentro deste metodo que devemos colocar nossos procedimentos.

A diferença entre extender a classe Thread e implementar a interface Runnable, é que se extendermos a classe Thread, não poderemos extender nenhuma outra classe, pois java não suporte multiplas heranças, no entanto, implementando a interface Runnable, ainda é possivel extender outra Classe.

```
public class Restaurante {
    public static void main(String[] args) {
        new Thread(t1).start();
        new Thread(t2).start();
    }

    private static Runnable atendendo = new Runnable() {
        public void run() {
            try{
                 garcom1.atendeMesa()
                 garcom2.atendeMesa()
                }
            } catch (Exception e){}

        }
    };

    private static Runnable cozinhando = new Runnable() {
        public void run() {
            try{
                cozinheiro.cozinha()
                }
            } catch (Exception e){}
       }
    };
}
```
Ainda que abstrada, isso mostra que, enquanto o cozinheiro está preparando a comida, o atendente está atendendo novas mesas.

## Conclusão 

Ainda que seja util, não deve-se utilizar de qualquer maneira esta tecnica de processamento em paralelo com intuito de obter uma execução mais rapida, ou pode acontecer de processos necessitarem mais recursos e estes recursos não estarem disponiveis.


