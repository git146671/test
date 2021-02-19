public class Test {
    public static void main(String[] args) {
        SoftwareDevelopCompany company1 = new SoftwareDevelopCompany();
        company1.name = "Рога и копыта";
        Director director = new Director();
        director.name = "Иванов Иван";
        director.phoneNumber = "353454635";
        FirstClassSpecialist fCS1 = new FirstClassSpecialist();
        fCS1.name = "Петя";
        FirstClassSpecialist fCS2 = new FirstClassSpecialist();
        fCS2.name = "Коля";
        SecondClassSpecialist sCS1 = new SecondClassSpecialist();
        sCS1.name = "Маша";
        SecondClassSpecialist sCS2 = new SecondClassSpecialist();
        sCS2.name = "Катя";
        ThirdClassSpecialist tCs1 = new ThirdClassSpecialist();
        tCs1.name = "Юля";
        ThirdClassSpecialist tCs2 = new ThirdClassSpecialist();
        tCs2.name = "Сережа";
        ThirdClassSpecialist tCs3 = new ThirdClassSpecialist();
        tCs3.name = "Михаил Петрович";
        Service serv1 = new Service();
        serv1.name = "Уборщица";
        company1.employees.add(director);
        company1.employees.add(fCS1);
        company1.employees.add(fCS2);
        company1.employees.add(sCS1);
        company1.employees.add(sCS2);
        company1.employees.add(tCs1);
        company1.employees.add(tCs2);
        company1.employees.add(tCs3);
        company1.employees.add(serv1);
        System.out.println(company1.totalSalaryCalculation());
    }
}
