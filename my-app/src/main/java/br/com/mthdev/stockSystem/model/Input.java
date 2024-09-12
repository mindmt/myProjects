package br.com.mthdev.stockSystem.model;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Input {
    private Product product;
    private Scanner sc;
    private Inventory inventory;

    public Input(Inventory inventory){
        this.inventory = inventory;
        this.sc = new Scanner(System.in);
        this.product = new Product("", "", 0.0, 0.0, 0);
        registerProduct();
    }

    public void registerProduct() {
        System.out.println("Digite o nome do produto: ");
        String name = sc.nextLine();
        System.out.println("Digite o código do produto: ");
        String code = sc.nextLine();
        System.out.println("Digite o preço de compra do produto: ");
        double purchasePrice = sc.nextDouble();
        System.out.println("Digite o preço de venda do produto: ");
        double sellingPrice = sc.nextDouble();
        System.out.println("Digite a quantidade no estoque: ");
        int productsInventory = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite a data de entrada do produto (no formato yyyy-MM-dd): ");
        String dateInput = sc.nextLine();

        LocalDate dateOfInput;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dateOfInput = LocalDate.parse(dateInput, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Usando a data atual.");
            dateOfInput = LocalDate.now();
        }

        product.setName(name);
        product.setCode(code);
        product.setPurchasePrice(purchasePrice);
        product.setSellingPrice(sellingPrice);
        product.setProductsInventory(productsInventory);

        inventory.addProduct(product);
        System.out.println("Produto adicionado com sucesso! ");
        System.out.println("Data de entrada: " + dateOfInput);
    }
    public Product getProduct() {
        return product;
    }


}
