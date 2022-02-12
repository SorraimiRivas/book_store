package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Item;

import java.util.Scanner;

public class Mail {
    public static void SendBillTo(Item item)throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Mail to send the Bill");
        String Mail = sc.nextLine();
        StringBuilder bodyText = new StringBuilder();

        bodyText.append("Book Title: ").append(item.getTitle().toUpperCase()).append("\n");
        bodyText.append("Price: ").append(item.getItemPrice()).append("\n");

        MailSender.sendMail(Mail,bodyText.toString(), "Kodigo Online Book Store Bill");
    }
}