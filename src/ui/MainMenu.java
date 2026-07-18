package ui;

import service.RecordService;

import java.util.Scanner;

public class MainMenu {

  private Scanner scanner;

  private RecordService service;

  public MainMenu() {

    scanner = new Scanner(System.in);

    service = new RecordService();

  }

  public void start() {

    while (true) {

      System.out.println();

      System.out.println("======Vintage Vinyl Store======");

      System.out.println("1.Create Record");

      System.out.println("2.View Records");

      System.out.println("3.Exit");

      int choice = scanner.nextInt();

      switch (choice) {

        case 1:

          System.out.println(
              "Feature Coming Soon");

          break;

        case 2:

          service.showAllRecords();

          break;

        case 3:

          return;

        default:

          System.out.println(
              "Invalid Choice");

      }

    }

  }

}