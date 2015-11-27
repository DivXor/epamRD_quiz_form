package kz.epam.quiz.controller.form;

import kz.epam.quiz.controller.form.validation.FieldMatch;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class RegistrationForm {
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Please enter valid email")
    @Size(max = 200)
    private String email;
    @NotEmpty(message = "Password field cannot be empty")
    @Size(max = 100)
    private String password;
    @NotEmpty(message = "Password confirm field cannot be empty")
    private String confirmPassword;
    @NotEmpty(message = "First name cannot be empty")
    @Size(max = 100)
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    @Size(max = 100)
    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
