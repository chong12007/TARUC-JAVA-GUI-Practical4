package control;

import da.ProgrammeDA;
import model.Programme;

public class MaintainProgrammeControl {

    private ProgrammeDA progDA;

    public MaintainProgrammeControl() {
        progDA = new ProgrammeDA();
    }

    public Programme createRecord(String code, String name, String faculty) {
        //return 3 value
        //go to create record method
        return progDA.createRecord(code, name, faculty);
    }

    public Programme selectRecord(String code) {
        return progDA.getRecord(code);
    }

    public Boolean compareRecord(String code) {
        return progDA.compareSameInDB(code);
    }

    public Programme updateRecord(String code, String name, String faculty) {
        //return 3 value
        //go to create record method
        return progDA.updateRecord(code, name, faculty);
    }

    public Programme deleteRecord(String code) {
        return progDA.deleteRecord(code);

    }
}
