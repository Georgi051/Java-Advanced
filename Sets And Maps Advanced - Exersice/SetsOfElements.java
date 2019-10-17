package SetsAndMaps.exersice;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lengthSets = scanner.nextLine().split("\\s+");
        int firstlength = Integer.parseInt(lengthSets[0]);
        int seclength = Integer.parseInt(lengthSets[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while (firstlength-- > 0) {
            int num = Integer.parseInt(scanner.nextLine());
            firstSet.add(num);
        }
        while (seclength-- > 0) {
            int num = Integer.parseInt(scanner.nextLine());
            secondSet.add(num);
        }
        if (firstSet.size() > secondSet.size()){
            for (Integer numSecondSet : secondSet) {
                for (Integer numfirstSet : firstSet) {
                    if (numSecondSet.equals(numfirstSet)) {
                        System.out.print(numfirstSet + " ");
                    }
                }
            }
        }else if (secondSet.size() > firstSet.size()){
            for (Integer numfirstSet  : firstSet) {
                for (Integer  numSecondSet : secondSet) {
                    if (numfirstSet.equals(numSecondSet)) {
                        System.out.print(numfirstSet + " ");
                    }
                }
            }
        }else {
            for (Integer numSecondSet : secondSet) {
                for (Integer numfirstSet : firstSet) {
                    if (numSecondSet.equals(numfirstSet)) {
                        System.out.print(numfirstSet + " ");
                    }
                }
            }
        }
    }
}

