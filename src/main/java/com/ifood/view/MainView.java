package com.ifood.view;

import com.ifood.controller.*;
import com.ifood.model.*;

import java.util.*;

public class MainView {
    private Scanner scanner = new Scanner(System.in);

    private CustomerController customerController = new CustomerController();
    private DeliveryPersonController deliveryPersonController = new DeliveryPersonController();
    private RestaurantController restaurantController = new RestaurantController();
    private MenuItemController menuItemController = new MenuItemController();
    private OrderController orderController = new OrderController();

    public void start() {
        int option;
        do {
            System.out.println("\n===== MENU IFOOD =====");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Entregadores");
            System.out.println("3 - Gerenciar Restaurantes");
            System.out.println("4 - Gerenciar Itens de Menu");
            System.out.println("5 - Gerenciar Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> manageCustomers();
                case 2 -> manageDeliveryPeople();
                case 3 -> manageRestaurants();
                case 4 -> manageMenuItems();
                case 5 -> manageOrders();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (option != 0);
    }

    private void manageCustomers() {
        System.out.println("\n--- CLIENTES ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Nome: "); String name = scanner.nextLine();
                System.out.print("Endereço: "); String address = scanner.nextLine();
                customerController.addCustomer(id, name, address);
            }
            case 2 -> customerController.getAllCustomers().forEach(c -> System.out.println(c.getDetails()));
            case 3 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Novo Nome: "); String name = scanner.nextLine();
                System.out.print("Novo Endereço: "); String address = scanner.nextLine();
                customerController.updateCustomer(id, name, address);
            }
            case 4 -> {
                System.out.print("ID: "); int id = scanner.nextInt();
                customerController.removeCustomer(id);
            }
        }
    }

    private void manageDeliveryPeople() {
        System.out.println("\n--- ENTREGADORES ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Nome: "); String name = scanner.nextLine();
                System.out.print("Veículo: "); String vehicle = scanner.nextLine();
                deliveryPersonController.addDeliveryPerson(id, name, vehicle);
            }
            case 2 -> deliveryPersonController.getAllDeliveryPeople().forEach(d -> System.out.println(d.getDetails()));
            case 3 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Novo Nome: "); String name = scanner.nextLine();
                System.out.print("Novo Veículo: "); String vehicle = scanner.nextLine();
                deliveryPersonController.updateDeliveryPerson(id, name, vehicle);
            }
            case 4 -> {
                System.out.print("ID: "); int id = scanner.nextInt();
                deliveryPersonController.removeDeliveryPerson(id);
            }
        }
    }

    private void manageRestaurants() {
        System.out.println("\n--- RESTAURANTES ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Nome: "); String name = scanner.nextLine();
                restaurantController.addRestaurant(id, name);
            }
            case 2 -> restaurantController.getAllRestaurants().forEach(r -> System.out.println(r));
            case 3 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Novo Nome: "); String name = scanner.nextLine();
                restaurantController.updateRestaurant(id, name);
            }
            case 4 -> {
                System.out.print("ID: "); int id = scanner.nextInt();
                restaurantController.removeRestaurant(id);
            }
        }
    }

    private void manageMenuItems() {
        System.out.println("\n--- ITENS DE MENU ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Nome: "); String name = scanner.nextLine();
                System.out.print("Preço: "); double price = scanner.nextDouble();
                menuItemController.addMenuItem(id, name, price);
            }
            case 2 -> menuItemController.getAllMenuItems().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Novo Nome: "); String name = scanner.nextLine();
                System.out.print("Novo Preço: "); double price = scanner.nextDouble();
                menuItemController.updateMenuItem(id, name, price);
            }
            case 4 -> {
                System.out.print("ID: "); int id = scanner.nextInt();
                menuItemController.removeMenuItem(id);
            }
        }
    }

    private void manageOrders() {
        System.out.println("\n--- PEDIDOS ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("ID Pedido: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("ID Cliente: "); int cid = scanner.nextInt(); scanner.nextLine();
                System.out.print("ID Entregador: "); int did = scanner.nextInt(); scanner.nextLine();
                System.out.print("ID Restaurante: "); int rid = scanner.nextInt(); scanner.nextLine();

                Customer customer = customerController.findCustomerById(cid);
                DeliveryPerson deliveryPerson = deliveryPersonController.findDeliveryPersonById(did);
                Restaurant restaurant = restaurantController.findRestaurantById(rid);

                List<MenuItem> items = new ArrayList<>();
                System.out.print("Quantos itens? "); int qtd = scanner.nextInt(); scanner.nextLine();
                for (int i = 0; i < qtd; i++) {
                    System.out.print("ID Item: "); int iid = scanner.nextInt(); scanner.nextLine();
                    MenuItem item = menuItemController.findMenuItemById(iid);
                    if (item != null) items.add(item);
                }

                orderController.addOrder(id, customer, deliveryPerson, restaurant, items);
            }
            case 2 -> orderController.getAllOrders().forEach(System.out::println);
            case 3 -> System.out.println("Atualização de pedido funciona igual ao cadastro (mesmo ID).");
            case 4 -> {
                System.out.print("ID Pedido: "); int id = scanner.nextInt();
                orderController.removeOrder(id);
            }
        }
    }
}
