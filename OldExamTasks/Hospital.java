package OldExamTasks;

import java.util.*;

public class Hospital {
    private static int nextRoom = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Integer, TreeSet<String>>> departmentMap = new HashMap<>();
        Map<String, TreeSet<String>> doctorInfo = new HashMap<>();
        Map<String,List<String>> depAndPatients = new HashMap<>();

        String line = scanner.nextLine();
        while (!"Output".equals(line)) {
            String[] hospitalData = line.split("\\s+");
            String department = hospitalData[0];
            String doctor = hospitalData[1] + " " + hospitalData[2];
            String patient = hospitalData[3];

            doctorInfo.putIfAbsent(doctor, new TreeSet<>());
            doctorInfo.get(doctor).add(patient);

            int roomCount = 1;
            if (!departmentMap.containsKey(department)) {
                depAndPatients.put(department,new ArrayList<>());
                depAndPatients.get(department).add(patient);

                departmentMap.put(department, new HashMap<>());
                Map<Integer, TreeSet<String>> value = departmentMap.get(department);
                value.put(roomCount, new TreeSet<>());
                value.get(roomCount).add(patient);
                departmentMap.put(department, value);
            } else {
                depAndPatients.get(department).add(patient);
                if (departmentMap.get(department).size() == 20) {
                    break;
                }
                if (departmentMap.get(department).get(roomCount).size() < 3) {
                    departmentMap.get(department).get(roomCount).add(patient);
                } else {
                    Map<Integer, TreeSet<String>> value = departmentMap.get(department);
                    value.put(++nextRoom, new TreeSet<>());
                    value.get(nextRoom).add(patient);
                    departmentMap.put(department, value);
                }
            }
            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!"End".equals(line)) {
            String[] command = line.split("\\s+");

            if (command.length == 1) {
                depAndPatients.get(command[0]).forEach(System.out::println);
            } else {
                String departmentOrDoctorName = command[0];
                String roomOrSecondNameDoctor = command[1];

                if (Character.isDigit(roomOrSecondNameDoctor.charAt(0))){
                    int room = Integer.parseInt(roomOrSecondNameDoctor);
                    Map<Integer,TreeSet<String>> depAndCurrentRoom = departmentMap.get(departmentOrDoctorName);
                    for (String patient : depAndCurrentRoom.get(room)) {
                        System.out.println(patient);
                    }
                }else {
                    String doctor = departmentOrDoctorName + " " + roomOrSecondNameDoctor;
                    doctorInfo.get(doctor).forEach(System.out::println);
                }
            }
            line = scanner.nextLine();
        }
    }
}
