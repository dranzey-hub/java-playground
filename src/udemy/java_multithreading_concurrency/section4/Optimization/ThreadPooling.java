package udemy.java_multithreading_concurrency.section4.Optimization;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Optimizing throughput (more tasks in time).
 *
 * In this example we use the technique of Thread Pooling, which consists on having a set of threads and re-utilizing
 *  them to perform tasks that queue up waiting to be executed on free threads.
 *
 *  Notice that, unlike in the latency optimization, there is practically no overhead for having multi-threading
 *   since tasks are independent of each other and we only care about running as much tasks and as fast as possible
 */
public class ThreadPooling
{
    private static final String INPUT = "./rsc/war_and_peace.txt";
    private static final int NO_OF_THREADS = 16;

    public static void main(String[] args) throws IOException
    {
        String text = new String(Files.readAllBytes(Paths.get(INPUT)));

        startServer(text);
    }

    public static void startServer(String text) throws IOException
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/search", new WordCountHandler(text));

        Executor executor = Executors.newFixedThreadPool(NO_OF_THREADS);

        server.setExecutor(executor);
        server.start();
    }


    private static class WordCountHandler implements HttpHandler
    {
        private String text;

        public WordCountHandler(String text){
            this.text = text;
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String query = httpExchange.getRequestURI().getQuery();
            String [] keyValue = query.split("=");
            String action = keyValue[0];
            String word = keyValue[1];
            if(!action.equals("word")){
                httpExchange.sendResponseHeaders(400, 0);
                return;
            }

            long count = countWords(word);

            byte [] response = Long.toString(count).getBytes();
            httpExchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();
        }

        private long countWords(String word){
            long count = 0;
            int index = 0;
            while(index>=0){
                index = text.indexOf(word, index);

                if(index>=0){
                    count++;
                    index++;
                }
            }
            return count;
        }
    }

}
