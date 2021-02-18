public class Test {
    public static void main(String[] args) {
        System.out.println("    CAR_ASSEMBLY_LINE");
        Product car = new Product();
        System.out.println("  ИЗДЕЛИЕ_ДО_СБОРОЧНОЙ_ЛИНИИ(ЗАГОТОВКА):");
        System.out.println("   КУЗОВ - " + car.body);
        System.out.println("   ШАССИ - " + car.chassis);
        System.out.println("   ДВИГАТЕЛЬ - " + car.engine);
        LineStep lineStep = new LineStep();
        AssemblyLine assemblyLine = new AssemblyLine(lineStep.buildProductPart(), lineStep.buildProductPart(), lineStep.buildProductPart());
        car = assemblyLine.assembleProduct(car);
        System.out.println("  ИЗДЕЛИЕ_ПОСЛЕ_СБОРОЧНОЙ_ЛИНИИ: ");
        System.out.println("   КУЗОВ - " + car.body);
        System.out.println("   ШАССИ - " + car.chassis);
        System.out.println("   ДВИГАТЕЛЬ - " + car.engine);
    }
}
