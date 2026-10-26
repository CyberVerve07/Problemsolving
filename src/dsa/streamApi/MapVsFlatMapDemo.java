package dsa.streamApi;

import java.util.Arrays;
import java.util.List;

class Developer {
    private String name;
    private List<String> skills;

    public Developer(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }
}

public class MapVsFlatMapDemo {
    public static void main(String[] args) {
        List<Developer> team = List.of(
                new Developer("Aditya", List.of("Java", "Spring Boot")),
                new Developer("Rohit", List.of("Docker", "Kubernetes", "Java"))
        );

        // 1. Using map(): Returns a List of Lists (Nested)
        List<List<String>> mapResult = team.stream()
                .map(Developer::getSkills)
                .toList();
        System.out.println("map() output: " + mapResult);
        // Output: [[Java, Spring Boot], [Docker, Kubernetes, Java]]

        // 2. Using flatMap(): Returns a single flat List of all distinct skills
        List<String> flatMapResult = team.stream()
                .flatMap(dev -> dev.getSkills().stream()) // Flattens inner lists into one stream
                .distinct()
                .toList();
        System.out.println("flatMap() output: " + flatMapResult);
        // Output: [Java, Spring Boot, Docker, Kubernetes]
    }
}