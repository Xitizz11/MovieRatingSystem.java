import java.util.Scanner;

public class MovieRatingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: User Input Handling
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Step 2: Accept and Validate Movie Ratings
        String[] movieNames = new String[5];
        int[] ratings = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the name of movie #" + (i + 1) + ": ");
            movieNames[i] = scanner.nextLine();

            int rating;
            while (true) {
                System.out.print("Rate this movie from 1 to 10: ");
                if (scanner.hasNextInt()) {
                    rating = scanner.nextInt();
                    if (rating >= 1 && rating <= 10) {
                        break;
                    }
                } else {
                    scanner.next(); // consume invalid input
                }
                System.out.println("Invalid rating. Please enter a number between 1 and 10.");
            }
            ratings[i] = rating;
            scanner.nextLine(); // consume newline
        }

        // Step 3: Calculate Average Rating
        int total = 0;
        for (int rating : ratings) {
            total += rating;
        }
        double average = total / 5.0;
        System.out.printf("%n%s, your average movie rating is: %.2f%n", name, average);

        // Step 4: Rating Classification
        if (average >= 9) {
            System.out.println("You are a awesome!");
        } else if (average >= 7) {
            System.out.println("You enjoy movies quite a bit.");
        } else if (average >= 5) {
            System.out.println("You have excitement for movies.");
        } else {
            System.out.println("You are a mild critic!");
        }

        // Step 5: Favorite Movie Check (Nested if)
        boolean foundMasterpiece = false;
        boolean foundLowRated = false;
        for (int rating : ratings) {
            if (rating == 10) {
                foundMasterpiece = true;
            }
            if (rating < 4) {
                foundLowRated = true;
            }
        }
        if (foundMasterpiece) {
            System.out.println("Wow! You found a masterpiece.");
        }
        if (foundLowRated) {
            System.out.println("That movie didn’t impress you much.");
        }

        // Step 6: Logical Operators Check
        boolean allHigh = true;
        boolean anyVeryLow = false;
        for (int rating : ratings) {
            if (rating < 7) {
                allHigh = false;
            }
            if (rating < 3) {
                anyVeryLow = true;
            }
        }
        if (allHigh) {
            System.out.println("You seem to enjoy most movies.");
        } else if (anyVeryLow) {
            System.out.println("You have strong opinions on movies!");
        }

        // Step 7: Genre Preference with Switch
        System.out.print("\nEnter your favorite movie genre (Action, Comedy, Horror, Drama, Sci-Fi): ");
        String genre = scanner.nextLine().trim().toLowerCase();

        switch (genre) {
            case "action":
                System.out.println("You love excitement and thrills!");
                break;
            case "comedy":
                System.out.println("You enjoy a good laugh.");
                break;
            case "horror":
                System.out.println("You have a taste for fear!");
                break;
            case "drama":
                System.out.println("You appreciate deep storytelling.");
                break;
            case "sci-fi":
                System.out.println("You love futuristic and imaginative worlds!");
                break;
            default:
                System.out.println("That's an interesting genre!");
        }

        // Step 8: Conditional Operator
        String recommendation = genre.equals("sci-fi") ? "Interstellar" : "The Dark Knight";
        System.out.println("We recommend you watch: " + recommendation);

        scanner.close();
    }
}
