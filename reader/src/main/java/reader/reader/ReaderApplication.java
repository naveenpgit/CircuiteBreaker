package reader.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reader.reader.service.BookService;

@RestController
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ReaderApplication {
    @Autowired
    BookService bookService;

    @RequestMapping("/to-read")
    public String readingList() {
        return bookService.readingList();
    }

    public static void main(String[] args) {
        SpringApplication.run(ReaderApplication.class, args);
    }
}
