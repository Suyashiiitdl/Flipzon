import java.util.*;
import java.lang.Math;

public class Main {


    public static void main(String[] args) {
       try{
           ArrayList<Customer> cust_add = new ArrayList<Customer>();
           ArrayList<Product> products = new ArrayList<Product>();
           ArrayList<Deal> deals_list = new ArrayList<Deal>();
           int n1;
           Scanner scan = new Scanner(System.in);
           while (true){
               System.out.println("WELCOME TO FLIPZON");
               String a1 = "1) Enter as Admin\n" +
                           "2) Explore the Product Catalog\n" +
                           "3) Show Available Deals\n" +
                           "4) Enter as Customer\n" +
                           "5) Exit the Application";

               System.out.println(a1);
               n1 = scan.nextInt();

               if (n1 == 5) {
                   System.out.println("Thanks for using our Application");
                   break;
               }
               else if (n1 == 1){
                   AdminMode(products,deals_list);
               }
               else if (n1 == 4){
                   CustomerMode(cust_add,products,deals_list);
               }
               else if (n1 == 2){
                   ProductCat(products);
               }
               else if (n1 == 3){
                   if (deals_list.size() == 0){
                       System.out.println("No Deals Available");
                   }
                   for (int j = 0; j < deals_list.size(); j++){
                       System.out.printf("Deal Id = %d) \n",j + 1);
                       System.out.printf("First Product = %s\n", deals_list.get(j).p1.getName());
                       System.out.printf("Second Product = %s\n", deals_list.get(j).p2.getName());
                       System.out.printf("Prices Elite = %d, Prime = %d, Normal = %d\n", deals_list.get(j).getElite_deal(), deals_list.get(j).getPrime_deal(), deals_list.get(j).getNormal_deal());
                       System.out.printf("Quantity = %d\n", deals_list.get(j).getQuantity());
                   }

               }
           }
       }
       catch (Exception e){
           System.out.println("Ops! Something went wrong!!");
       }
    }

    public static void AdminMode(ArrayList<Product> product_list,ArrayList<Deal> deal_list){
        Scanner scan = new Scanner(System.in);
        System.out.println("Dear Admin,");
        System.out.println("Please enter your Username :");
        String n1;
        String n3;
        int n2;
        n1 = scan.nextLine();

        System.out.println("Password :");
        n3 = scan.nextLine();
        System.out.println("***********");

        System.out.printf("Welcome %s\n",n1);

        while (true) {
            String a2 = "Please choose any one of the following actions:\n" +
                        "1) Add category\n" +
                        "2) Delete category\n" +
                        "3) Add Product\n" +
                        "4) Delete Product\n" +
                        "5) Set Discount on Product\n" +
                        "6) Add giveaway deal\n" +
                        "7) Back";
            System.out.println(a2);

            n2 = scan.nextInt();

            if (n2 == 7){
                return;
            }

            else if (n2 ==8){
                for( int i = 0; i < product_list.size(); i++){
                    System.out.println(product_list.get(i).getName());
                }
            }
            else if (n2 == 1){
                System.out.println("Add category Id:");
                int cat = scan.nextInt();

                System.out.println("Add name of the category :");
                String cat_name = scan.next();
                scan.nextLine();
                int check3 = 0;
                for (int i = 0; i < product_list.size(); i++){
                    if (product_list.get(i).getCategory_id() == cat){
                        check3 = 1;
                        break;
                    }
                }
                if (check3 == 1){
                    System.out.println("Category already present!!");
                    System.out.println("Enter a new Category");
                    continue;
                }
                System.out.println("Product Name :");
                String prod_name = scan.next();
                scan.nextLine();

                System.out.println("Product Id :");
                float prod_id = scan.nextFloat();

                System.out.println("Price (in ₹)");
                int price = scan.nextInt();

                System.out.println("Other details");
                String details = scan.next();
                scan.nextLine();
                System.out.println("Quantity");
                int quantity = scan.nextInt();

                Product p1 = new Product(cat,cat_name,prod_name,prod_id,price,details,quantity);
                product_list.add(p1);
                System.out.println("Category added Successfully!!!");
            }

            else if (n2 == 3){
                System.out.println("Enter category Id:");
                int cat = scan.nextInt();
                String cat_name = "";
//                System.out.println("Add name of the category :");
//                String cat_name = scan.next();
//                scan.nextLine();
                for(int j = 0; j < product_list.size(); j++){
                    if(product_list.get(j).getCategory_id() == cat){
                        cat_name = product_list.get(j).getCategory();
                    }

                }
                int check1 = 0;
                for (int i = 0; i < product_list.size(); i++) {
                    if (product_list.get(i).getCategory_id() == cat) {
                        check1 = 1;
                        break;
                    }
                }
                if (check1 == 0){
                    System.out.println("Category not present");
                    continue;}

                System.out.println("Product Name :");
                String prod_name = scan.next();
                scan.nextLine();

                System.out.println("Product Id :");
                float prod_id = scan.nextFloat();
                int check2 = 0;
                for (int i = 0; i < product_list.size(); i++) {
                    if (product_list.get(i).getProduct_id() == prod_id) {
                        check2 = 1;
                        break;
                    }
                }
                if (check2 == 1){
                    System.out.println("Product Id already present");
                    continue;
                }

                System.out.println("Price (in ₹)");
                int price = scan.nextInt();

                System.out.println("Other details");
                String details = scan.next();
                scan.nextLine();
                System.out.println("Quantity");
                int quantity = scan.nextInt();

                Product p1 = new Product(cat,cat_name,prod_name,prod_id,price,details,quantity);
                product_list.add(p1);

                System.out.println("Product added Successfully!!");
            }

            else if (n2 == 4){
                System.out.println("Category Name :");
                String cat_naam = scan.next();
                scan.nextLine();

                System.out.println("Enter Product Id to be deleted :");
                float produ_id = scan.nextFloat();

                for (int i = 0; i < product_list.size();i++){
                    if (product_list.get(i).getProduct_id() == produ_id && product_list.get(i).getCategory().compareTo(cat_naam) == 0){
                        product_list.remove(i);
                    }
                }
                System.out.println("Product Deleted Successfully!!");
            }

            else if (n2 == 2){
                System.out.println("Enter Category Name to be deleted:");
                String cat_naam = scan.next();
                scan.nextLine();

                System.out.println("Enter Category Id to be deleted :");
                int cate_id = scan.nextInt();

                product_list.removeIf(p->(p.getCategory_id() == cate_id && p.getCategory().compareTo(cat_naam) == 0) );
//                for (int i = 0; i < product_list.size();i++){
//                    if (product_list.get(i).category_id == cate_id && product_list.get(i).category.compareTo(cat_naam) == 0){
//                        product_list.remove(i);
//                    }
//                }
                System.out.printf("Category :%s Deleted Successfully!!\n",cat_naam);
            }

            else if(n2 == 5){
                System.out.println("Dear Admin give the Product ID you want to add discount for");
                System.out.println("Enter the Product ID :");

                float prod_id = scan.nextFloat();

                System.out.println("Enter discount for Elite(in % terms) :");
                int elite = scan.nextInt();
                System.out.println("Enter discount for Prime(in % terms) :");
                int prime = scan.nextInt();
                System.out.println("Enter discount for Normal(in % terms) :");
                int normal = scan.nextInt();

                for (int j = 0; j < product_list.size(); j++){
                    if (product_list.get(j).getProduct_id() == prod_id ){
                        product_list.get(j).setElite_dis(elite);
                        product_list.get(j).setPrime_dis(prime);
                        product_list.get(j).setNormal_dis(normal);
                        System.out.printf("Discount on the product(id :%f) updated\n",prod_id);
                        break;
                    }
                }
            }
            else if(n2 == 6){
                System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
                System.out.println("Enter the first Product ID :");
                float first_id = scan.nextFloat();
                System.out.println("Enter the second Product ID :");
                float second_id = scan.nextFloat();
                System.out.println("Enter the combined price(Should be less than their combined price ");
                System.out.println("Price for Elite (in ₹):");
                int elite_price = scan.nextInt();
                System.out.println("Price for Prime (in ₹):");
                int prime_price = scan.nextInt();
                System.out.println("Price for Normal (in ₹):");
                int normal_price = scan.nextInt();
                System.out.println("Quantity :");
                int quantity = scan.nextInt();
                int index1 = -1;
                int index2 = -1;

                for (int j = 0; j < product_list.size() ; j++){
                    if (product_list.get(j).getProduct_id() == first_id){
                        index1 = j;
                    }
                    if (product_list.get(j).getProduct_id() == second_id){
                        index2 = j;
                    }
                }
                Deal d1 = new Deal(product_list.get(index1),product_list.get(index2),elite_price,prime_price,normal_price,quantity);
                deal_list.add(d1);
                System.out.println("Deal Added Successfully!!");
            }
        }
    }
    public static void CustomerMode(ArrayList<Customer> cust_list,ArrayList<Product> prod_list,ArrayList<Deal> deal_list){
        Scanner scan = new Scanner(System.in);
        while (true) {
            int n1;
            String a1 = "1) Sign up\n" +
                    "2) Log in\n" +
                    "3) Back";
            System.out.println(a1);

            n1 = scan.nextInt();

            if (n1 == 3){
                return;
            }

            else if (n1 == 1){
                System.out.println("Enter Name :");
                String a3 = scan.next();
                scan.nextLine();

                System.out.println("Enter Password :");
                String a4 = scan.next();
                scan.nextLine();

                Customer c1 = new Customer(a3,a4);
                cust_list.add(c1);
                System.out.println("customer successfully registered!!");
            }

            else if (n1 == 2){
                System.out.println("Enter Name :");
                String a3 = scan.next();
                scan.nextLine();

                System.out.println("Enter Password :");
                String a4 = scan.next();
                scan.nextLine();
                Customer c1 = new Customer(a3,a4);
                boolean a5 = false;
                for (int i = 0; i < cust_list.size(); i++){
                    if (cust_list.get(i).getName().compareTo(a3) == 0 && cust_list.get(i).getPassword().compareTo(a4) == 0){
                        a5 = true;
                        break;
                    }
                }

                if (a5 == true){
                    System.out.printf("Welcome %s\n",a3);
                    while(true) {

                        String a2 = "1) browse products\n" +
                                    "2) browse deals\n" +
                                    "3) add a product to cart\n" +
                                    "4) add products in deal to cart\n" +
                                    "5) view coupons\n" +
                                    "6) check account balance\n" +
                                    "7) view cart\n" +
                                    "8) empty cart\n" +
                                    "9) checkout cart\n" +
                                    "10) upgrade customer status\n" +
                                    "11) Add amount to wallet\n" +
                                    "12) back";
                        System.out.println(a2);
                        int n4  = scan.nextInt();
                        if (n4 == 12){
                            break;
                        }
                        else if (n4 == 1){
                            for (int j = 0; j < prod_list.size(); j++){
                                System.out.printf("%d)\n",j + 1);
                                System.out.printf("Category     :%s\n", prod_list.get(j).getCategory());
                                System.out.printf("Product Name :%s\n", prod_list.get(j).getName());
                                System.out.printf("Product Id   :%f\n", prod_list.get(j).getProduct_id());
                                System.out.printf("Price (in ₹) :%d\n", prod_list.get(j).getPrice());
                                System.out.printf("Details      :%s\n", prod_list.get(j).getOther_detail());
                                System.out.printf("Quantity     :%d\n", prod_list.get(j).getQuantity());
                                System.out.print("\n");
                            }
                        }

                        else if (n4 == 2){

                            for (int j = 0; j < deal_list.size(); j++){
                                System.out.printf("Deal Id  = %d) \n",j + 1);
                                System.out.printf("First Product = %s\n", deal_list.get(j).p1.getName());
                                System.out.printf("Second Product = %s\n", deal_list.get(j).p2.getName());
                                System.out.printf("Prices Elite = %d, Prime = %d, Normal = %d\n", deal_list.get(j).getElite_deal(), deal_list.get(j).getPrime_deal(), deal_list.get(j).getNormal_deal());
                                System.out.printf("Quantity = %d\n", deal_list.get(j).getQuantity());
                            }
                        }
                        else if(n4 == 3){
                            int prod_index = -1;
                            System.out.println("Enter product ID :");
                            float prodt_id = scan.nextFloat();

                            System.out.println("Enter quantity :");
                            int quanty = scan.nextInt();

                            for (int j = 0;j< prod_list.size(); j++){
                                if (prod_list.get(j).getProduct_id() == prodt_id){
                                    prod_index = j;
                                }
                            }
//                            Product p2 =  new Product(prod_list.get(prod_index).product_id,);

                            for (int j = 0; j < cust_list.size(); j++){
                                if (cust_list.get(j).getName().compareTo(a3) == 0){
                                    if (prod_list.get(prod_index).getQuantity() < quanty){
                                        System.out.println("This much Quantity is not available !");
                                        break;
                                    }
                                    cust_list.get(j).cart.add(prod_list.get(prod_index));
                                    int cart_index = cust_list.get(j).cart.size();
                                    cust_list.get(j).cart.get(cart_index - 1).setBuy_quantity(quanty);
                                    prod_list.get(prod_index).setBuy_quantity(quanty);
//                                    prod_list.get(prod_index).quantity = prod_list.get(prod_index).quantity - prod_list.get(prod_index).buy_quantity;
                                    System.out.println("Product added to the cart!");
                                    break;
                                }
                            }
                        }

                        else if (n4 == 4){
                            System.out.println("Enter the Deal Id you want to add to the cart");
                            System.out.println("Deal Id :");
                            int deal_id = scan.nextInt();
                            int deal_index = -1;


                            for (int j = 0; j < cust_list.size(); j++){
                                if (cust_list.get(j).getName().compareTo(a3) == 0){
                                    cust_list.get(j).deal_cart.add(deal_list.get(deal_id - 1));
                                    System.out.println("Deal added to the cart!!");
                                    break;
                                }
                                else {
                                    System.out.println("Deal with this Id not present!");
                                }
//                                else{
//                                    for (int k = 0;k<cust_list.get(j).coupons.size(); k++){
//                                        System.out.printf("%d) ",k + 1);
//                                        System.out.printf("%d%\n",cust_list.get(j).coupons.get(k));
//                                    }
//                                }
                            }
                        }

                        else if(n4 == 5){
                            for (int j = 0; j < cust_list.size(); j++){
                                if (cust_list.get(j).getName().compareTo(a3) == 0){
                                    if (cust_list.get(j).coupons.size() == 0){
                                        System.out.println("No Coupons Available !!");
                                        break;
                                    }
                                    else{
                                        System.out.println("Available Coupons :-");
                                        for (int k = 0; k < cust_list.get(j).coupons.size(); k ++){
                                            System.out.printf("Coupon with %d(in percentage) discount\n",cust_list.get(j).coupons.get(k));
                                        }
                                    }
                                }
                            }
                        }

                        else if (n4 == 6){
                            for (int j = 0; j < cust_list.size(); j++){
                                if (cust_list.get(j).getName().compareTo(a3) == 0){
                                    System.out.printf("Current Account Balance (in ₹) = %f\n", cust_list.get(j).getBalance());
                                    break;
                                }
                            }
                        }
                        else if (n4 == 7){
                            System.out.println("Cart contains following items :-");
                            for (int j = 0; j < cust_list.size(); j++){
                                if (cust_list.get(j).getName().compareTo(a3) == 0){
                                    if (cust_list.get(j).cart.size() == 0 && cust_list.get(j).deal_cart.size() == 0){
                                        System.out.println("Cart is Empty!");
                                        break;
                                    }
                                    for (int k = 0; k < cust_list.get(j).cart.size(); k++){
                                        System.out.printf("%d)\n",k + 1);
                                        System.out.printf("Category     :%s\n", cust_list.get(j).cart.get(k).getCategory());
                                        System.out.printf("Product Name :%s\n", cust_list.get(j).cart.get(k).getName());
                                        System.out.printf("Product Id   :%f\n", cust_list.get(j).cart.get(k).getProduct_id());
                                        System.out.printf("Price (in ₹) :%d\n", cust_list.get(j).cart.get(k).getPrice());
                                        System.out.printf("Details      :%s\n", cust_list.get(j).cart.get(k).getOther_detail());
                                        System.out.printf("Quantity     :%d\n", cust_list.get(j).cart.get(k).getBuy_quantity());
                                        System.out.print("\n");
                                    }
                                    for (int k = 0; k < cust_list.get(j).deal_cart.size(); k++){
                                        System.out.printf("Deal %d) :-\n, k+1");
                                        System.out.printf("First Product = %s\n", cust_list.get(j).deal_cart.get(k).p1.getName());
                                        System.out.printf("Second Product = %s\n", cust_list.get(j).deal_cart.get(k).p2.getName());
                                        if (cust_list.get(j).getStatus().compareTo("ELITE") == 0){
                                            System.out.printf("Price (for Elite) = %d\n", cust_list.get(j).deal_cart.get(k).getElite_deal());
                                        }
                                        else if (cust_list.get(j).getStatus().compareTo("PRIME") == 0){
                                            System.out.printf("Price (for Prime) = %d\n", cust_list.get(j).deal_cart.get(k).getPrime_deal());
                                        }
                                        else if (cust_list.get(j).getStatus().compareTo("NORMAL") == 0){
                                            System.out.printf("Price (for Normal) = %d\n", cust_list.get(j).deal_cart.get(k).getNormal_deal());
                                        }
                                        System.out.printf("Quantity = %d\n", cust_list.get(j).deal_cart.get(k).getQuantity());
                                    }
                                }
                            }
                        }
                        else if (n4 == 8){
                            for (int j = 0; j < cust_list.size(); j++){
                                if (cust_list.get(j).getName().compareTo(a3) == 0){
                                    cust_list.get(j).cart.clear();
                                    System.out.println("Cart Emptied!!");
                                    break;
                                }
                                else {
                                    System.out.println("Cart already Empty!!");
                                }
                            }
                        }

                        else if (n4 == 9){
                            float delivery_charge = 0;
                            int max_coupon = 0;
                            int cust_discount = 0;
                            int prod_discount = 0;
                            float total_price = 0;

                            for (int j = 0; j < cust_list.size(); j ++){
                                if (cust_list.get(j).getName().compareTo(a3) == 0){
                                    if (cust_list.get(j).cart.size() == 0 && cust_list.get(j).deal_cart.size() == 0){
                                        System.out.println("Cart is Empty !!");
                                        break;
                                    }
                                    for (int k = 0; k < cust_list.get(j).cart.size(); k++){
                                        System.out.printf("%d)\n",k + 1);
                                        System.out.printf("Category     :%s\n", cust_list.get(j).cart.get(k).getCategory());
                                        System.out.printf("Product Name :%s\n", cust_list.get(j).cart.get(k).getName());
                                        System.out.printf("Product Id   :%f\n", cust_list.get(j).cart.get(k).getProduct_id());
                                        System.out.printf("Price (in ₹) :%d\n", cust_list.get(j).cart.get(k).getPrice());
                                        System.out.printf("Details      :%s\n", cust_list.get(j).cart.get(k).getOther_detail());
                                        System.out.printf("Quantity     :%d\n", cust_list.get(j).cart.get(k).getBuy_quantity());
                                        System.out.print("\n");
                                    }
                                    for (int k = 0; k < cust_list.get(j).deal_cart.size(); k++){
                                        System.out.printf("Deal %d) :-\n", k+1);
                                        System.out.printf("First Product = %s\n", cust_list.get(j).deal_cart.get(k).p1.getName());
                                        System.out.printf("Second Product = %s\n", cust_list.get(j).deal_cart.get(k).p2.getName());
                                        if (cust_list.get(j).getStatus().compareTo("ELITE") == 0){
                                            System.out.printf("Price (for Elite) = %d\n", cust_list.get(j).deal_cart.get(k).getElite_deal());
                                        }
                                        else if (cust_list.get(j).getStatus().compareTo("PRIME") == 0){
                                            System.out.printf("Price (for Prime) = %d\n", cust_list.get(j).deal_cart.get(k).getPrime_deal());
                                        }
                                        else if (cust_list.get(j).getStatus().compareTo("NORMAL") == 0){
                                            System.out.printf("Price (for Normal) = %d\n", cust_list.get(j).deal_cart.get(k).getNormal_deal());
                                        }
                                        System.out.printf("Quantity = %d\n", cust_list.get(j).deal_cart.get(k).getQuantity());
                                    }

                                    if (cust_list.get(j).coupons.size() != 0){
                                        max_coupon = cust_list.get(j).coupons.get(0);
                                        for (int k = 0; k < cust_list.get(j).coupons.size(); k++){
                                            if (cust_list.get(j).coupons.get(k) > max_coupon){
                                                max_coupon = cust_list.get(j).coupons.get(k);
                                            }
                                        }
                                    }
                                    if (cust_list.get(j).getStatus().compareTo("ELITE") == 0){
                                        cust_discount = 10;
                                    }
                                    else if (cust_list.get(j).getStatus().compareTo("PRIME") == 0){
                                        cust_discount = 5;
                                    }
                                    else if (cust_list.get(j).getStatus().compareTo("NORMAL") == 0){
                                        cust_discount = 0;
                                    }
                                    if (cust_list.get(j).getStatus().compareTo("ELITE") == 0){
                                        for (int k = 0; k < cust_list.get(j).cart.size(); k++){
                                            float final_dis = max(cust_discount, max_coupon, cust_list.get(j).cart.get(k).getElite_dis());
                                            total_price += cust_list.get(j).cart.get(k).getBuy_quantity() *(cust_list.get(j).cart.get(k).getPrice() - ((cust_list.get(j).cart.get(k).getPrice())*final_dis*0.01));
                                            for (int y = 0; y < prod_list.size();y++){
                                                if (prod_list.get(y).getProduct_id() == cust_list.get(j).cart.get(k).getProduct_id()){
                                                    prod_list.get(y).setQuantity(prod_list.get(y).getQuantity() - cust_list.get(j).cart.get(k).getBuy_quantity());
                                                }
                                            }
                                        }
                                        for(int k = 0; k < cust_list.get(j).deal_cart.size(); k++){
                                            total_price += cust_list.get(j).deal_cart.get(k).getBuy_quantity() *(cust_list.get(j).deal_cart.get(k).getElite_deal());
                                            for (int y = 0; y < deal_list.size();y++){
                                                if (deal_list.get(y).p1.getProduct_id() == cust_list.get(j).deal_cart.get(k).p1.getProduct_id() && deal_list.get(y).p2.getProduct_id() == cust_list.get(j).deal_cart.get(k).p2.getProduct_id()){
                                                    deal_list.get(y).setQuantity(deal_list.get(y).getQuantity() - cust_list.get(j).deal_cart.get(k).getBuy_quantity());
                                                }
                                            }
                                        }
                                        delivery_charge = 100;
                                        System.out.println("Delivery Charge = ₹100/-");
                                        System.out.printf("Total Products Cost = ₹%f/-\n",total_price);
                                        System.out.printf("Grand Total = ₹%f\n",total_price + delivery_charge);
                                        System.out.println("Your Ordered will be delivered within 2 days");
                                        cust_list.get(j).setBalance(cust_list.get(j).getBalance() - (total_price + delivery_charge));
                                        cust_list.get(j).cart.clear();
                                        cust_list.get(j).deal_cart.clear();
                                        if (total_price > 5000){
                                            System.out.println("Congratulation! You earned 4 Coupons!");
                                            for (int x = 0; x < 4; x++) {
                                                int coup1 = (int) (Math.random() * 15) + 1;
                                                cust_list.get(j).coupons.add(coup1);
                                            }
                                        }
                                    }
                                    else if (cust_list.get(j).getStatus().compareTo("PRIME") == 0){
                                        for (int k = 0; k < cust_list.get(j).cart.size(); k++) {
                                            float final_dis = max(cust_discount, max_coupon, cust_list.get(j).cart.get(k).getPrime_dis());
                                            total_price += cust_list.get(j).cart.get(k).getBuy_quantity() *(cust_list.get(j).cart.get(k).getPrice() - ((cust_list.get(j).cart.get(k).getPrice())*final_dis*0.01));
                                            for (int y = 0; y < prod_list.size();y++){
                                                if (prod_list.get(y).getProduct_id() == cust_list.get(j).cart.get(k).getProduct_id()){
                                                    prod_list.get(y).setQuantity(prod_list.get(y).getQuantity() - cust_list.get(j).cart.get(k).getBuy_quantity());
                                                }
                                            }
                                        }
                                        for(int k = 0; k < cust_list.get(j).deal_cart.size(); k++){
                                            total_price += cust_list.get(j).deal_cart.get(k).getBuy_quantity() *(cust_list.get(j).deal_cart.get(k).getPrime_deal());
                                            for (int y = 0; y < deal_list.size();y++){
                                                if (deal_list.get(y).p1.getProduct_id() == cust_list.get(j).deal_cart.get(k).p1.getProduct_id() && deal_list.get(y).p2.getProduct_id() == cust_list.get(j).deal_cart.get(k).p2.getProduct_id()){
                                                    deal_list.get(y).setQuantity(deal_list.get(y).getQuantity() - cust_list.get(j).deal_cart.get(k).getBuy_quantity());
                                                }
                                            }
                                        }

                                        delivery_charge = (float) (100 + (total_price * 0.02));
                                        System.out.printf("Delivery Charge = ₹%f/-\n",delivery_charge);
                                        System.out.printf("Total Products Cost = ₹%f/-\n",total_price);
                                        System.out.printf("Grand Total = ₹%f\n",total_price + delivery_charge);
                                        System.out.println("Your Ordered will be delivered within 3-6 days");
                                        cust_list.get(j).setBalance(cust_list.get(j).getBalance() - (total_price + delivery_charge));
                                        cust_list.get(j).cart.clear();
                                        cust_list.get(j).deal_cart.clear();
                                        if (total_price > 5000){
                                            System.out.println("Congratulation! You have earned 2 Coupons!");
                                            for (int x = 0; x < 2; x++) {
                                                int coup1 = (int) (Math.random() * 15) + 1;
                                                cust_list.get(j).coupons.add(coup1);
                                            }
                                        }

                                    }
                                    else if (cust_list.get(j).getStatus().compareTo("NORMAL") == 0){
                                        for (int k = 0; k < cust_list.get(j).cart.size(); k++) {
                                            float final_dis = max(cust_discount, max_coupon, cust_list.get(j).cart.get(k).getNormal_dis());
                                            total_price += cust_list.get(j).cart.get(k).getBuy_quantity() *(cust_list.get(j).cart.get(k).getPrice() - ((cust_list.get(j).cart.get(k).getPrice())*final_dis*0.01));
                                            for (int y = 0; y < prod_list.size();y++){
                                                if (prod_list.get(y).getProduct_id() == cust_list.get(j).cart.get(k).getProduct_id()){
//                                                    System.out.println("product original quantity = "+prod_list.get(y).quantity);
//                                                    System.out.println("quantity buying = "+cust_list.get(j).cart.get(k).quantity);
                                                    prod_list.get(y).setQuantity(prod_list.get(y).getQuantity() - cust_list.get(j).cart.get(k).getBuy_quantity());
                                                }
                                            }
                                        }
                                        for(int k = 0; k < cust_list.get(j).deal_cart.size(); k++){
                                            total_price += cust_list.get(j).deal_cart.get(k).getBuy_quantity() *(cust_list.get(j).deal_cart.get(k).getNormal_deal());
                                            for (int y = 0; y < deal_list.size();y++){
                                                if (deal_list.get(y).p1.getProduct_id() == cust_list.get(j).deal_cart.get(k).p1.getProduct_id() && deal_list.get(y).p2.getProduct_id() == cust_list.get(j).deal_cart.get(k).p2.getProduct_id()){
                                                    deal_list.get(y).setQuantity(deal_list.get(y).getQuantity() - cust_list.get(j).deal_cart.get(k).getBuy_quantity());
                                                }
                                            }

                                        }
                                        delivery_charge = (float) (100 + (total_price * 0.05));
                                        System.out.printf("Total Products Cost = ₹%f/-\n",total_price);
                                        System.out.printf("Delivery Charge = ₹%f/-\n",delivery_charge);
                                        System.out.printf("Grand Total = ₹%f\n",total_price + delivery_charge);
                                        System.out.println("Your Ordered will be delivered within 7-10 days");
                                        cust_list.get(j).setBalance(cust_list.get(j).getBalance() - (total_price + delivery_charge));
                                        cust_list.get(j).cart.clear();
                                        cust_list.get(j).deal_cart.clear();

                                    }
                                }
                            }
                        }

                        else if (n4 == 10){
                            for (int j = 0; j < cust_list.size(); j ++){
                                if (cust_list.get(j).getName().compareTo(a3) == 0){
                                    System.out.printf("Current Status :%s\n", cust_list.get(j).getStatus());
                                    System.out.print("Choose new Status :");
                                    String new_status = scan.next();
                                    scan.nextLine();
                                    if (new_status.compareTo("PRIME") == 0){
                                        cust_list.get(j).setStatus("PRIME");
                                        cust_list.get(j).setBalance(cust_list.get(j).getBalance() - 200);
                                    }
                                    else if (new_status.compareTo("ELITE") == 0){
                                        cust_list.get(j).setStatus("ELITE");
                                        cust_list.get(j).setBalance(cust_list.get(j).getBalance() - 300);
                                    }
                                    else{
                                        System.out.println("Enter Valid Status (Elite/Prime)");
                                    }
                                    System.out.printf("Status updated to %s\n",new_status);
                                    break;
                                }
                            }
                        }
                        else if (n4 == 11){
                            System.out.println("Enter amount to add =");
                            int amount = scan.nextInt();
                            for (Customer customer : cust_list) {
                                if (customer.getName().compareTo(a3) == 0) {
                                    customer.setBalance(customer.getBalance() + amount);
                                    System.out.println("Amount successfully added");
                                    break;
                                }
                            }
                        }
                    }
                }
                else if(a5 == false){
                    System.out.println("You are not registered");
                    continue;
                }
            }
        }
    }
    public static int max(int a, int b, int c ){
        if (a >= b && a >= c){
            return a;
        }
        else if (b >= a && b >= c){
            return b;
        }
        else {
            return c;
        }
    }
    public static void ProductCat(ArrayList<Product> prod_list){
        if (prod_list.size() == 0){
            System.out.println("No products available");
            return;
        }
        for (int j = 0; j < prod_list.size(); j++){
            System.out.printf("%d)\n",j + 1);
            System.out.printf("Category     :%s\n", prod_list.get(j).getCategory());
            System.out.printf("Product Name :%s\n", prod_list.get(j).getName());
            System.out.printf("Product Id   :%f\n", prod_list.get(j).getProduct_id());
            System.out.printf("Price (in ₹) :%d\n", prod_list.get(j).getPrice());
            System.out.printf("Details      :%s\n", prod_list.get(j).getOther_detail());
            System.out.printf("Quatity      :%d\n", prod_list.get(j).getQuantity());
            System.out.print("\n");
        }

    }
}
interface Cust{

}
class Customer implements Cust{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status = "NORMAL";

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private float balance = 1000;
    ArrayList<Product> cart = new ArrayList<Product>();
    ArrayList<Deal> deal_cart = new ArrayList<Deal>();
    ArrayList<Integer> coupons = new ArrayList<Integer>();


    Customer(String naam, String pass){
        this.name = naam;
        this.password = pass;
    }
}

interface Prod{

}
class Product implements Prod{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public float getProduct_id() {
        return product_id;
    }

    public void setProduct_id(float product_id) {
        this.product_id = product_id;
    }

    private float product_id;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    private int category_id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;

    public String getOther_detail() {
        return other_detail;
    }

    public void setOther_detail(String other_detail) {
        this.other_detail = other_detail;
    }

    private String other_detail;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public int getElite_dis() {
        return elite_dis;
    }

    public void setElite_dis(int elite_dis) {
        this.elite_dis = elite_dis;
    }

    private int elite_dis;

    public int getPrime_dis() {
        return prime_dis;
    }

    public void setPrime_dis(int prime_dis) {
        this.prime_dis = prime_dis;
    }

    private int prime_dis;

    public int getNormal_dis() {
        return normal_dis;
    }

    public void setNormal_dis(int normal_dis) {
        this.normal_dis = normal_dis;
    }

    private int normal_dis;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity = 0;

    public int getBuy_quantity() {
        return buy_quantity;
    }

    public void setBuy_quantity(int buy_quantity) {
        this.buy_quantity = buy_quantity;
    }

    private int buy_quantity = 0;

    Product(int cat_id, String cat_naam,String naam,float prod_id,int daam, String details,int sankhya){
        this.category_id = cat_id;
        this.category = cat_naam;
        this.name = naam;
        this.product_id = prod_id;
        this.price = daam;
        this.other_detail = details;
        this.quantity = sankhya;
    }

//    Product(int elite, int prime, int normal){
//        this.elite_dis = elite;
//        this.prime_dis = prime;
//        this.normal_dis = normal;
//    }
}

class Deal{
    Product p1;
    Product p2;

    public int getElite_deal() {
        return elite_deal;
    }

    public void setElite_deal(int elite_deal) {
        this.elite_deal = elite_deal;
    }

    private int elite_deal;

    public int getPrime_deal() {
        return prime_deal;
    }

    public void setPrime_deal(int prime_deal) {
        this.prime_deal = prime_deal;
    }

    private int prime_deal;

    public int getNormal_deal() {
        return normal_deal;
    }

    public void setNormal_deal(int normal_deal) {
        this.normal_deal = normal_deal;
    }

    private int normal_deal;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public int getBuy_quantity() {
        return buy_quantity;
    }

    public void setBuy_quantity(int buy_quantity) {
        this.buy_quantity = buy_quantity;
    }

    private int buy_quantity;



    Deal(Product prod1, Product prod2,int el_deal,int pm_deal,int nm_deal,int qnt){
        this.p1 = prod1;
        this.p2 = prod2;
        this.elite_deal = el_deal;
        this.prime_deal = pm_deal;
        this.normal_deal = nm_deal;
        this.quantity = qnt;

    }


}