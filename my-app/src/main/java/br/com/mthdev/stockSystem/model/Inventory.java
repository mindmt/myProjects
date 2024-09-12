package br.com.mthdev.stockSystem.model;

import java.util.Scanner;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;
    private Scanner sc = new Scanner(System.in);

    public Inventory() {
        products = new ArrayList<>();
        products.add(new Product("Arroz Branco 5kg", "ARB5KG", 20.00, 25.00, 100));
        products.add(new Product("Feijão Carioca 1kg", "FEC1KG", 8.00, 12.00, 150));
        products.add(new Product("Óleo de Soja 900ml", "OLS900", 6.00, 8.00, 200));
        products.add(new Product("Macarrão Espaguete 500g", "MAC500", 3.50, 5.00, 120));
        products.add(new Product("Leite Integral 1L", "LEI1L", 4.50, 6.00, 180));
        products.add(new Product("Açúcar Cristal 2kg", "ACC2KG", 5.00, 7.00, 130));
        products.add(new Product("Café Torrado e Moído 500g", "CAF500", 10.00, 15.00, 90));
        products.add(new Product("Farinha de Trigo 1kg", "FTR1KG", 4.00, 6.00, 110));
        products.add(new Product("Biscoito Cream Cracker 400g", "BCC400", 3.00, 4.50, 140));
        products.add(new Product("Detergente Líquido 500ml", "DET500", 2.00, 3.50, 160));
    }

    public void showProductsAdministrator() {
        for (Product product : products) {
            System.out.println("Nome: " + product.getName());
            System.out.println("Código: " + product.getCode());
            System.out.println("Preço de compra: " + product.getPurchasePrice());
            System.out.println("Preço de venda: " + product.getSellingPrice());
            System.out.println("Produtos no estoque: " + product.getProductsInventory());
            System.out.println("------------------------------");
        }
    }

    public void showSituationStaff() {
        for (Product product : products) {
            if (product.getProductsInventory() <= 50) {
                System.out.println("O produto " + product.getName() + " está acabando, encomende mais");
            }
        }
    }

    public void showProductsCostumer() {
        for (Product product : products) {
            System.out.println("Nome: " + product.getName());
            System.out.println("Código: " + product.getCode());
            System.out.println("Preço: " + product.getSellingPrice());
            System.out.println("------------------------------");
        }
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public Product findProductByCode(String code) {
        for (Product product : products) {
            if (product.getCode().equalsIgnoreCase(code)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void editProducts(String code) {
        Product product = findProductByCode(code);
        if (product == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        while (true) {
            System.out.println("Qual item você deseja editar?");
            System.out.println("[1] Nome [2] Código [3] Preço de compra [4] Preço de Venda [5] Quantidade em estoque [6] Cancelar");
            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1:
                    System.out.println("Digite o novo nome: ");
                    product.setName(sc.nextLine());
                    System.out.println("Nome alterado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o novo código: ");
                    product.setCode(sc.nextLine());
                    System.out.println("Código alterado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o novo preço de compra: ");
                    product.setPurchasePrice(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Preço de compra alterado com sucesso!");
                    break;
                case 4:
                    System.out.println("Digite o novo preço de venda: ");
                    product.setSellingPrice(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Preço de venda alterado com sucesso!");
                    break;
                case 5:
                    System.out.println("Digite a nova quantidade em estoque: ");
                    product.setProductsInventory(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Quantidade em estoque alterada com sucesso!");
                    break;
                case 6:
                    System.out.println("Saindo do modo edição...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}