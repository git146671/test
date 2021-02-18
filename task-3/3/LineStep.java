public class LineStep implements ILineStep {
    int step;
    @Override
    public ProductPart buildProductPart() {
        if (step == 0) {
            System.out.println("БЕРЕМ_КУЗОВ_ДЛЯ_УСТАНОВКИ");
            step++;
            return new Body();
        }
        if (step == 1) {
            System.out.println("БЕРЕМ_ШАССИ_ДЛЯ_УСТАНОВКИ");
            step++;
            return new Chassis();
        }
        if (step == 2) {
            System.out.println("БЕРЕМ_ДВИГАТЕЛЬ_ДЛЯ_УСТАНОВКИ");
            step = 0;
            return new Engine();
        }
        return null;
    }
}
