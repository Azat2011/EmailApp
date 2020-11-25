package emailapp;

public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("Adel", "Tet");
        em1.setMailboxCapacity(300);

        System.out.println(em1.showInfo());

        Email em2 = new Email("Jon", "West");
        em2.changePassword("Aa123456");
        System.out.println(em2.showInfo());
        System.out.println("Your new PASSWORD: " + em2.getPassword());
    }
}