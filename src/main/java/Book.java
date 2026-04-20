public class Book {

    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String title, String isbn, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String isCheckedOutTo() {
        return checkedOutTo;
    }

    public void checkOut(String name) {
        checkedOutTo = name;
        isCheckedOut = true;

    }

    public void checkIn() {
        checkedOutTo = "";
        isCheckedOut = false;
    }

    public String toString(){
        return "Book id: " + getId() + "  ISBN: " +
                getIsbn() + "  Title: " + getTitle();
    }

    public String displayCheckedOut() {
        return "Book id: " + getId() + "  ISBN: " +
                getIsbn() + "  Title: " + getTitle() +
                " Checked out to: " + getCheckedOutTo();
    }











}

