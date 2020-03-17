package HR;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Resident[] r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i) )
                .toArray(Resident[]::new);
        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));
        Collections.sort(residentList, Comparator.comparing(Resident::getName));

        Hospital[] h = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Hospital("H" + i, (int) (Math.random() * 4)))
                .toArray(Hospital[]::new);
        TreeSet<Hospital> hospitalsList = new TreeSet<>(Hospital::compareTo);
        hospitalsList.addAll(Arrays.asList(h));

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            resPrefMap.put(r[i], Arrays.asList(h[0], h[1], h[2]));
        }

        // printing the residents who accept H0
        for (Resident resident : residentList) {
            if (resPrefMap.get(resident).contains(h[0])) {
                System.out.println(resident.getName());
            }
        }
        // collecting the residents who accept H0 and H2
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        List<Resident> result = new ArrayList<>();
        for (Resident res : residentList) {
            if (resPrefMap.get(res).containsAll(target)) {
                result.add(res);
            }
        }

    }
}
