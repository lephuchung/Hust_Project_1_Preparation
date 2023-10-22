import java.util.Arrays;
import java.util.Scanner;

public class Ex6 {
    static final int MAX_PERSONS = 10001;
    static String[] child = new String[MAX_PERSONS];
    static String[] parent = new String[MAX_PERSONS];
    static int[] numDescendants = new int[MAX_PERSONS];
    static int[] generation = new int[MAX_PERSONS];
    static int numPersons = 0;

    public static void initFamilyTree() {
        Arrays.fill(numDescendants, 0);
        Arrays.fill(generation, -1);
    }

    public static void addPerson(String childName, String parentName) {
        child[numPersons] = childName;
        parent[numPersons] = parentName;
        numPersons++;
    }

    public static int getDescendants(String name) {
        int totalDescendants = 0;
        for (int i = 0; i < numPersons; i++) {
            if (parent[i].equals(name)) {
                totalDescendants += 1 + getDescendants(child[i]);
            }
        }
        numDescendants[numPersons] = totalDescendants;
        return totalDescendants;
    }

    public static int getGenerations(String name) {
        int maxGeneration = 0;
        for (int i = 0; i < numPersons; i++) {
            if (parent[i].equals(name)) {
                int generationCount = 1 + getGenerations(child[i]);
                maxGeneration = Math.max(generationCount, maxGeneration);
            }
        }
        generation[numPersons] = maxGeneration;
        return maxGeneration;
    }

    public static void main(String[] args) {
        initFamilyTree();

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.next();
            if (input.equals("***")) {
                break;
            }
            System.out.println("nhap ten: ");
            String parentName = scanner.next();
            addPerson(input, parentName);
        }

        int[] results = new int[MAX_PERSONS];
        int resultCount = 0;
        while (true) {
            input = scanner.next();
            if (input.equals("***")) {
                break;
            }
            String name = scanner.next();
            if (input.equals("descendants")) {
                int descendants = getDescendants(name);
                results[resultCount] = descendants;
            } else if (input.equals("generation")) {
                int generations = getGenerations(name);
                results[resultCount] = generations;
            }
            resultCount++;
        }

        for (int i = 0; i < resultCount; i++) {
            System.out.println(results[i]);
        }
    }
}
