package Logging.Service;

import org.springframework.stereotype.Service;

@Service
public class FunctionExp {

    public double power(int base, int exponent) {
        if (base > 0 && exponent > 0) {
            return Math.pow(base, exponent);
        } else throw new Error("Invalid value of method");
    }
}
