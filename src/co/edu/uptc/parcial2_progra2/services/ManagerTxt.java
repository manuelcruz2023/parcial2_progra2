package co.edu.uptc.parcial2_progra2.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import co.edu.uptc.parcial2_progra2.models.Person;

public class ManagerTxt {
    private String path;
    private BufferedReader br;
    private String separator;
    private String fileName;
    private String lineBreak;
    private String comma;

    public void setComma(String comma) {
        this.comma = comma;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setLineBreak(String lineBreak) {
        this.lineBreak = lineBreak;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public List<String> readTxt() throws IOException {
        List<String> content = new ArrayList<>();
        br = new BufferedReader(new FileReader(path));
        String line = "";
        while ((line = br.readLine()) != null) {
            content.add(line);
        }
        content.remove(0);
        return content;
    }

    public int numberQuote(String string) throws IOException {
        int contQuote = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.substring(i, i + 1).equals(comma)) {
                contQuote++;
            }
        }
        return contQuote;
    }

    public List<Person> createListPeople() throws IOException {
        List<String> content = readTxt();
        List<Person> people = new ArrayList<>();
        for (String string : content) {
            Person person = new Person();
            String[] data = string.split(comma);
            person.setIndex(data[0]);
            person.setUserId(data[1]);
            person.setFirstName(data[2]);
            person.setLastName(data[3]);
            person.setSex(data[4]);
            person.setEmail(data[5]);
            person.setPhoneNumber(data[6]);
            person.setDateOfBirth(data[7]);
            person.setJobTitle(data[8]);
            if (numberQuote(string) == 9) {
                person.setJobTitle(data[8] + comma + data[9]);
            }
            people.add(person);
        }
        return people;
    }

    public List<Person> addAge() throws IOException {
        List<Person> people = createListPeople();
        List<Person> newListPeople = new ArrayList<>();
        for (Person person : people) {
            person.setAge(2024 - Integer.parseInt(person.getDateOfBirth().substring(0, 4)));
            newListPeople.add(person);
        }
        return newListPeople;
    }

    public List<Person> earlyChildhood() throws IOException {
        List<Person> people = addAge();
        List<Person> earlyChildhood = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() <= 5) {
                earlyChildhood.add(person);
            }
        }
        return earlyChildhood;
    }

    public List<Person> childhood() throws IOException {
        List<Person> people = addAge();
        List<Person> childhood = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() <= 11 && person.getAge() >= 6) {
                childhood.add(person);
            }
        }
        return childhood;
    }

    public List<Person> adolescence() throws IOException {
        List<Person> people = addAge();
        List<Person> adolescence = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() <= 18 && person.getAge() >= 12) {
                adolescence.add(person);
            }
        }
        return adolescence;
    }

    public List<Person> youth() throws IOException {
        List<Person> people = addAge();
        List<Person> youth = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() <= 26 && person.getAge() >= 14) {
                youth.add(person);
            }
        }
        return youth;
    }

    public List<Person> adulthood() throws IOException {
        List<Person> people = addAge();
        List<Person> adulthood = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() <= 59 && person.getAge() >= 27) {
                adulthood.add(person);
            }
        }
        return adulthood;
    }

    public List<Person> oldAge() throws IOException {
        List<Person> people = addAge();
        List<Person> oldAge = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() >= 60) {
                oldAge.add(person);
            }
        }
        return oldAge;
    }

    public List<String> personToStringList(List<Person> people) throws IOException {
        List<String> stringList = new ArrayList<>();
        for (Person person : people) {
            stringList.add(person.getIndex() + separator + person.getUserId() + separator + person.getFirstName()
                    + separator + person.getLastName() + separator + person.getSex() + separator + person.getEmail()
                    + separator + person.getPhoneNumber() + separator + person.getDateOfBirth() + separator
                    + person.getJobTitle());
        }
        return stringList;
    }

    public void createFile(List<String> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String string : list) {
            writer.write(string + lineBreak);
        }
        writer.close();
    }
}
