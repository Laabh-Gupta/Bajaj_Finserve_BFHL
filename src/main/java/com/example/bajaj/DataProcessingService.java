package com.example.bajaj;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataProcessingService {

    public DataResponse process(DataRequest request) {
        DataResponse response = new DataResponse();
        List<String> inputData = request.getData();

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        int sum = 0;
        StringBuilder alphaChars = new StringBuilder();

        for (String item : inputData) {
            try {
                int num = Integer.parseInt(item);
                sum += num;
                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            } catch (NumberFormatException e) {
                if (item.matches("[a-zA-Z]+")) {
                    alphabets.add(item.toUpperCase());
                    alphaChars.append(item);
                } else {
                    specialCharacters.add(item);
                }
            }
        }

        // Set personal details
        response.setSuccess(true); // [cite: 26]
        response.setUserId("laabh_gupta_26082004"); // [cite: 23]
        response.setEmail("laabh.gupta2022@vitstudent.ac.in"); // [cite: 7]
        response.setRollNumber("22BAI1328"); // [cite: 8]

        // Set processed data
        response.setOddNumbers(oddNumbers); // [cite: 10]
        response.setEvenNumbers(evenNumbers); // [cite: 9]
        response.setAlphabets(alphabets); // [cite: 11]
        response.setSpecialCharacters(specialCharacters); // [cite: 12]
        response.setSum(String.valueOf(sum)); // [cite: 13, 39]

        // Logic for concatenation [cite: 14]
        String reversedChars = new StringBuilder(alphaChars.toString()).reverse().toString();
        StringBuilder alternatingCaps = new StringBuilder();
        for (int i = 0; i < reversedChars.length(); i++) {
            char c = reversedChars.charAt(i);
            if (i % 2 == 0) {
                alternatingCaps.append(Character.toUpperCase(c));
            } else {
                alternatingCaps.append(Character.toLowerCase(c));
            }
        }
        response.setConcatString(alternatingCaps.toString());

        return response;
    }
}