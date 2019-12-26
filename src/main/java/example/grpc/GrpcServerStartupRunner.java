package example.grpc;

import example.grpc.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.util.TransmitStatusRuntimeExceptionInterceptor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GrpcServerStartupRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ServerBuilder serverBuilder = ServerBuilder
                .forPort(8081)
                .addService(new HelloServiceImpl());

        Server server = serverBuilder.build();
        serverBuilder.intercept(TransmitStatusRuntimeExceptionInterceptor.instance());
        server.start();
        startDaemonAwaitThread(server);
    }

    private void startDaemonAwaitThread(Server server) {
        Thread awaitThread = new Thread(() -> {
            try {
                server.awaitTermination();
            } catch (InterruptedException ignore) {

            }
        });
        awaitThread.setDaemon(false);
        awaitThread.start();
    }
}
