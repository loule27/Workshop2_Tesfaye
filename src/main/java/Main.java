import java.util.Scanner;

public class Main
{
    public static String checkInDisplayOptions() {
        return "Options: \n C - Check in a book\n " +
                "X - Go back to home screen";
    }
    public static String checkOutDisplayOptions() {
        return "1 - Show Available Books\n" + "2 - Show Checked Out Books\n" +
        "3 - Exit\n";
    }

    public static String checkoutOptions(){
        return "Options:\n1 - Select a select a book to check out\n" +
        "2 - Go back to home screen";
    }
    public static void main(String[] args) {

        Book[] library = {

                new Book(1, "Atomic Habits", "9780735211292", false, ""),
                new Book(2, "The 7 Habits of Highly Effective People", "9781982137274", false, ""),
                new Book(3, "Think and Grow Rich", "9781585424337", false, ""),
                new Book(4, "Rich Dad Poor Dad", "9781612681139", false, ""),
                new Book(5, "The Lean Startup", "9780307887894", false, ""),
                new Book(6, "Clean Code", "9780132350884", false, ""),
                new Book(7, "Introduction to Algorithms", "9780262046305", false, ""),
                new Book(8, "Design Patterns", "9780201633610", false, ""),
                new Book(9, "The Pragmatic Programmer", "9780135957059", false, ""),
                new Book(10, "Cracking the Coding Interview", "9780984782857", false, ""),
                new Book(11, "To Kill a Mockingbird", "9780061120084", false, ""),
                new Book(12, "1984", "9780451524935", false, ""),
                new Book(13, "The Great Gatsby", "9780743273565", false, ""),
                new Book(14, "Pride and Prejudice", "9780141439518", false, ""),
                new Book(15, "The Hobbit", "9780547928227", false, ""),
                new Book(16, "The Alchemist", "9780062315007", false, ""),
                new Book(17, "How to Win Friends and Influence People", "9780671027032", false, ""),
                new Book(18, "Deep Work", "9781455586691", false, ""),
                new Book(19, "Zero to One", "9780804139298", false, ""),
                new Book(20, "The Psychology of Money", "9780857197689", false, "")

        };

        Scanner kb = new Scanner(System.in);
        while(true){
            System.out.println("\nHome Screen");
            System.out.println(checkOutDisplayOptions());
            String choice = kb.nextLine();

            while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") ){
                System.out.println("Invalid Input choose from the following options: ");
                System.out.println("Options:");
                System.out.println(checkOutDisplayOptions());
                choice = kb.nextLine();
            }

            switch(choice){
                case "1":
                    System.out.println("----Available Books----");
                    for(Book book: library){
                        if(!book.isCheckedOut()){
                            System.out.println(book);
                        }
                    }
                    System.out.println(checkoutOptions());
                    String option = kb.nextLine();
                    while(!option.equals("1") && !option.equals("2")){
                        System.out.println("Invalid input, choose from the following options:");
                        System.out.println(checkoutOptions());
                        option = kb.nextLine();
                    }

                    if(option.equals("2")){
                        break;
                    }

                    boolean valid = false;
                    while(!valid){

                        boolean found = false;
                        System.out.println("Enter Book ID: ");
                        int id = kb.nextInt();
                        kb.nextLine();
                        for(Book book: library){
                            if(book.getId() == id) {
                                found = true;
                                if(book.isCheckedOut()) {
                                    System.out.println("Sorry, book has already been checked out.");
                                    break;
                                }
                                System.out.println("Enter your name: ");
                                String name = kb.nextLine();
                                book.checkOut(name);
                                System.out.println("Enjoy your book!");
                                valid = true;
                                break;

                            }
                        }
                        if(!found) {
                            System.out.println("Book not found try again.");
                        }
                    }
                    break;

               case "2":
                   System.out.println("----Checked Out Books----");
                   for(Book book: library){
                       if(book.isCheckedOut()){
                           System.out.println(book.displayCheckedOut());
                       }
                   }
                   System.out.println(checkInDisplayOptions());
                   String input = kb.nextLine();
                   while(!input.equalsIgnoreCase("C") && !input.equalsIgnoreCase("X")) {
                       System.out.println("Invalid input, choose from the following options:");
                       System.out.println(checkInDisplayOptions());
                       input = kb.nextLine();
                   }
                   if (input.equalsIgnoreCase("X")) {
                       break;
                   }
                   System.out.println("Enter the ID of the book to check in: ");
                   int bookId = kb.nextInt();
                   kb.nextLine();
                   boolean found = false;


                   while(!found){
                       System.out.println("Book not found try again.\nEnter the ID of the book to check in: ");
                       bookId = kb.nextInt();
                       kb.nextLine();
                       for(Book book: library){
                           if(book.getId() == bookId){
                               if(book.isCheckedOut()){
                                   book.checkIn();
                                   found = true;
                                   System.out.println("Book checked in. Thank you!");
                               }
                           }

                       }
                   }
                    break;

                case "3":
                    System.exit(0);
                    break;

            }
        }
    }
}

