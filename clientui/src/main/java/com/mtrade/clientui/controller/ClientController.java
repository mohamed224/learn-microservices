package com.mtrade.clientui.controller;

import com.mtrade.clientui.beans.OrderBean;
import com.mtrade.clientui.beans.PaymentBean;
import com.mtrade.clientui.beans.ProductBean;
import com.mtrade.clientui.proxies.MicroserviceOrdersProxy;
import com.mtrade.clientui.proxies.MicroservicePaymentsProxy;
import com.mtrade.clientui.proxies.MicroserviceProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class ClientController {

    private MicroserviceProductProxy microserviceProductProxy;
    private MicroserviceOrdersProxy microserviceOrdersProxy;
    private MicroservicePaymentsProxy microservicePaymentsProxy;

    @Autowired
    public ClientController(MicroserviceProductProxy microserviceProductProxy,
                            MicroserviceOrdersProxy microserviceOrdersProxy,
                            MicroservicePaymentsProxy microservicePaymentsProxy) {
        this.microserviceProductProxy = microserviceProductProxy;
        this.microserviceOrdersProxy = microserviceOrdersProxy;
        this.microservicePaymentsProxy = microservicePaymentsProxy;
    }

    @RequestMapping("/")
    public String home(Model model){
        List<ProductBean> products = microserviceProductProxy.productsList();
        model.addAttribute("products", products);
        return "Home";
    }

    @RequestMapping("/details-product/{id}")
    public String productSheet(@PathVariable int id , Model model){
        ProductBean product = microserviceProductProxy.findProductById(id);
        model.addAttribute("product", product);
        return "productSheet";

    }

    @RequestMapping("/order-product/{productId}/{amount}")
    public String toOrder(@PathVariable int productId , @PathVariable Double amount , Model model){

        OrderBean orderBean = new OrderBean();

        orderBean.setProductId(productId);
        orderBean.setQuantity(1);
        orderBean.setOrderDate(new Date());

       OrderBean orderAdded = microserviceOrdersProxy.addOrder(orderBean);

        model.addAttribute("order", orderAdded);
        model.addAttribute("amount",amount);

        return "payment";

    }

    @RequestMapping("/pay-order/{orderId}/{amount}")
    public String payAnOrder(@PathVariable int orderId , @PathVariable Double amount , Model model){
        PaymentBean paymentBean = new PaymentBean();

        paymentBean.setOrderId(orderId);
        paymentBean.setAmount(amount);
        paymentBean.setCardNumber(cardNumber());

        ResponseEntity<PaymentBean> paymentBeanResponseEntity = microservicePaymentsProxy.payAnOrder(paymentBean);

        Boolean paymentAccepted = false;

        if(paymentBeanResponseEntity.getStatusCode() == HttpStatus.CREATED){
            paymentAccepted = true;
        }

        model.addAttribute("paymentOk" ,paymentAccepted );
        return "Confirmation";

    }

    public Long cardNumber(){
        return ThreadLocalRandom.current().nextLong(1000000000000000L,9000000000000000L);
    }


}
