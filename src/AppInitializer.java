import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Orders;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCusID("C001");
        customer.setCusName("Chamith");
        customer.setCusAddress("Panadura");
        customer.setDateOfBirth(Date.valueOf("2000-10-25"));

        Orders order = new Orders();
        order.setOrderID("O001");
        order.setOrderDate("2021-01-25");
        order.setOrderTime("11:00:00");

        Item item1 = new Item();
        item1.setItemID("I001");
        item1.setDescription("Rice");
        item1.setUnitPrice("110.00");
        item1.setQty("50");

        Item item2 = new Item();
        item2.setItemID("I002");
        item2.setDescription("parippu");
        item2.setUnitPrice("85.00");
        item2.setQty("35");

        Item item3 = new Item();
        item3.setItemID("I003");
        item3.setDescription("saman");
        item3.setUnitPrice("225.00");
        item3.setQty("20");

        ArrayList<Orders> orders = new ArrayList<>();
        orders.add(order);

        customer.setOrders(orders);

        order.setCustomer(customer);

        item1.setOrders(orders);
        item2.setOrders(orders);
        item3.setOrders(orders);

        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        order.setItems(items);

        session.save(customer);
        session.save(item1);
        session.save(item2);
        session.save(item3);
        session.save(order);

        transaction.commit();
        session.close();

//        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("lk/ijse/hibernate/view/dashBoardForm.fxml"))));
//        primaryStage.setTitle("Thogakade");
//        primaryStage.centerOnScreen();
//        primaryStage.show();
    }
}
