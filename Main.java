package machine;
import java.util.*;

public class CoffeeMachine {
  Scanner scanner = new Scanner(System.in);
    int water = 400;
    int milk = 540;
    int coffee = 120;
    int cups = 9;
    int money = 550;

    void showAction() {
      System.out.println("Write action (buy, fill, take, remaining, exit):");
     String action = scanner.next();
     System.out.println();
      if(action.equals("exit")){
        return ;
      }
      
        switch(action){
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                showMenu();
                break;
            case "exit":
                return;
                
          }     
    }

      void showMenu() {
      System.out.println("The coffee machine has:");
      System.out.println(water+" of water");
      System.out.println(milk+" of milk");
      System.out.println(coffee+" of coffee beans");
      System.out.println(cups+" of disposable cups");
      System.out.println(money+" of money");
      System.out.println();
      showAction();
    }

    String quantityEsp(){
      if (water < 250) {
        return "water";
      }
      if (coffee < 16) {
        return "coffee";
      }
    
      if(cups < 1) {
        return "cups";
      }
      return "";
    }

    String quantityLat(){
      if (water < 350) {
        return "water";
      }
      if (coffee < 20) {
        return "coffee";
      }

       if (milk < 75) {
        return "coffee";
      }
    
      if(cups < 1) {
        return "cups";
      }
      return "";
    }

    String quantityCap(){
      if (water < 200) {
        return "water";
      }
      if (coffee < 12) {
        return "coffee";
      }

      if (milk < 100) {
        return "coffee";
      }
    
      if(cups < 1) {
        return "cups";
      }
      return "";
    }

      void buy() {
       System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
       String numS = scanner.next();
        System.out.println();
       switch(numS) {
         case "1":
          if(water >= 0 && coffee > 16 && cups >= 1) { 
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
             water -= 250;
          coffee -= 16;
          money += 4;
          cups--;
          }else {
            System.out.println("Sorry, not enough "+quantityEsp()+"!");
            System.out.println();
          }
         
          showAction();
          break;

        case "2":
         if(water >= 350 && milk >= 75 && coffee >= 20 && cups >= 1) {  
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            water -= 350;
          milk -= 75;
          coffee -= 20;
          money += 7;
          cups--;
          }else {
            System.out.println("Sorry, not enough "+quantityLat()+"!");
            System.out.println();
          }
          
          showAction();
          break;

        case "3":
          if(water >= 200 && milk >= 100 && coffee >= 12 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            water -= 200;
          milk -= 100;
          coffee -= 12;
          money += 6;
          cups--;

          }else {
            System.out.println("Sorry, not enough "+quantityCap()+"!");
            System.out.println();
          }
          showAction();
          break;

        case "back":
          showAction();
          break;
       }
     }

     void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt(); 

        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();

        showAction();
     }

     void take() {
        System.out.println("I gave you $"+money);
        money = 0;
        System.out.println();
        showAction();
     }
     
      public static void main(String[] args) {
        CoffeeMachine obj = new CoffeeMachine();
        obj.showAction();
      }
  
  }


