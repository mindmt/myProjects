package br.com.mthdev.stockSystem.model;

import java.util.Scanner;

public class Login {
    private String user;
    private String password;
    private String keyWord;
    private String email;
    private Scanner sc;

    public Login() {
        this.sc = new Scanner(System.in);
    }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getKeyWord() { return keyWord; }
    public void setKeyWord(String keyWord) { this.keyWord = keyWord; }

    public void register() {
        System.out.println("### Registro de Usuário ###");
        this.user = readInput("Digite seu nome:");

        this.email = readInput("Digite seu e-mail:");
        while (!isValidEmail(this.email)) {
            System.out.println("E-mail inválido! Digite novamente.");
            this.email = readInput("Digite seu e-mail:");
        }

        this.password = setPassword();

        this.keyWord = readInput("Digite uma palavra-chave para recuperação de senha:");

        System.out.println("Registro concluído com sucesso!");
    }

    private String readInput(String message) {
        System.out.println(message);
        return sc.nextLine().trim();
    }

    private String setPassword() {
        String password, confirmPassword;
        do {
            password = readInput("Digite sua senha:");
            confirmPassword = readInput("Confirme sua senha:");

            if (!password.equals(confirmPassword)) {
                System.out.println("As senhas não coincidem! Tente novamente.");
            } else if (!isValidPassword(password)) {
                System.out.println("Senha fraca! A senha deve conter pelo menos 6 caracteres.");
            } else {
                return password;
            }
        } while (true);
    }

    private boolean isValidEmail(String email) {
        return email.endsWith("@gmail.com");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    public void login() {

    }
}
