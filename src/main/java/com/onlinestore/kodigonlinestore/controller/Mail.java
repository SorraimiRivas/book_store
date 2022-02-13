package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Model.Item;
import com.onlinestore.kodigonlinestore.Model.ShoppingHistory;

import java.util.Scanner;

public class Mail {
    public static void SendBillTo(ShoppingHistory item, Customer cos)throws Exception{
        Scanner sc = new Scanner(System.in);
        String Mail = cos.getEmail();
        StringBuilder bodyText = new StringBuilder();
        bodyText.append("\nThanks for your purchase!!\n");
        for(int x = 0;x<item.getItemOrder().size();x++) {
            bodyText.append("\nBook Title: ").append(item.getItemOrder().get(1).getIdItem().
                    getTitle().toUpperCase()).append("\n");
            bodyText.append("Quantity: ").append(item.getItemOrder().get(1).getQuantity()).append("\n");
            bodyText.append("Price: ").append(item.getItemOrder().get(1).getTotal()).append("\n");
        }
        MailSender.sendMail(Mail,bodyText.toString(), "Kodigo Online Book Store Bill");
    }
}