package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;
import java.util.Comparator;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Employee> employees = Data.employees();

        /* TO DO 1: Retourner le nombre des employ�s dont le nom commence avec n */
        long nbr = employees.stream()
                .filter(e -> e.getName().toLowerCase().startsWith("n"))
                .count();
        /* TO DO 2: Retourner la somme des salaires de tous les employ�s (hint: mapToInt) */
        long sum = employees.stream()
                .map(e -> e.getSalary())
                .reduce(0, (x, y) -> x + y);
        /* TO DO 2 */;

        /* TO DO 3: Retourner la moyenne des salaires des employ�s dont le nom commence avec s */
        double average = employees.stream()
                .filter(e -> e.getName().toLowerCase().startsWith("s"))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(Double.NaN);
        /* TO DO 4: Retourner la liste de tous les employ�s  */
        /* TO DO 4 */;
        /* TO DO 5: Retourner la liste des employ�s dont le nom commence par s */

        List<Employee> emps = employees.stream().collect(Collectors.toList());
        /* TO DO 5 */;

        List<Employee> emps2 = employees.stream()
                .filter(e -> e.getName().toLowerCase().startsWith("s"))
                .collect(Collectors.toList());
        //TO DO 6: Retourner true si il y a au min un employ�s dont le salaire > 1000, false si non

        boolean test = employees.stream().anyMatch(e -> e.getSalary() > 1000);

        /* TO DO 7: Afficher le premier employ� dont le nom commence avec s avec deux mani�res diff�rentes */
 /*First way*/
        Employee employer = employees.stream()
                .filter(e -> e.getName().toLowerCase().startsWith("s"))
                .findFirst()
                .get();

        /* TO DO 7 */ /*Second way*/
        employees.stream()
                .filter(e -> e.getName().toLowerCase().startsWith("s"))
                .findFirst()
                .ifPresent(e -> {
                    System.out.println(e.toString());
                });

        /* TO DO 8: Afficher le second employ� dont le nom commence avec s */
        employees.stream()
                .filter(e -> e.getName().toLowerCase().startsWith("s"))
                .skip(1)
                .findFirst()
                .ifPresent(e -> {
                    System.out.println(e.toString());
                });

        /* TO DO 9 Afficher n'importe quel employé dont le nom commence avec n */
        employees.stream()
                .filter(e -> e.getName().toLowerCase().startsWith("s"))
                .findAny()
                .ifPresent(e -> {
                    System.out.println(e.toString());
                });
        /* TO DO 9 */;
        /* TO DO 10 vérifier l'existance d'un employé dont le nom commence par a */

        boolean x = employees.stream()
                .anyMatch(e -> e.getName().toLowerCase().startsWith("a"));

        /* TO DO 11  Afficher les employés sans redondance */
        employees.stream().distinct().forEach(e -> {
            System.out.println(e.toString());
        });

        /*TO DO 12 Afficher l'employé ayant le salaire max */
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(e -> {
                    System.out.println(e.toString());
                });

    }
}
