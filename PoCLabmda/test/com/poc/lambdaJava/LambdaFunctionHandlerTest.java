package com.poc.lambdaJava;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking Lambda function handler.
 */
public class LambdaFunctionHandlerTest {

    private static LambdaRequest input;

    @BeforeClass
    public static void createInput() throws IOException {

        input = null;
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("Function Name");

        return ctx;
    }

    @Test
    public void testLambdaFunctionHandler() {
        LambdaFunctionHandler handler = new LambdaHandler();
        Context ctx = createContext();

        LambdaResponse output = handler.handleRequest(input, ctx);

        // TODO: validate output here if needed.
        if (output != null) {
            System.out.println(output.toString());
        }
    }
}
