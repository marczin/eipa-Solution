package pl.marcinrosol.eipa.utils;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.io.OutputStream;

public class RequestUtils {

    public static int executeRequest(Request request) {
        return executeRequest(request, null);
    }

    public static int executeRequest(Request request, final OutputStream out) {
        try {
            return request.execute().handleResponse(response -> {
                if (out != null && response.getEntity() != null) {
                    response.getEntity().writeTo(out);
                }
                return response.getStatusLine().getStatusCode();
            });
        } catch (IOException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
