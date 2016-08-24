package parser;

import com.google.gson.Gson;
import shop.Cart;

import java.io.*;

public class JsonParser implements Parser {

    private Gson gson = GsonUtils.getGson();

    public void writeToFile(Cart cart) {
        try (FileWriter writer = new FileWriter(cart.getCartName())) {
            writer.write(gson.toJson(cart));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Cart readFromFile(File file) {
        BufferedReader reader = null;
        Cart cart = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            cart = gson.fromJson(reader.readLine(), Cart.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cart;
    }
}
