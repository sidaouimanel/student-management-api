/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentsoapservice;

/**
 *
 * @author user
 */


import jakarta.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        String url = "http://localhost:8087/StudentSOAPService/StudentService";
        System.out.println("Publishing StudentService at " + url + "?wsdl");
        Endpoint.publish(url, new StudentService());
        System.out.println("Service is published and running...");
    }
}
