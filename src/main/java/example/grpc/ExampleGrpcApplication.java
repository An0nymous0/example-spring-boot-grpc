package example.grpc;

import com.google.common.base.Stopwatch;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExampleGrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleGrpcApplication.class, args);
    }

    @GetMapping("/")
    public ResponseEntity test() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8081)
                .usePlaintext()
                .build();
        Stopwatch stopwatch = Stopwatch.createStarted();
        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Ga0x")
                .setLastName("gRPC")
                .build());
        System.out.println(stopwatch.stop());
        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
        return ResponseEntity.ok(helloResponse.getGreeting());
    }
}
