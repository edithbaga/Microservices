package com.poc.lambdaJava;

import java.util.Date;
import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHandler implements RequestHandler<LambdaRequest, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest input, Context context) {
        context.getLogger().log("Input: " + input);
        LambdaResponse lambdaResponse = new LambdaResponse();
        try {
			lambdaResponse.setResponseMessage("User " + input.getName() + " Response Time : " + new Date());
			lambdaResponse.setTransactionID(UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
			lambdaResponse.setResponseMessage(e.getMessage());
		}
        context.getLogger().log("Response : " + lambdaResponse);
        return lambdaResponse;
    }

}
