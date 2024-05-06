package Objects;

public class User {
    private int userId;
    private String username;
    private String password;
    private String name_surname;
    private String email;
    private int age;
    private String phoneNumber;
    private String gender;
    private String cardNumber;

    public User(String username, String password, String name_surname, String email, int age, String phoneNumber, String gender, String cardNumber) {
        this.username = username;
        this.password = password;
        this.name_surname = name_surname;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.cardNumber = cardNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName_surname() {
        return name_surname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
