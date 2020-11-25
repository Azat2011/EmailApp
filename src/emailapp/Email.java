package emailapp;

import java.util.Scanner;

public class Email {
    private String firsName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // конструктор для получения имени и фамилии
    public Email(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
        //System.out.println("EMAIL CREATED: " + this.firsName + " " + this.lastName);

        // вызывает метод запрашивающий отдел
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        // вызывает метод который возвращает случайный пароль
        this.password = randomPassword(8);
        System.out.println("Your password is: " + this.password);

        //комбинировать элементы для создание почты
        email = firsName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        // System.out.println("Your email is: " + email);
    }

    // какой отдел или департамент
    private String setDepartment() {
        System.out.print("New worker: " + firsName + "." + " Department Codes:\n1 for Sales\n2 for development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int detChoice = in.nextInt();
        if (detChoice == 1) {
            return "sales";
        } else if (detChoice == 2) {
            return "dev";
        } else if (detChoice == 3) {
            return "acct";
        } else {
            return "";
        }

    }

    //генерация и рандомная подборка пароля
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //установить размер почты
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //установить альтернативный email адрес
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //смена пароля
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firsName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}