package SetsAndMaps;

        import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> book = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String continent = inputData[0];
            String country = inputData[1];
            String city = inputData[2];

            if (!book.containsKey(continent)) {
                book.put(continent, new LinkedHashMap<>());
                LinkedHashMap<String, List<String>> value = book.get(continent);
                List<String> cityList = new ArrayList<>();
                cityList.add(city);
                value.put(country, cityList);
            } else {
                LinkedHashMap<String, List<String>> info = book.get(continent);
                if (!info.containsKey(country)) {
                    List<String> addCity = new ArrayList<>();
                    addCity.add(city);
                    info.put(country, addCity);
                } else {
                    book.get(continent).get(country).add(city);
                }
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : book.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            LinkedHashMap<String, List<String>> countrysAndCitys = entry.getValue();
            for (Map.Entry<String, List<String>> countryAndCity : countrysAndCitys.entrySet()) {
                List<String> citys = countryAndCity.getValue();
                System.out.printf("%s -> ", countryAndCity.getKey());
                for (int i = 0; i < citys.size(); i++) {
                    if (citys.size() - 1 > i) {
                        System.out.printf("%s, ", citys.get(i));
                    } else {
                        System.out.printf("%s", citys.get(i));
                    }
                }
                System.out.println();
            }
        }
    }
}
