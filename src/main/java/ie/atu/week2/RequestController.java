package ie.atu.week2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
    @GetMapping("/greet/{name}")
    public String greetByName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/details")
    public String details(@RequestParam String name, @RequestParam int age) {
        return "Name: " + name + ", Age: " + age;
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String operation) {
        double result = 0;
        String message = "Invalid operation";

        switch (operation.toLowerCase()) {
            case "add":
                result = num1 + num2;
                message = "Operation: add";
                break;
            case "subtract":
                result = num1 - num2;
                message = "Operation: subtract";
                break;
            case "multiply":
                result = num1 * num2;
                message = "Operation: multiply";
                break;
            case "divide":
                if (num2 == 0) {
                    return "{\"operation\": \"divide\", \"message\": \"Cannot divide by zero\"}";
                } else {
                    result = num1 / num2;
                    message = "Operation: divide";
                }
                break;
            default:
                return "{\"operation\": \"unknown\", \"message\": \"Invalid operation\"}";
        }

        return "{\"operation\": \"" + operation + "\", \"total\": " + result + "}";
    }
}