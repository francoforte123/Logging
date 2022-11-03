package Logging.Controller;

import Logging.Service.FunctionExp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Value("{numberOne}")
    private String numberOne;

    @Value("{numberTwo}")
    private String numberTwo;

    @Autowired
    FunctionExp functionExp;


    @GetMapping("/")
    public String getMessage(){
        logger.info("this is a message of localhost");
        return "welcome!";
    }


    @GetMapping("/exp")
    public double getPowerByTwoNumber(){
        logger.info("this message of prod");
        int value1= Integer.parseInt(numberOne);
        int value2= Integer.parseInt(numberTwo);
        logger.info("method power: " + numberOne + " " + numberTwo);
        double resultOfMethod= functionExp.power(value1, value2);
        logger.info("result of method is= " + resultOfMethod);
        return resultOfMethod;
    }


    @GetMapping("/get-errors")
    public void getError(){
        Error error= new Error("message of error");
        logger.error("this is a message of error", error);
    }
}
