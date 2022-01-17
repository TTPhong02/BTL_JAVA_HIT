package Controller;

import Basic.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private Person person = new Person();
    private FileController fileController = new FileController();

    public PersonController() {
    }

    public PersonController(Person person, FileController fileController) {
        this.person = person;
        this.fileController = fileController;
    }
    public List<Person> readPersons(String namefile){
        fileController.OpenFileToRead(namefile);
        List<Person> personList = new ArrayList<>();

        while(fileController.getScanner().hasNext()){
            String information = fileController.getScanner().nextLine();
            String[] data = information.split("\\|");
            personList.add(new Person(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),data[5],data[6],data[7],data[8]));
        }
        fileController.CloseFileAfterRead();
        return personList;
    }
    public List<Person> writePersons(List<Person> personList, String namefile){
        fileController.OpenFileToWrite(namefile);
        for(Person person : personList){
            fileController.getPrintWriter().println(person.getId()+ "|" +person.getUserName() + "|" + person.getPassword()+ "|" +person.getNamePerson()+"|"+person.getAge()+"|"+person.getAddress()+"|"+person.getPhoneNumber()+"|"+person.getEmail()+"|"+person.getPermission());
        }
        fileController.CloseFileAfterWrite();
        return personList;
    }
//    public void closeUse
}
