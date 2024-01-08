package edu.najah.cap.data.exportdatafeature.converter.intf;

import edu.najah.cap.exceptions.InvalidUserDataException;

import java.util.List;

public interface IConverter {
    byte[] convert(List<String> data) throws InvalidUserDataException;
}
