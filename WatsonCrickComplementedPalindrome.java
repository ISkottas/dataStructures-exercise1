import java.util.Scanner;


public class WatsonCrickComplementedPalindrome {


    public static boolean checkWatsonCrick(StringDoubleEndedQueueImpl dLinkedList){
        StringDoubleEndedQueueImpl palindrome = new StringDoubleEndedQueueImpl();

        Node current = dLinkedList.head;
        while (current != null){
            String charNucleotide = getComplemented(current.data);
            palindrome.addFirst(charNucleotide);
            current = current.next;
        }

        //dLinkedList.printQueue(System.out);
        //System.out.println("The size of dLinkedList is " + dLinkedList.size());
        //palindrome.printQueue(System.out);
        //System.out.println("The size of palindrome is " + dLinkedList.size());

        boolean comparing = compareLists(dLinkedList,palindrome);
        //System.out.println(comparing);

        if (comparing){
            //System.out.println("Watson-Crick");
            return  true;
        } else {
            //System.out.println("Not Watson-Crick");
            return false;
        }

    }

    public static boolean compareLists(StringDoubleEndedQueueImpl list1, StringDoubleEndedQueueImpl list2) {
        Node current1 = list1.head;
        Node current2 = list2.head;

        // Traverse both lists and compare each element
        while (current1 != null && current2 != null) {
            //System.out.println("The node of list1 is " + current1.data);
            //System.out.println("The node of list2 is " + current2.data);
            if (current1.data.charAt(0) != current2.data.charAt(0)) {
                return false; // If data of current nodes doesn't match, return false
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        // If one of the lists is shorter than the other, they are not equal
        if (current1 != null || current2 != null) {
            return false;
        }

        // Both lists are equal
        return true;
    }

    private static String getComplemented(String nucleotide){
        switch (nucleotide){
            case "A":
                return "T";
            case "T":
                return "A";
            case "C":
                return "G";
            case "G":
                return "C";
            default:
                throw new IllegalArgumentException("Invalid nucleotide: " + nucleotide);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a DNA Sequence: ");
        String dnaSequence = scanner.nextLine();
        StringDoubleEndedQueueImpl dLinkedList = new StringDoubleEndedQueueImpl();
        boolean containsOnlyValidCharacters = checkFourCharacters(dnaSequence);

        if (containsOnlyValidCharacters){
            for (int i = 0 ; i <= dnaSequence.length() - 1 ; i++){

                dLinkedList.addLast(Character.toString(dnaSequence.charAt(i)));
            }
            //dLinkedList.printQueue(System.out);

            boolean isComplementedPalindrome = checkWatsonCrick(dLinkedList);

            if (isComplementedPalindrome){
                System.out.println("The " + dnaSequence + " is Watson-Crick complemented palindrome!");
            } else {
                System.out.println("The " + dnaSequence + " is not Watson-Crick complemented palindrome!");
            }

        } else {
            System.out.println("The sequence is invalid!");
        }

    }

    public static boolean checkFourCharacters(String dnaSequence){
        String regex = "[ATCG]+";
        return dnaSequence.matches(regex);
    }
}
