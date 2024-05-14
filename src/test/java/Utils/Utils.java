package Utils;

import Configuration.EmployeeModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void saveEmployee(EmployeeModel model) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/employees.json";
        JSONParser parser = new JSONParser();
        JSONArray employeeArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject employeeObject = new JSONObject();
        employeeObject.put("firstName", model.getFirstName());
        employeeObject.put("lastName", model.getLastName());
        employeeObject.put("username", model.getUsername());
        employeeObject.put("password", model.getPassword());

        employeeArray.add(employeeObject);
        FileWriter fileWriter = new FileWriter(fileLocation);
        fileWriter.write(employeeArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    public static JSONObject getEmployee() throws IOException, ParseException {
        String fileLocation = "./src/test/resources/employees.json";
        JSONParser parser = new JSONParser();
        JSONArray employeeArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject employeeObject = (JSONObject) employeeArray.get(employeeArray.size()-1);
        return employeeObject;
    }

    public static void main(String[] args) throws IOException, ParseException {
        //saveEmployee("jamal", "kodu", "kodu1", "kodu1234");
    }
}
