package com.example.temperatureconverter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemperatureConverterController {

    @PostMapping("/convert")
    public String convertTemperature(
            @RequestParam("temperature") double temperature,
            @RequestParam("conversionType") String conversionType,
            Model model) {
        
        double result = 0;
        String conversionText = "";

        // Perform conversion based on the selected conversion type
        switch (conversionType) {
            case "celsiusToFahrenheit":
                result = (temperature * 9/5) + 32;
                conversionText = temperature + "°C = " + result + "°F";
                break;
            case "fahrenheitToCelsius":
                result = (temperature - 32) * 5/9;
                conversionText = temperature + "°F = " + result + "°C";
                break;
            case "celsiusToKelvin":
                result = temperature + 273.15;
                conversionText = temperature + "°C = " + result + " K";
                break;
            case "kelvinToCelsius":
                result = temperature - 273.15;
                conversionText = temperature + " K = " + result + "°C";
                break;
            case "fahrenheitToKelvin":
                result = (temperature - 32) * 5/9 + 273.15;
                conversionText = temperature + "°F = " + result + " K";
                break;
            case "kelvinToFahrenheit":
                result = (temperature - 273.15) * 9/5 + 32;
                conversionText = temperature + " K = " + result + "°F";
                break;
            default:
                conversionText = "Invalid conversion type!";
        }

        // Add the result to the model to pass it to the view (HTML page)
        model.addAttribute("result", conversionText);
        return "index"; // Return the name of the HTML page to render
    }
}
