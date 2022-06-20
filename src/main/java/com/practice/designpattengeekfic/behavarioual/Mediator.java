package com.practice.designpattengeekfic.behavarioual;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Mediator {

    public static void main(String[] args) {
        new Mediator().call();
    }

    private void call() {
        Dialog dialog = new Dialog();
        dialog.enterUsername("Geekific");
        dialog.enterPassword("LikeAndSubscribe");

        dialog.simulateLoginClicked();

        dialog.simulateForgotPassClicked();
    }
}

interface Component {
    void setMediator(ComponentMediator componentMediator);

    String getName();
}

interface ComponentMediator {
    void login();

    void forgotPass();
}

class LoginButton extends JButton implements Component {

    private ComponentMediator componentMediator;

    public LoginButton() {
        super("Log In");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        componentMediator.login();
    }

    @Override
    public void setMediator(ComponentMediator componentMediator) {
        this.componentMediator = componentMediator;
    }

    @Override
    public String getName() {
        return "LoginButton";
    }
}

class ForgotPasswordButton extends JButton implements Component {

    private ComponentMediator componentMediator;

    public ForgotPasswordButton() {
        super("Forgot Password?");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        componentMediator.forgotPass();
    }

    @Override
    public void setMediator(ComponentMediator componentMediator) {
        this.componentMediator = componentMediator;
    }

    @Override
    public String getName() {
        return "ForgotPasswordButton";
    }
}

class Dialog implements ComponentMediator {

    private final JTextField userTextBox = new JTextField();
    private final JTextField passTextBox = new JTextField();
    private final LoginButton loginButton = new LoginButton();
    private final ForgotPasswordButton passwordButton = new ForgotPasswordButton();

    public Dialog() {
        loginButton.setMediator(this);
        passwordButton.setMediator(this);
    }

    @Override
    public void login() {
        System.out.println("Logging in...");
        String username = userTextBox.getText();
        String password = passTextBox.getText();
        // validate username and password
        // logs in the user or pops error message
    }

    @Override
    public void forgotPass() {
        System.out.println("Generating new Password...");
        String username = userTextBox.getText();
        // generate new pass for the user
        // send mail to this username with new pass
    }

    public void enterUsername(String username) {
        userTextBox.setText(username);
    }

    public void enterPassword(String password) {
        passTextBox.setText(password);
    }

    public void simulateLoginClicked() {
        loginButton.fireActionPerformed(new ActionEvent(this, 0, "login"));
    }

    public void simulateForgotPassClicked() {
        passwordButton.fireActionPerformed(new ActionEvent(this, 0, "forgot pass"));
    }
}
