package br.com.mthdev.stockSystem.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Output {
    private Inventory inventory;
    private Scanner sc;

    public Output(Inventory inventory) {
        this.inventory = inventory;
        this.sc = new Scanner(System.in);
    }

    public void productWithdrawn() {
        System.out.println("Digite o código do produto que será retirado: ");
        String code = sc.nextLine();

        Product product = inventory.findProductByCode(code);
        if (product == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println("Digite a quantidade a ser retirada: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        if (quantity > product.getProductsInventory()) {
            System.out.println("Quantidade maior do que o estoque disponível.");
            return;
        }

        product.setProductsInventory(product.getProductsInventory() - quantity);
        if (product.getProductsInventory() == 0) {
            inventory.removeProduct(product);
            System.out.println("O produto foi removido do estoque, pois a quantidade chegou a zero.");
        }

        System.out.println("Digite a data de retirada (no formato yyyy-MM-dd): ");
        String dateInput = sc.nextLine();
        LocalDate dateOfOutput;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dateOfOutput = LocalDate.parse(dateInput, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Usando a data atual.");
            dateOfOutput = LocalDate.now();
        }

        System.out.println("Produto retirado com sucesso!");
        System.out.println("Data de retirada: " + dateOfOutput);
    }
}
