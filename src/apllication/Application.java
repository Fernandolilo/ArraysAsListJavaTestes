package apllication;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        List<String> numerosAleatorios = Arrays.asList(
                "1", "0", "2", "3", "4", "5","6", "7", "10", "8", "9");
        System.out.println("Imprima todos os numeros aleatorios: " + numerosAleatorios);
        System.out.println("-----------------------");

        /*
         * podemos fazer o uso do forEach neste caso precisamos instanciar um new Consumer
         * o Consumer é uma interface funcional, dentro do consumer atribuirá uma String
         * nocaso é void não retorna nada, veja a implementação a baixo;
         */
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String num) {
                System.out.println(num);
            }
        });
        System.out.println("-----------------------");
        // uma outra forma usando o lambda;;;
        System.out.println("Usando o Lambda");
        numerosAleatorios.stream().forEach(s -> System.out.println(s));
        System.out.println("-----------------------");
        System.out.println("Usando o Lambda sem o Stream");
        numerosAleatorios.forEach(s -> System.out.println(s));

        System.out.println("-----------------------");
        System.out.println("Usando o Lambda sem o Stream e com o method reference");
        numerosAleatorios.forEach(System.out::println);
        System.out.println("-----------------------");

        /*
         * no caso dentro do Set não permite reetição de numeros,
         * caso haja algum numero repetido eles serão excluidos.
         */
        System.out.println("Pegue os  primeiros numeros e coloque dentro de um Set: ");
        numerosAleatorios.stream().limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //outra forma de fazer o teste;

        Set<String> collectSet = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(collectSet.toString());
        System.out.println("-----------------------");

        System.out.println("Pegue uma lista de String e à transforme em em inteiros");
                 numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-----------------------");

        System.out.println("Pegue os números maiores que 2 e os coloque dentro de uma Lista: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-----------------------");
        System.out.println("Mostre a media dos números");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average().ifPresent(System.out::println);

        System.out.println("-----------------------");
        System.out.println("Remova os números impares");
        System.out.println("Pegue uma lista de String e à transforme em em inteiros");
        List<Integer> num = numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        num.removeIf(integer -> (integer % 2 !=0));
        System.out.println(num);
    }
}
