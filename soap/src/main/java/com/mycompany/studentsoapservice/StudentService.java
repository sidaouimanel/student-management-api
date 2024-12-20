package com.mycompany.studentsoapservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebService
public class StudentService {

    private static final Logger LOGGER = Logger.getLogger(StudentService.class.getName());
    private static final List<Student> students = new ArrayList<>();

    static {
        // Charger les donn�es JSON lors de l'initialisation
        loadStudentsFromJson();
    }

    // M�thode pour charger les �tudiants depuis le fichier JSON
    private static void loadStudentsFromJson() {
        try (InputStream inputStream = StudentService.class.getClassLoader().getResourceAsStream("students_data.json")) {
            if (inputStream == null) {
                LOGGER.severe("Le fichier JSON n'a pas �t� trouv�.");
                return;
            }

            // Utiliser Gson pour parser le JSON en liste d'�tudiants
            Type listType = new TypeToken<List<Student>>() {}.getType();
            try (InputStreamReader reader = new InputStreamReader(inputStream)) {
                List<Student> studentList = new Gson().fromJson(reader, listType);
                if (studentList != null) {
                    students.addAll(studentList);
                    LOGGER.info("Donn�es charg�es avec succ�s : " + students.size() + " �tudiants.");
                } else {
                    LOGGER.severe("Aucune donn�e valide trouv�e dans le fichier JSON.");
                }
            }
        } catch (Exception e) {
            LOGGER.severe("Erreur lors du chargement du fichier JSON : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // M�thode pour r�cup�rer tous les �tudiants
    @WebMethod
    public List<Student> getAllStudents() {
        if (students.isEmpty()) {
            LOGGER.warning("Aucun �tudiant trouv�.");
        }
        return new ArrayList<>(students); // Retourne une copie pour prot�ger la liste originale
    }

    // M�thode pour ajouter un �tudiant avec validation
    @WebMethod
    public String addStudent(Student student) {
        if (!isValidStudent(student)) {
            return "Invalid student data: Ensure all fields have valid values.";
        }
        if (students.stream().anyMatch(s -> s.getStudentId() == student.getStudentId())) {
            return "Student with this ID already exists.";
        }
        students.add(student);
        LOGGER.info("Student added successfully: " + student);
        return "Student added successfully!";
    }

    // M�thode pour r�cup�rer un �tudiant par son ID
    @WebMethod
    public Student getStudentById(int studentId) {
        if (studentId <= 0) {
            LOGGER.warning("Invalid student ID: " + studentId);
            return null;
        }
        return students.stream()
                       .filter(s -> s.getStudentId() == studentId)
                       .findFirst()
                       .orElse(null);
    }

    // M�thode pour supprimer un �tudiant par son ID
    @WebMethod
    public String deleteStudentById(int studentId) {
        if (studentId <= 0) {
            return "Invalid student ID: ID must be greater than 0.";
        }
        boolean removed = students.removeIf(s -> s.getStudentId() == studentId);
        if (removed) {
            LOGGER.info("Student deleted successfully with ID: " + studentId);
            return "Student deleted successfully!";
        } else {
            LOGGER.warning("Student not found with ID: " + studentId);
            return "Student not found.";
        }
    }

    // M�thode pour valider les donn�es d'un �tudiant
    private boolean isValidStudent(Student student) {
        if (student == null) return false;
        if (student.getStudentId() <= 0) return false;
        if (student.getStudyHoursPerDay() < 0 || student.getStudyHoursPerDay() > 24) return false;
        if (student.getExtracurricularHoursPerDay() < 0 || student.getExtracurricularHoursPerDay() > 24) return false;
        if (student.getSleepHoursPerDay() < 0 || student.getSleepHoursPerDay() > 24) return false;
        if (student.getSocialHoursPerDay() < 0 || student.getSocialHoursPerDay() > 24) return false;
        if (student.getPhysicalActivityHoursPerDay() < 0 || student.getPhysicalActivityHoursPerDay() > 24) return false;
        if (student.getGpa() < 0.0 || student.getGpa() > 4.0) return false;
        if (student.getStressLevel() == null || student.getStressLevel().isEmpty()) return false;
        return true;
    }
}
