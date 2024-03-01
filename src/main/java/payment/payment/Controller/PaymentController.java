package payment.payment.Controller;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PaymentController{


    @Autowired
    RazorpayClient razorpayClient;

    @GetMapping("/createOrder")
    String createOrder(@RequestBody Map<String, Object> order)throws RazorpayException {
        JSONObject object = new JSONObject();
        int amount = Integer.parseInt(order.get("amount").toString());
        object.put("amount", amount
        );
        object.put("currency", "INR");
        object.put("receipt","tran123");
        Order x = razorpayClient.Orders.create(object);
        return x.toString();
    }

    @GetMapping("/updateOrder")
    void updateOrder(){
        System.out.println("updated");
    }


}
