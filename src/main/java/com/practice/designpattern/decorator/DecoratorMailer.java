package com.practice.designpattern.decorator;

import java.util.function.Consumer;

public class DecoratorMailer {

    public static void main(String[] args) {
        /************ BAD Code for Mailer **************/
        MailerBad mailerBad = new MailerBad();
        mailerBad.from("dev1@gmail.com");
        mailerBad.to("dev2@gmail.com");
        mailerBad.subject("your code sucks");
        mailerBad.body("details");
        mailerBad.send();

        /************ ComposeMethod Pattern for Mailer **************/
        MailerOK mailerOk = new MailerOK();
        mailerOk.from("dev1@gmail.com")
                .to("dev2@gmail.com")
                .subject("your code sucks")
                .body("details")
                .send();

        /************ Lambda for Mailer **************/
        MailerLambda.send(mailerLambda ->
                mailerLambda.from("dev1@gmail.com")
                        .to("dev2@gmail.com")
                        .subject("your code sucks")
                        .body("details"));
    }

}

/************ BAD Code for Mailer **************/
class MailerBad {
    public void from(String address) { System.out.println("from"); }
    public void to(String address) { System.out.println("to"); }
    public void subject(String address) { System.out.println("subject"); }
    public void body(String address) { System.out.println("...body.."); }
    public void send() { System.out.println("sending..."); }
}

/************ Okay Code for Mailer **************/
class MailerOK {
    public MailerOK from(String address) { System.out.println("from"); return this; }
    public MailerOK to(String address) { System.out.println("to"); return this; }
    public MailerOK subject(String address) { System.out.println("subject"); return this; }
    public MailerOK body(String address) { System.out.println("...body.."); return this; }
    public MailerOK send() { System.out.println("sending..."); return this; }
}

/************ Lambda for Mailer **************/
class MailerLambda {
    private MailerLambda() {}
    public MailerLambda from(String address) { System.out.println("from"); return this; }
    public MailerLambda to(String address) { System.out.println("to"); return this; }
    public MailerLambda subject(String address) { System.out.println("subject"); return this; }
    public MailerLambda body(String address) { System.out.println("...body.."); return this; }
    public static void send(Consumer<MailerLambda> block) {
        MailerLambda mailer = new MailerLambda();
        block.accept(mailer);
        System.out.println("sending...");
    }
}
