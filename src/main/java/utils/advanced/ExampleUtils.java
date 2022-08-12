package utils.advanced;

import exceptions.InvalidEmployeeIdException;
import exceptions.NameTooShortException;

public class ExampleUtils {

    public Integer validateEmployeeId(String employeeId) throws InvalidEmployeeIdException {
        try {
            Integer id = Integer.parseInt(employeeId);
            return id;
        }
        catch (NumberFormatException e) {
            throw new InvalidEmployeeIdException();
        }
    }

    public void validateEmployeeName(String firstName, String surname) throws NameTooShortException {
        if (firstName.length() + surname.length() < 6) {
            throw new NameTooShortException();
        }
    }


}
