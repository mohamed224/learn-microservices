package com.mtrade.clientui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String invoker, Response response) {
        if(response.status() == 400){
            return new ProductBadRequestException("incorrect request");
        }

        else if (response.status() == 404 ) {
            return new ProductNotFoundException(
                    "Product not found. "
            );
        }


        return defaultErrorDecoder.decode(invoker,response);
    }
}
